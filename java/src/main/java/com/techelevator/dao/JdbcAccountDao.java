package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Account;
import com.techelevator.model.Rent;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class JdbcAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public Account getAccountById(int accountId) {
        Account account = null;

        String sql = "SELECT account_id, user_id, balance FROM account WHERE account_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            if (results.next()) {
                account = mapRowToAccount(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }

        return account;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        Account account = null;

        String sql = "SELECT account_id, user_id, balance FROM account WHERE user_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if(results.next()){
                account = mapRowToAccount(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }
        return  account;
    }

    @Override
    public Account withdrawFromAccount(int accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        BigDecimal balance = account.getBalance();
        BigDecimal remainingBalance = balance.subtract(amount);

        String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
        try {

            jdbcTemplate.update(sql, remainingBalance, accountId );

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }

        return account;
    }

    @Override
    public Account depositToAccount(int accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);
        BigDecimal balance = account.getBalance();
        BigDecimal newBalance = balance.add(amount);

        String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
        try {

            jdbcTemplate.update(sql, newBalance, accountId );

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }

        return account;
    }

    @Override
    public void accountTransaction(int accountFrom, int accountTo, BigDecimal amount) {

        Account renter = getAccountById(accountFrom);
        Account owner = getAccountById(accountTo);


        BigDecimal renterBalance = renter.getBalance();
        BigDecimal ownerBalance = owner.getBalance();

        BigDecimal renterRemainingBalance = renterBalance.subtract(amount);
        BigDecimal ownerNewBalance = ownerBalance.add(amount);

        String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
        String sql2 = "UPDATE account SET balance = ? WHERE account_id = ?";
        try {

            jdbcTemplate.update(sql, renterRemainingBalance, accountFrom);

            jdbcTemplate.update(sql2, ownerNewBalance, accountTo);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server / database");
        }


    }


    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();
        account.setAccountId(rowSet.getInt("account_id"));
        account.setUserId(rowSet.getInt("user_id"));
        account.setBalance(rowSet.getBigDecimal("balance"));
        return account;
    }
}
