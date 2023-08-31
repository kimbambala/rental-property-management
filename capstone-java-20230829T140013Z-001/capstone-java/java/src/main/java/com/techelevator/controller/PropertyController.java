package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/property")
public class PropertyController {
    private final PropertyDao propertyDao;

    public PropertyController(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }

    @GetMapping()
    public List<Property> getPropertyList(){
        List<Property> propertyList = propertyDao.getPropertyList();

        if(propertyList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No property found");
        }else{
            return propertyList;
        }

    }

    @GetMapping("/{propertyId}")
    public Property getPropertyByPropertyId(@PathVariable int propertyId){
        Property property = propertyDao.getPropertyByPropertyId(propertyId);
        if(property == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No property found");
        }else{
            return property;
        }
    }
}
