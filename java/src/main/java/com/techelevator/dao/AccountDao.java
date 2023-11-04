package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.Rent;

import java.math.BigDecimal;

public interface AccountDao {

    Account getAccountById(int accountId);
    Account getAccountByUserId(int userId);
    Account withdrawFromAccount( int accountId, BigDecimal amount);
    Account depositToAccount(int accountId, BigDecimal amount);
    void accountTransaction(int accountFrom, int accountTo, BigDecimal amount);

}
