import axios from 'axios';

export default {

  getPropertyList() {
    return axios.get('/property')
  },


}