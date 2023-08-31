<template>
    <div class="account">

      <div class="image-greeting">
        <div class="image">
          <img src="../assets/images/profilepic.jpg" alt="">
        </div>

        <div class="greeting-roles">
            <div class="greeting">Hello {{ $store.state.user.username }}!</div>
            <div class="role">{{users.authorities[0].name === 'ROLE_RENTER' ? "Renter" : ""}}</div>
            <div class="role">{{users.authorities[0].name === 'ROLE_LANDLORD' ? "Landlord" : ""}}</div>
            <div class="role">{{users.authorities[0].name === 'ROLE_MAINTENANCE' ? "Maintenance" : ""}}</div>            
        </div>
      </div>
    
      
    </div>
  </template>
  
  <script>
  import AuthService from '../services/AuthService';
  
  export default {
    name: "account-view",
    props: [
        "userId"
    ],
     

    data() {
      return {
        users:[] 
      };
    },
    created(){
        const id = this.$store.state.user.id;
        AuthService.getUserById(id).then((response)=>{
        this.users = response.data;
        console.log(response.data);
        console.log(response.data.authorities[0].name);
        
      })
    },

  }
  </script>
  <style scoped>

img{
  height: 40px;
  width: 40px;
}

.image-greeting{
  display: flex;
  flex-direction: row;
  background-color: white;
  margin-top: 10px;
}

.greeting{
    font-weight: bold;
}
  

  
  
  </style>