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

  deleteProperty(propertyId){
    return axios.delete('/property/' + propertyId)
  },

  editProperty(property){
    return axios.put('property/' + property.propertyId, property)
  }


}