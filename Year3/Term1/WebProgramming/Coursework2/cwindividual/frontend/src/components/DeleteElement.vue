<template>
    <div>
      <h2>Delete Element</h2>
      <p>Are you sure you want to delete this element?</p>
      <button @click="deleteElement">Delete</button>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      element: Object // The element to be deleted
    },
    methods: {
      deleteElement() {
        // Delete the element and make a DELETE request
        fetch(`http://localhost:8000/api/elements/${this.element.id}/`, {
          method: "DELETE"
        })
          .then(response => {
            // Handle the response (e.g., remove the element from the list)
            this.$emit("deleteElement", this.element.id);
          })
          .catch(error => {
            console.error("Error:", error);
          });
      }
    }
  };
  </script>
  