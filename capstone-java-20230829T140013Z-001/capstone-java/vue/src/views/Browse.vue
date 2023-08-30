<template>
  <div>
    <h1>Browse</h1>
    <div class="cards">
      <home-card
        v-for="home in homes"
        :key="home.homeId"
        :home="home"
      ></home-card>
    </div>
  </div>
</template>

<script>
import HomeCard from "../components/HomeCard.vue";
export default {
  components: {
    HomeCard,
  },
  data() {
    return {
      homes: [],
    };
  },
  methods: {
    getHomes() {
      this.homes = this.$store.getters.getHomes;
    },
  },
  created() {
    this.getHomes();
  },
};
</script>

<style>
.cards {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
</style>
