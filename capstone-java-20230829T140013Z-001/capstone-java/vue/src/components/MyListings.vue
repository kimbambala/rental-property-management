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
                <td class="property-availability">{{ property.availability }}</td>
                <td class="property-renter">{{ property.renterUserId }}</td>
                <td>Assign Renter</td>
                <td> 
                  <button class="edit">
                    <div class="edit-text">
                     Edit Group
                    </div>
                  </button>
                </td>
                <td class="delete-itinerary"> <button class="delete" type="submit" value="Delete">Delete</button></td>             
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
      deleteGroup(propertyId){
        PropertyService.deleteProperty(propertyId).then(()=>{
          const index = this.groups.findIndex(i => i.propertyId == propertyId)
          this.groups.splice(index, 1)
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

  }

  .delete{
    background-color: red;
    color: white
  }

  .edit{
    background-color: yellow;
    color: white;

  }

  .edit-text{
    margin-top: 15px;
  }

  a{
    text-decoration: none;
  }

  a:link, a:visited{
    color: black;
    text-decoration: none
  }
  
  
  </style>