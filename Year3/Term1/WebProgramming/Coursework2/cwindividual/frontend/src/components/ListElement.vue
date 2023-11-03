<template>
  <div>
    <h2>List of Elements</h2>
    <!-- Iterate through the list of elements and display them -->
    <ul>
      <li v-for="element in elements" :key="element.id">
        {{ element.id }}
        {{ element.name }}
        {{ element.description }}
        {{ element.price }}
        {{ element.is_available }}
        <button @click="updateElement(element)">Edit</button>
        <button @click="deleteElement(element)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      elements: [] // Initialize as an empty array
    };
  },
  created() {
    // Fetch the list of elements via a GET request when the component is created
    fetch("http://localhost:8000/api/elements/") // Replace with your API endpoint
      .then(response => response.json())
      .then(data => {
        this.elements = data; // Update the elements data property with the fetched data
      })
      .catch(error => {
        console.error("Error:", error);
      });
  },
  methods: {
    // Define editElement and confirmDelete methods
    updateElement(element) {
      // Emit an event to handle element editing
      this.$emit("updateElement", element);
    },
    deleteElement(element) {
      // Emit an event to handle element deletion confirmation
      this.$emit("deleteElement", element);
    }
  }
};
</script>
