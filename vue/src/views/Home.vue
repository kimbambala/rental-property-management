<template>
  <div class="browse">
    
    <div class="cards">
      <h1>Browse</h1>
      <home-card />
    </div>
  </div>
</template>

<script>
import HomeCard from "../components/HomeCard.vue";
export default {
  components: {
    HomeCard
  },

}
</script>

<style>
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
  ". cards .";
}


</style>
