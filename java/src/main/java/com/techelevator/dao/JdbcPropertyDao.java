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
    private final UserDao userDao;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public List<Property> getPropertyList() {
        List<Property> propertyList = new ArrayList<>();

        String sql = "SELECT property_id, landlord_user_id, renter_user_id, bedrooms, bathrooms, property_type, price, address, availability, property_desc, property_img " +
                "FROM property;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()){
            Property property = mapRowToProperty(result);
            propertyList.add(property);
        }

        return propertyList;
    }

    @Override
    public Property getPropertyByPropertyId(int propertyId) {
        Property property = null;
        String sql = "SELECT property_id, landlord_user_id, renter_user_id, bedrooms, bathrooms, property_type, price, address, availability, property_desc, property_img FROM property WHERE property_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, propertyId);
        try{
            if(result.next()){
                property = mapRowToProperty(result);
            }
        }catch (Exception ex){
            System.out.println("Something went wrong");
        }
        return property;
    }

    @Override
    public Property getPropertyByPropertyIdWithoutRenter(int propertyId) {
        Property property = null;
        String sql = "SELECT property_id, landlord_user_id, bedrooms, bathrooms, property_type, price, address, availability, property_desc, property_img FROM property WHERE property_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, propertyId);
        try{
            if(result.next()){
                property = mapRowToPropertyWithoutRenterId(result);
            }
        }catch (Exception ex){
            System.out.println("Something went wrong");
        }
        return property;
    }

    @Override
    public List<Property> getPropertyByLandlordUserId(int landlordUserId) {
        List<Property> propertyList = new ArrayList<>();

        String sql = "SELECT property_id, landlord_user_id, renter_user_id, bedrooms, bathrooms, property_type, price, address, availability, property_desc, property_img " +
                "FROM property WHERE landlord_user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landlordUserId);

        while(result.next()){
            Property property = mapRowToProperty(result);
            propertyList.add(property);
        }

        return propertyList;
    }

    @Override
    public Property create(Property property, String username) {
        Property newProperty = null;

        int landlordUserId = userDao.findIdByUsername(username);

        String sql = "INSERT INTO property (landlord_user_id, bedrooms, bathrooms, property_type, price, address, availability, property_desc, property_img) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING property_id";

        try{
            int newPropertyId = jdbcTemplate.queryForObject(sql, int.class, landlordUserId, property.getBedrooms(), property.getBathrooms(), property.getPropertyType(), property.getPrice(), property.getAddress(), property.isAvailability(), property.getPropertyDesc(), property.getPropertyImg());
            newProperty = getPropertyByPropertyIdWithoutRenter(newPropertyId);
        }catch (Exception ex){
            System.out.println("Cannot create a new property");
        }
        return  newProperty;
    }

    @Override
    public void delete(int propertyId) {
        String sql = "DELETE FROM property WHERE property_id = ?";
        jdbcTemplate.update(sql, propertyId);
    }

    @Override
    public void edit(int propertyId, Property property) {
        String sql = "UPDATE property SET bedrooms = ?, bathrooms = ?, property_type = ?, price = ?, address = ?, availability = ?, property_desc = ?, property_img = ? WHERE property_id = ? ";
        jdbcTemplate.update(sql, property.getBedrooms(), property.getBathrooms(), property.getPropertyType(), property.getPrice(), property.getAddress(), property.isAvailability(), property.getPropertyDesc(), property.getPropertyImg(), propertyId );
    }

    @Override
    public void addRenter(int propertyId, Property property) {
        try{
            String sql = "UPDATE property SET renter_user_id = ?  WHERE property_id = ? ";
            jdbcTemplate.update(sql, property.getRenterUserId(), propertyId );
        }catch (Exception ex){
            System.out.println("Renter cannot be assigned to multiple properties");
        }

    }

    @Override
    public void removeRenter(int propertyId) {
        try{
            String sql = "UPDATE property SET renter_user_id = null  WHERE property_id = ? ";
            jdbcTemplate.update(sql, propertyId);
        }catch (Exception ex){
            System.out.println("This property does not have a renter assigned");
        }
    }


    private Property mapRowToProperty(SqlRowSet rs){
        Property property = new Property();
        property.setPropertyId(rs.getInt("property_id"));
        property.setLandlordUserId(rs.getInt("landlord_user_id"));
        property.setRenterUserId(rs.getInt("renter_user_id"));
        property.setBedrooms(rs.getInt("bedrooms"));
        property.setBathrooms(rs.getInt("bathrooms"));
        property.setPropertyType(rs.getString("property_type"));
        property.setPrice(rs.getBigDecimal("price"));
        property.setAddress(rs.getString("address"));
        property.setAvailability(rs.getBoolean("availability"));
        property.setPropertyDesc(rs.getString("property_desc"));
        property.setPropertyImg(rs.getString("property_img"));

        return property;
    }

    private Property mapRowToPropertyWithoutRenterId(SqlRowSet rs){
        Property property = new Property();
        property.setPropertyId(rs.getInt("property_id"));
        property.setLandlordUserId(rs.getInt("landlord_user_id"));
        property.setBedrooms(rs.getInt("bedrooms"));
        property.setBathrooms(rs.getInt("bathrooms"));
        property.setPropertyType(rs.getString("property_type"));
        property.setPrice(rs.getBigDecimal("price"));
        property.setAddress(rs.getString("address"));
        property.setAvailability(rs.getBoolean("availability"));
        property.setPropertyDesc(rs.getString("property_desc"));
        property.setPropertyImg(rs.getString("property_img"));

        return property;
    }
}
