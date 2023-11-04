package com.techelevator.model;

import java.math.BigDecimal;

public class Rent {
    private int rentId;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;

    public Rent() {
    }

    public Rent(int rentId, int accountFrom, int accountTo, BigDecimal amount) {
        this.rentId = rentId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Rent(int accountId, int accountId1, BigDecimal rentPayment) {
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + rentId +
                ", accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", amount=" + amount +
                '}';
    }
}
