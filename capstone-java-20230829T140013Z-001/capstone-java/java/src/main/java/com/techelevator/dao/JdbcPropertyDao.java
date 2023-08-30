package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcPropertyDao implements PropertyDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Property> getPropertyList() {
        List<Property> propertyList = new ArrayList<>();

        String sql = "SELECT property_id, landlord_id, renter_id, bedrooms, bathrooms, property_type, price, address, availability, property_desc, property_img " +
                "FROM property;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()){
            Property property = mapRowToProperty(result);
            propertyList.add(property);
        }

        return propertyList;
    }




    private Property mapRowToProperty(SqlRowSet rs){
        Property property = new Property();
        property.setPropertyId(rs.getInt("property_id"));
        property.setLandlordId(rs.getInt("landlord_id"));
        property.setRenter_id(rs.getInt("renter_id"));
        property.setBedrooms(rs.getString("bedrooms"));
        property.setBathrooms(rs.getString("bathrooms"));
        property.setPropertyType(rs.getString("property_type"));
        property.setPrice(rs.getInt("price"));
        property.setAddress(rs.getString("address"));
        property.setAvailability(rs.getBoolean("availability"));
        property.setPropertyDesc(rs.getString("property_desc"));
        property.setPropertyImg(rs.getString("property_img"));

        return property;
    }
}
