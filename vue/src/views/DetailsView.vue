<template>
    <div class="browse">

        <div class="h1">
            <h1>Property Details</h1>
        </div>
        
      <div class="cards">
        <details-card />
      </div>
    </div>
  </template>
  
  <script>
  import DetailsCard from '../components/DetailsCard.vue';
  export default {
    name: "details",
    components: {
      DetailsCard
    },
  
  }
  </script>
  
  <style>

.h1{
    text-align: center;
    grid-area: h1;

  }

  .cards {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    grid-area: cards;
  }
  
  .browse{
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-areas:
    ". h1. " 
    ". cards .";
  }


  
  
  </style>