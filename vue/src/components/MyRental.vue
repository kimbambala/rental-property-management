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
            <th>Owner Id</th>
          </tr>
        </thead>
        <tbody class="tbody">
            <tr v-bind:key="property.renterUserId">
                <td class="property-id">{{ property.propertyId }}</td>
                <td class="property-type">{{ property.propertyType }}</td>
                <td class="property-beddrooms">{{ property.bedrooms }}</td>
                <td class="property-bathrooms">{{ property.bathrooms }}</td>
                <td class="property-price">${{ property.price }} </td>
                <td class="property-availability">{{ property.renterUserId === 0 ? 'Available': 'Rented' }}</td>
                <td class="property-renter">{{ property.renterUserId }}</td>
                <td class="property-owner">{{ property.landlordUserId }}</td>
            </tr>
        </tbody>
      </table>


    </div>
  </template>
  
  <script>
  import PropertyService from "../services/PropertyService";

  export default {
    name: "my-rental",
    props: [
        "userId", "propertyId"
    ],
    data(){
        return {
            property: [],

            users: [],
           
        }
    },
    created(){  
        const id = this.$store.state.user.id;
        PropertyService.getPropertiesByPropertyRenterUserId(id).then((response) =>{
            this.property = response.data;
            console.log(response.data);

        })

    },
          
  
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