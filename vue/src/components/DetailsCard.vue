<template>
    <div class="cards">
      
      <div class="houseCard" >
        <div class="propertyImg"> <img v-bind:src="properties.propertyImg" alt=""> </div>
        <button class="btn">
          <router-link v-bind:to="{ name: 'rent-unit'}">Rent Property</router-link>
        </button>
        <button class="btn2">
          <router-link v-bind:to="{ name: 'contact-owner'}">Contact Owner</router-link>
        </button>
        <div class="bedrooms">Bedrooms:{{ properties.bedrooms }} </div>
        <div class="bathrooms">Bathrooms:{{ properties.bathrooms }}</div>
        <div class="price">Price: ${{ properties.price }}</div>
        <div class="type">Type: {{ properties.propertyType }}</div>
        <div class="address">Adress: {{ properties.address }}</div>
        <div class="availability">Availability: {{ properties.availability }}</div>
        <div class="description">{{ properties.propertyDesc }}</div>
      </div>
    </div>
  </template>
  
  <script>
  import PropertyService from '../services/PropertyService';
  
  export default {
    name: "details-card",
      
    data() {
      return {
        properties:[]
      };
    },
    created(){
        const propertyId = this.$route.params.propertyId
        PropertyService.getPropertyByPropertyId(propertyId).then((response)=>{
        this.properties = response.data;
        console.log(response.data);
        
      })
    }
  };
  </script>
  
  <style scoped>
  h1 {
      text-align: center;
  }
  .houseCard {
    border: 2px solid #2B2D42;
    border-radius: 10px;
    background-color: white;
    width: 800px;
    height: 1000px;
    margin: 20px;
    display: grid;
    bottom: 40px;
    left: 0%;
    font-size: 1rem;
    place-items: center;
    text-decoration: none;
    transition: border 0.2s ease, transform 0.3s ease-in-out;
    box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5);
    position: relative;
   
  }

  .btn {
  position: absolute;
  top: 5%;
  left: 20%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: #555;
  color: white;
  font-size: 16px;
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}

.btn2 {
  position: absolute;
  top: 5%;
  left: 80%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: #555;
  color: white;
  font-size: 16px;
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}

.btn:hover {
  background-color: black;
}
.btn2:hover {
  background-color: black;
}
  .houseCard:hover {
    border: 3px solid black;
    transform: translateY(-5px);
    box-shadow: 0px 10px 20px 2px rgba(0, 0, 0, 0.25);
  }
  
  .cards{
    display: grid;
    grid-template-columns: repeat(autofit, minmax (100px, 1fr));
    color: rgb(49, 49, 49);
    font-family:  sans-serif;
    
  
  }
  
  img{
    width: 100%;
    height: 100%
  }

  .description{
    padding: 10px;
  }

  
  </style>