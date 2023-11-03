<template>
    <div>
      <h2>Edit Element</h2>
      <form @submit.prevent="updateElement">
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" id="name" v-model="elementData.name" required>
        </div>
        
        <div class="form-group">
          <!-- Other fields go here -->
        </div>
        
        <button type="submit">Update Element</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      element: Object // The element to be updated
    },
    data() {
      return {
        elementData: {
          name: "",
          // Other fields
        }
      };
    },
    created() {
      // Initialize the form fields with the existing data
      this.elementData = { ...this.element };
    },
    methods: {
      updateElement() {
        // Update the element and make a PUT request
        fetch(`http://localhost:8000/api/elements/${this.element.id}/`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(this.elementData)
        })
          .then(response => response.json())
          .then(data => {
            // Handle the response (e.g., update the list of elements)
            this.$emit("updateElement", data);
          })
          .catch(error => {
            console.error("Error:", error);
          });
      }
    }
  };
  </script>
  