package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    private final AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable int accountId){
        Account account = accountDao.getAccountById(accountId);
        if (account == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        } else {
            return account;
        }
    }

    @GetMapping("/user/{userId}")
    public Account getAccountByUserId(@PathVariable int userId) {
        Account account = accountDao.getAccountByUserId(userId);
        if (account == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        } else {
            return account;
        }

    }

    @PutMapping("/{accountId}/withdraw/{amount}")
    public Account withdrawFromAccount(@PathVariable int accountId, @PathVariable BigDecimal amount) {
        int currentUserAccountId = accountDao.getAccountById(accountId).getAccountId();

        Account account = accountDao.withdrawFromAccount(currentUserAccountId, amount );

        return account;
    }

    @PutMapping("{accountId}/deposit/{amount}")
    public Account depositToAccount(@PathVariable int accountId, @PathVariable BigDecimal amount) {
        int currentUserAccountId = accountDao.getAccountById(accountId).getAccountId();
        Account account = accountDao.depositToAccount(currentUserAccountId, amount);

        return account;
    }
}
