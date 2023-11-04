package com.techelevator.controller;


import com.techelevator.dao.AccountDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.RentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Account;
import com.techelevator.model.Rent;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rent")
public class RentController {

    private final RentDao rentDao;
    private final AccountDao accountDao;
    private final PropertyDao propertyDao;
    private final UserDao userDao;

    public RentController(RentDao rentDao, AccountDao accountDao, PropertyDao propertyDao, UserDao userDao) {
        this.rentDao = rentDao;
        this.accountDao = accountDao;
        this.propertyDao = propertyDao;
        this.userDao = userDao;
    }

    @GetMapping
    public List<Rent> getAllRents(){
        List<Rent> rentList = rentDao.getAllRents();

        if(rentList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No rents found");
        }else{
            return rentList;
        }

    }

    @GetMapping("/{rentId}")
    public Rent getRentById(@PathVariable int rentId){
        Rent rent = rentDao.getRentById(rentId);
        if(rent == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No property found");
        }else{
            return rent;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/renterAccountId")
    public void save(@RequestBody Rent newRent, @PathVariable int renterAccountId){

        /*Account payingAccount = accountDao.getAccountById(renterAccountId);
        Account receivingAccount = accountDao.getAccountById(landlordAccountId);
        BigDecimal currentBalance = payingAccount.getBalance();
        BigDecimal rentPayment = newRent.getAmount();


        if(rentPayment.equals(BigDecimal.ZERO)){
            System.out.println("Invalid amount");
        } else if (rentPayment == null || rentPayment.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("invalid amount of money to send!");
        }else if(currentBalance.compareTo(rentPayment) < 0){
            System.out.println("Insufficient Funds!");
        }else{

            payingAccount.setBalance(payingAccount.getBalance().subtract(rentPayment));
            receivingAccount.setBalance(receivingAccount.getBalance().add(rentPayment));

            //Update database
            accountDao.withdrawFromAccount(payingAccount.getAccountId(), rentPayment);
            accountDao.depositToAccount(receivingAccount.getAccountId(), rentPayment);
        }

        Rent rent = new Rent(payingAccount.getAccountId(), receivingAccount.getAccountId(), rentPayment);
*/

        rentDao.save(newRent, renterAccountId);
    }
}
