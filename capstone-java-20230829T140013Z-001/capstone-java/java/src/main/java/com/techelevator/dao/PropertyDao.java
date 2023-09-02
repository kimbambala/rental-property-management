package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDao {

    List<Property> getPropertyList();
    Property getPropertyByPropertyId(int propertyId);
    Property getPropertyByPropertyIdWithoutRenter(int propertyId);
    List<Property>getPropertyByLandlordUserId(int landlordUserId);
    Property create(Property property, String username);
}
