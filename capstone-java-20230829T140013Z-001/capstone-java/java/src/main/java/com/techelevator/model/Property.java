package com.techelevator.model;

public class Property {
    private int propertyId;
    private String bedrooms;
    private String bathrooms;
    private String propertyDesc;
    private String propertyImg;


    public Property() {
    }

    public Property(int propertyId, String bedrooms, String bathrooms, String propertyDesc, String propertyImg) {
        this.propertyId = propertyId;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.propertyDesc = propertyDesc;
        this.propertyImg = propertyImg;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
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
                ", bedrooms='" + bedrooms + '\'' +
                ", bathrooms='" + bathrooms + '\'' +
                ", propertyDesc='" + propertyDesc + '\'' +
                ", propertyImg='" + propertyImg + '\'' +
                '}';
    }
}
