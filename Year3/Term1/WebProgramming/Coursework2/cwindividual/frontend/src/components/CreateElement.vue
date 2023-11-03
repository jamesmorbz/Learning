<template>
    <form @submit.prevent="createElement">
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" v-model="elementData.name" required>
      </div>
  
      <div class="form-group">
        <label for="description">Description:</label>
        <input type="text" id="description" v-model="elementData.description" required>
      </div>

      <div class="form-group">
        <label for="price">Price:</label>
        <input type="number" id="price" v-model="elementData.price" required>
      </div>

      <div class="form-group">
        <label for="available">Available:</label>
        <input type="number" id="available" v-model="elementData.available" required>
      </div>
  
      <button type="submit">Create Element</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        elementData: {
          name: "",
          // Other fields
        }
      };
    },
    methods: {
      createElement() {
        // Create a new element and make a POST request
        fetch("http://localhost:8000/api/elements/", {
          method: "POST",
          body: JSON.stringify(this.elementData)
        })
          .then(response => response.json())
          .then(data => {
            // Handle the response (e.g., update the list of elements)
            this.$emit("createElement", data);
          })
          .catch(error => {
            console.error("Error:", error);
          });
      }
    }
  };
  </script>
  