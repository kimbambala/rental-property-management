import axios from 'axios';

export default {

  getPropertyList() {
    return axios.get('/property')
  },

  getPropertyByPropertyId(propertyId){
    return axios.get('/property/' + propertyId)
  }


}