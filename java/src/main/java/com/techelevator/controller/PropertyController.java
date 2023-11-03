package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Property;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
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

    @GetMapping("/my-properties/{landlordUserId}")
    public List<Property> getPropertyByLandlordUserId(@PathVariable int landlordUserId){
        List<Property> propertyList = propertyDao.getPropertyByLandlordUserId(landlordUserId);
        if(propertyList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No property found");
        }else{
            return propertyList;
        }
    }
    @GetMapping("/renter/{renterUserId}")
    public Property getPropertyByRenterUserId(@PathVariable int renterUserId){
        Property property = propertyDao.getPropertyByRenterUserId(renterUserId);
        if (property == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "No property found");
        }else {
            return property;
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

    @PreAuthorize("hasRole('ROLE_LANDLORD')")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Property newProperty, Principal principal){
        try{
            String username = principal.getName();
            Property property = propertyDao.create(newProperty, username);
            if (property == null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property registration failed.");
            }
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Property registration failed.");
        }

    }

    @PreAuthorize("hasRole('ROLE_LANDLORD')")
    @DeleteMapping("/{propertyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int propertyId){
        propertyDao.delete(propertyId);
    }


    @PreAuthorize("hasRole('ROLE_LANDLORD')")
    @PutMapping({"/{propertyId}"})
    public void edit(@PathVariable int propertyId, @RequestBody Property newProperty){
        propertyDao.edit(propertyId, newProperty);

    }

    @PreAuthorize("hasRole('ROLE_LANDLORD')")
    @PutMapping({"/assign/{propertyId}"})
    public void addRenter(@PathVariable int propertyId, @RequestBody Property newProperty){
        propertyDao.addRenter(propertyId, newProperty);

    }

    @PreAuthorize("hasRole('ROLE_LANDLORD')")
    @PutMapping("/un-assign/{propertyId}")
    public void removeRenter(@PathVariable int propertyId){
        propertyDao.removeRenter(propertyId);

    }

}
