<template>
    <div class="cards">
      
      <div class="houseCard" >
        <div class="propertyImg"> <img v-bind:src="properties.propertyImg" alt=""> </div>
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
    left: 10%;
    font-size: 1rem;
    place-items: center;
    text-decoration: none;
    transition: border 0.2s ease, transform 0.3s ease-in-out;
    box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5);
   
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