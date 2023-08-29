package com.techelevator.model;

public class Property {
    private int propertyId;
    private int landlordId;
    private int renter_id;
    private String bedrooms;
    private String bathrooms;
    private int price;
    private String address;
    private boolean availability;
    private String propertyDesc;
    private String propertyImg;


    public Property() {
    }

    public Property(int propertyId, int landlordId, int renter_id, String bedrooms, String bathrooms, int price, String address, boolean availability, String propertyDesc, String propertyImg) {
        this.propertyId = propertyId;
        this.landlordId = landlordId;
        this.renter_id = renter_id;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
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

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public int getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(int renter_id) {
        this.renter_id = renter_id;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
                ", landlordId=" + landlordId +
                ", renter_id=" + renter_id +
                ", bedrooms='" + bedrooms + '\'' +
                ", bathrooms='" + bathrooms + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", availability=" + availability +
                ", propertyDesc='" + propertyDesc + '\'' +
                ", propertyImg='" + propertyImg + '\'' +
                '}';
    }
}
