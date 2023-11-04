package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.Rent;

import java.util.List;

public interface RentDao {
    List<Rent> getAllRents();
    Rent getRentById(int rentId);
    void save(Rent newRent, int renterAccountId);
    void updade(int rentId, Account account);

    void createRentPayment(int rentId, int accountId);
}
