<template>
    <div class="main-card">  

        <main>
            <h1>Add a new property to your account</h1>

            <div class="form-card">
                <form v-on:submit.prevent="onListProperty()">
                    <div>
                        <label for="type">Property Type:</label>
                        <select id="type" name="propertyType" v-model="property.propertyType" required>
                            <option class="option-text" value="">--Please choose one--</option>
                            <option value="Apartment">Apartment</option>
                            <option value="House">House</option>
                        </select>
                    </div>
                    <div>
                        <label for="bedrooms">Number of bedrooms:</label>
                        <input type="number" id="bedrooms" name="bedrooms" v-model="property.bedrooms" required>
                    </div>
                    <div>
                        <label for="bathrooms">Number of bathrooms:</label>
                        <input type="number" id="bathrooms" name="bathrooms" v-model="property.bathrooms" required>
                    </div>

                    <div>
                        <label for="price">Price:</label>
                        <input type="number" id="price" name="bathrooms" v-model="property.price" required>
                    </div>
                    <div>
                        <label for="address">Adress:</label>
                        <input type="text" id="address" name="adress" v-model="property.address" required>
                    </div>

                    <div>
                        <label for="availability">Availability:</label>
                        <select id="availability" name="availability" v-model="property.availability" required>
                            <option class="option-text" value="true">True</option>
                            <option value="false">False</option>

                        </select>
                    </div>
                    <div>
                        <label for="prop-image">Image URL:</label>
                        <textarea  id="prop-image" name="propertyImg" v-model="property.propertyImg" required> </textarea>
                    </div>

                    <div>
                        <label for="description">Description:</label>
                        <textarea id="description" name="propertyDesc" v-model="property.propertyDesc" required> </textarea>
                    </div>


                    <button type="submit" value="Create Property">List Property </button>
                </form>
        </div>

        </main>

    </div>
  </template>
  
  <script>
import PropertyService from '../services/PropertyService';


  export default {
    name: "listings",
    props: [
        "userId"
    ],

    data(){
        return {

            users: [],

            property: {
                bedrooms: 1,
                bathrooms: 1,
                propertyType: "",
                price: 1000,
                address: "",
                availability: true,
                propertyDesc: "",
                propertyImg: ""
            },
           
        }
    },
    created(){  

    },         
    methods: {
      onListProperty(){
            PropertyService.listProperty(this.property).then((response)=>{
                console.log(response.data);
                const route = {
                    name: "account",
                    params: {
                        
                        userId: this.$store.state.user.id,
                    }
                };
                this.$router.push(route)
            })
    
  }

    } 
}

  </script>
  <style scoped>

main{
    display: flex;
    flex-direction: column;
    align-items: center;

  }

.form-card{
    display: flex;
    align-items: center;
    
}

input{
    display: block;
    height: 40px;
    width: 700px;
    background-color: rgba(255, 255, 255, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-bottom: 8px;
    font-size: 25px;
    font-weight: 400;
}

textarea{
    display: block;
    height: 200px;
    width: 700px;
    background-color: rgba(255, 255, 255, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-bottom: 8px;
    font-size: 25px;
    font-weight: 400;
    font-family:sans-serif;
}

select{
    display: block;
    background-color: #8D99AE;
    width: 724px;
    height: 40px;
    font-size: 25px;
    border-radius: 3px;

}

h1{
    margin-top: 10px;

}

form{
    align-content: center;
    
}

label{
    font-size: 20px;
}

button{
    margin-top: 20px;
    width: 100%;
    height: 50px;
    background-color: #ffffff;
    color: #080710;
    padding: 2px 0;
    font-size: 25px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
    align-self: center;
}

button:hover{
    background-color: #080710;
    color: white;
}

input:hover, select:hover, textarea:hover{
    border-color: #EF233C;
    background-color: #8D99AE;

}

  
  
  </style>