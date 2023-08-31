<template>
  <div id="app">
    <div id="nav">


    <span class="home" id="home-text">
        <router-link v-bind:to="{ name: 'home' }"><h1>Home</h1></router-link>

      </span>

      <!--

      <span class="profile">
        <router-link v-bind:to="{ name: 'profile', params: {userId: this.$store.state.user.id} }"  v-if="$store.state.token != ''"><h1>Profile</h1></router-link>

      </span>
      -->

      <span class="login">
        <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == '' "><h1> Login</h1></router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><h1>Logout</h1></router-link>
      </span>

    </div>

    <router-view />
  </div>
</template>
<style>

#nav{
  background-color: #2B2D42;
  height: 80px;
  font-size: 15px;
  text-decoration: none;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
  border-bottom-left-radius: 8px;
  border-bottom-right-radius: 8px;
}

a{
  text-decoration: none;
  color: white;
}

.nav-text{
  text-decoration: none;
}

#app{
  font-family:sans-serif;
}

a{
  text-decoration: none;
  color: white;
}

.profile{
  align-self: center;
}


.home{
  margin-left: 350px;
}

h1:hover{
  background-color: white;
  color: black;
}


.login{
  align-self: center;
  margin-right: 350px;
}

.logout{
  align-self: center;
  margin-right: 350px;
    
}

</style>
