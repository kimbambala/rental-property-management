<template>
    <div class="browse">

        <div class="h1">
            <h1>Contact Owner</h1>
        </div>
        
      <div class="cards">
        <div class="mb-3">
          <div>To:</div>
          <label for="exampleFormControlInput1" class="form-label"></label>
          <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>
        <div class="mb-3">
          <br>
          <div>Message:</div>
          <label for="exampleFormControlTextarea1" class="form-label"></label>
          <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>

        <button>Send</button>

      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "contact-owner",
  
  
  }
  </script>
<style scoped>

  .cards{
    display: flex;
    flex-direction: column;
    align-content: center;
  }

  input{
    width: 500px;
    height: 50px;
    font-size: 17px;
  }

  textarea{
    width: 500px;
    height: 250px;
    font-size: 17px;
  }

  button{
    height: 40px;
    cursor: pointer;
    font-size: 25px;

  }

</style>