<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style>
.home {
  display: grid;
  justify-content: center;
  width: 100vw;
  height: 100vh;
  
}
.home h1 {
  text-align: center;
}
</style>
