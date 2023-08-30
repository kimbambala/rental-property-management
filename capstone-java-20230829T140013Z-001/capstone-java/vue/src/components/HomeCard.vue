<template>
  <div class="cards">
    
    <!--<h2>Currently Available</h2>
    <p>Bedrooms: {{ home.rooms }}</p>
    <p>Bathrooms: {{home.bathrooms}}</p>
    <p>${{home.rent}}</p>-->
    
    <div class="houseCard" v-for="property in properties" v-bind:key="property.propertyId">
      <div class="bedrooms">Bedrooms:{{ property.bedrooms }}</div>
      <div class="bathrooms">Bathrooms:{{ property.bathrooms }}</div>
      <div class="price">Price: {{ property.price }}</div>
      <div class="type">Type: {{ property.propertyType }}</div>
      <div class="address">Adress: {{ property.address }}</div>
      <div class="availability">Availability: {{ property.availability }}</div>
      <div class="propertyImg"> <img v-bind:src="property.propertyImg" alt=""></div>
    </div>
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService';

export default {
  name: "house-card",
  props: {
    home: Object
  },
  data() {
    return {
      properties:[]
    };
  },
  created(){
    PropertyService.getPropertyList().then((response)=>{
      console.log(response.data);
      this.properties = response.data;
      
    })
  }
};
</script>

<style>
h1 {
    text-align: center;
}
.houseCard {
  border: 2px solid #333;
  border-radius: 10px;
  background-color: #f9f9f9;
  width: 250px;
  height: 400px;
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

}

img{
  width: 100%;
  height: 100%
}

</style>
