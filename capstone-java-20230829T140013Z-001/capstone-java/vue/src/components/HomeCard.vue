<template>
  <div class="houseCard">
    <h2>Currently Available</h2>
    <p>Bedrooms: {{ home.rooms }}</p>
    <p>Bathrooms: {{home.bathrooms}}</p>
    <p>${{home.rent}}</p>
  </div>
</template>

<script>
export default {
  name: "house-card",
  props: {
    home: Object
  },
  data() {
    return {};
  },
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
  height: 200px;
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
}</style>
