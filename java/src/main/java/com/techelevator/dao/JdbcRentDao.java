package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Account;
import com.techelevator.model.Rent;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRentDao implements RentDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRentDao(AccountDao accountDao, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rent> getAllRents() {
        List<Rent> rents = new ArrayList<>();
        String sql = "SELECT rent_id, account_from, account_to, amount FROM rent";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Rent rent = mapRowToRent(results);
            rents.add(rent);
        }

        return rents;
    }

    @Override
    public Rent getRentById(int rentId) {
        Rent rent = null;
        String sql = "SELECT rent_id, account_from, account_to, amount FROM rent WHERE rent_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, rentId);
            if (results.next()) {
                rent = mapRowToRent(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }

        return rent;
    }

    @Override
    public void save(Rent newRent, int renterAccountId) {
        String sql = "INSERT INTO rent (account_from, account_to, amount) " +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, newRent.getAccountFrom(), newRent.getAccountTo(), newRent.getAmount());

        /*String sql2 = "UPDATE account SET balance =(SELECT balance - rent.amount\n" +
                "FROM account\n" +
                "JOIN rent\n" +
                "ON rent.account_from = account.account_id\n" +
                "WHERE account.account_id = ?)";
        jdbcTemplate.update(sql2, renterAccountId );*/

    }

    @Override
    public void updade(int rentId, Account account) {
        String sql = "UPDATE account SET balance =(SELECT balance - rent.amount\n" +
                "FROM account\n" +
                "JOIN rent\n" +
                "ON rent.account_from = account.account_id\n" +
                "WHERE account.account_id = ?)";
        jdbcTemplate.update(sql, account.getAccountId() );
    }

    @Override
    public void createRentPayment(int rentId, int accountId) {

    }



    private Rent mapRowToRent(SqlRowSet rs) {
        Rent rent = new Rent();

        rent.setRentId(rs.getInt("rent_id"));
        rent.setAccountFrom(rs.getInt("account_from"));
        rent.setAccountTo(rs.getInt("account_to"));
        rent.setAmount(rs.getBigDecimal("amount"));

        return rent;
    }
}
