package com.techelevator.model;

import java.math.BigDecimal;

public class Property {
    private int propertyId;
    private int landlordUserId;
    private Integer renterUserId;
    private int bedrooms;
    private int bathrooms;
    private String propertyType;
    private BigDecimal price;
    private String address;
    private boolean availability;
    private String propertyDesc;
    private String propertyImg;


    public Property() {
    }

    public Property(int propertyId, int landlordUserId, int renterUserId, int bedrooms, int bathrooms, String propertyType, BigDecimal price, String address, boolean availability, String propertyDesc, String propertyImg) {
        this.propertyId = propertyId;
        this.landlordUserId = landlordUserId;
        this.renterUserId = renterUserId;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.propertyType = propertyType;
        this.price = price;
        this.address = address;
        this.availability = availability;
        this.propertyDesc = propertyDesc;
        this.propertyImg = propertyImg;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getLandlordUserId() {
        return landlordUserId;
    }

    public void setLandlordUserId(int landlordUserId) {
        this.landlordUserId = landlordUserId;
    }

    public int getRenterUserId() {
        return renterUserId;
    }

    public void setRenterUserId(int renterUserId) {
        this.renterUserId = renterUserId;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }

    public String getPropertyImg() {
        return propertyImg;
    }

    public void setPropertyImg(String propertyImg) {
        this.propertyImg = propertyImg;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", landlordUserId=" + landlordUserId +
                ", renterUserId=" + renterUserId +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", propertyType='" + propertyType + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", availability=" + availability +
                ", propertyDesc='" + propertyDesc + '\'' +
                ", propertyImg='" + propertyImg + '\'' +
                '}';
    }
}
