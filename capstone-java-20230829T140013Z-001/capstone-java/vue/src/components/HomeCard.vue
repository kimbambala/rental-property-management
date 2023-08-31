<template>
  <div class="cards" >
    
    <!--<h2>Currently Available</h2>
    <p>Bedrooms: {{ home.rooms }}</p>
    <p>Bathrooms: {{home.bathrooms}}</p>
    <p>${{home.rent}}</p>-->
    
    <div class="houseCard" v-for="property in properties" v-bind:key="property.propertyId" v-on:click="viewDetails(property.propertyId)">
      <div class="bedrooms">Bedrooms:{{ property.bedrooms }}</div>
      <div class="bathrooms">Bathrooms:{{ property.bathrooms }}</div>
      <div class="price">Price: ${{ property.price }}</div>
      <div class="type">Type: {{ property.propertyType }}</div>
      <div class="propertyImg"> <img v-bind:src="property.propertyImg" alt=""></div>
    </div>
  </div>
</template>

<script>
import PropertyService from '../services/PropertyService';

export default {
  name: "house-card",
  props: {
    home: Object, 
   
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
  },
  methods:{
    viewDetails(propertyId){
        console.log(propertyId);
            const route = {
                name: "details",
                params: {
                  propertyId: propertyId
                }
            };
            this.$router.push(route)
}

}
}
</script>

<style>
h1 {
    text-align: center;
}
.houseCard {
  border: 2px solid #2B2D42;
  border-radius: 10px;
  background-color: white;
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
  cursor: pointer;
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
  font-family: Arial, Helvetica, sans-serif;

}

img{
  width: 100%;
  height: 100%
}

</style>
