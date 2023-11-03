import axios from 'axios';

export default {

  getPropertyList() {
    return axios.get('/property')
  },

  getPropertyByPropertyId(propertyId){
    return axios.get('/property/' + propertyId)
  },

  listProperty(property){
    return axios.post("/property/", property)
  },

  getPropertiesByPropertyLandlordUserId(landlordUserId){
    return axios.get('/property/my-properties/' + landlordUserId)
  },

  getPropertiesByPropertyRenterUserId(renterUserId){
    return axios.get('/property/renter/' + renterUserId)
  },

  deleteProperty(propertyId){
    return axios.delete('/property/' + propertyId)
  },

  editProperty(property){
    return axios.put('property/' + property.propertyId, property)
  },

  addRenter(property){
    return axios.put('property/assign/' + property.propertyId, property)
  },

  removeRenter(propertyId){
    return axios.put('property/un-assign/' + propertyId)
  }


}