<template>
    <div class="main-card">  
      <table class="table">
        <thead class="thead">
          <tr class="td">
            <th>Property Id</th>
            <th>Type</th>
            <th>Bedrooms</th>
            <th>Bathrooms</th>
            <th>Price</th>
            <th>Availability</th>
            <th>Renter Id</th>
            <th>Assign Renter</th>
            <th>Un-assign Renter</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody class="tbody">
            <tr  v-for="property in properties" v-bind:key="property.landlordUserId">
                <td class="property-id">{{ property.propertyId }}</td>
                <td class="property-type">{{ property.propertyType }}</td>
                <td class="property-beddrooms">{{ property.bedrooms }}</td>
                <td class="property-bathrooms">{{ property.bathrooms }}</td>
                <td class="property-price">${{ property.price }} </td>
                <td class="property-availability">{{ property.renterUserId === 0 ? 'Available': 'Rented' }}</td>
                <td class="property-renter">{{ property.renterUserId }}</td>
                <td>
                  <button class="assign-renter" v-if="property.renterUserId === 0">
                    <router-link v-bind:to="{ name: 'assign-renter', params:{propertyId: property.propertyId}}">Assign Renter</router-link>
                  </button>

                </td>
                <td>
                  <button v-if="property.renterUserId !== 0" class="remove" type="submit" value="Remove" v-on:click="removeRenter(property.propertyId)">Un-assign Renter</button>
                </td>
                <td> 
                  <button class="edit">
                    <div class="edit-text">
                        <router-link v-bind:to="{ name: 'edit-listing', params:{propertyId: property.propertyId}}">Edit Property</router-link>
                    </div>
                  </button>
                </td>
                <td class="delete-itinerary"> <button class="delete" type="submit" value="Delete" v-on:click="deleteProperty(property.propertyId)">Delete Property</button></td>             
            </tr>
        </tbody>
      </table>


    </div>
  </template>
  
  <script>
  import PropertyService from "../services/PropertyService";

  export default {
    name: "my-listings",
    props: [
        "userId", "propertyId"
    ],
    data(){
        return {
            properties: [],

            users: [],
           
        }
    },
    created(){  
        const id = this.$store.state.user.id;
        PropertyService.getPropertiesByPropertyLandlordUserId(id).then((response) =>{
            this.properties = response.data;
            console.log(response.data);

        })

    },
    methods: {
      deleteProperty(propertyId){
        PropertyService.deleteProperty(propertyId).then(()=>{
          const index = this.properties.findIndex(i => i.propertyId == propertyId)
          this.properties.splice(index, 1)
        })
      },

      removeRenter(propertyId){
        PropertyService.removeRenter(propertyId).then(()=>{
          window.location.reload();
        })
      },


    }           
  
}

  </script>
  <style scoped>

  .table{
    table-layout: auto;
    border: 1px solid black;
    width: 100%;
  }

  .tbody{
    border: 1px solid black;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    text-align: left;
  }
  .thead{
    background-color: rgb(32, 32, 31);
    color: white;
  }

  td{
    text-align: center;
  }

  button{
    display: flex;
    text-align: center;
    justify-content: center;
    align-items: center;
    height: 40px;
    cursor: pointer;

  }

  .delete{
    background-color: red;
    color: white;
    cursor: pointer;
  }

  .edit{
    background-color: yellow;
    color: white;

  }

  a{
    text-decoration: none;
  }

  a:link, a:visited{
    color: black;
    text-decoration: none
  }
  
  
  </style>