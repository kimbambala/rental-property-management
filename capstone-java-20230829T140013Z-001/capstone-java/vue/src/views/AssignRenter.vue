<template>
    <div class="main-card">  

        <main>
            <h1>Assign a renter to the property</h1>

            <div class="form-card">
                <form v-on:submit.prevent="addRenter(property)">
                    <div>
                        <label for="renter-id">Assign Renter:</label>
                        <select id="renter-id" v-model="property.renterUserId" >
                            <option v-for="user in users" v-bind:key="user.id" v-bind:value="user.id"> 
                                {{user.username}}
                            </option>
                        </select>                            
                    </div>
                    <button type="submit" value="Add Renter">Assign Renter</button>
                </form>
        </div>

        </main>

    </div> 
  </template>
  
  <script>
import PropertyService from '../services/PropertyService';
import AuthService from '../services/AuthService';


  export default {
    name: "assign-renter",
    props: [
        "userId"
    ],

    data(){
        return {

            users: [],
            properties:[],

            property: {
                renterUserId: 0,
                bedrooms: 1,
                bathrooms: 1,
                propertyType: "",
                price: 1000,
                address: "",
                availability: true,
                propertyDesc: "",
                propertyImg: ""
            },
           
        }
    },
    created(){ 

        const propertyId = this.$route.params.propertyId;
        PropertyService.getPropertyByPropertyId(propertyId).then((response)=>{
            this.property = response.data;
        }) 

        AuthService.getRenterList().then((response)=>{
            console.log(response.data);
            this.users = response.data;
        })

    },         
    methods: {
      addRenter(property){
            PropertyService.addRenter(property).then(()=>{
                const route = {
                    name: "account",
                    params: {   
                        userId: this.$store.state.user.id,
                    }
                };
                this.$router.push(route)
            })
    
  }

    } 
}

  </script>
  <style scoped>

  main{
    display: flex;
    flex-direction: column;
    align-items: center;

  }

.form-card{
    display: flex;
    align-items: center;
    
}

input{
    display: block;
    height: 40px;
    width: 700px;
    background-color: rgba(255, 255, 255, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-bottom: 8px;
    font-size: 25px;
    font-weight: 400;
}

textarea{
    display: block;
    height: 200px;
    width: 700px;
    background-color: rgba(255, 255, 255, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-bottom: 8px;
    font-size: 25px;
    font-weight: 400;
    font-family:sans-serif;
}

select{
    display: block;
    background-color: #8D99AE;
    width: 724px;
    height: 40px;
    font-size: 25px;
    border-radius: 3px;

}

h1{
    margin-top: 10px;

}

form{
    align-content: center;
    
}

label{
    font-size: 20px;
}

button{
    margin-top: 20px;
    width: 100%;
    height: 50px;
    background-color: #ffffff;
    color: #080710;
    padding: 2px 0;
    font-size: 25px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
    align-self: center;
}

button:hover{
    background-color: #080710;
    color: white;
}

input:hover, select:hover, textarea:hover{
    border-color: #EF233C;
    background-color: #8D99AE;

}

  
  
  </style>