import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  getUsers(){
    return axios.get('/users')
  },

  getRenterList(){
    return axios.get('/users/role/renters')
  },


  getUserById(id){
    return axios.get('/users/' + id)
  }

}
