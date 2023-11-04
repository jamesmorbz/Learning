<template>
  <div class="my-4">
    <h2 class="mb-3">List of Elements</h2>
    <ul class="list-group">
      <li v-for="element in elements" :key="element.id" class="list-group-item">
        <div class="d-flex justify-content-between align-items-center">
          <div>
            ID: <strong>{{ element.id }}</strong>
            Name: <strong>{{ element.name }}</strong>
            Description: <strong>{{ element.description }}</strong>
            Price: <strong>{{ element.price }}</strong>
            Status: <strong>{{ element.is_available ? 'Available' : 'Not Available' }}</strong>
          </div>
          <div>
            <button @click="updateElement(element)" class="btn btn-primary mr-2">Edit</button>
            <button @click="deleteElement(element)" class="btn btn-danger m-2">Delete</button>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      elements: []
    };
  },
  created() {
    this.fetchElements();
  },
  methods: {
    fetchElements() {
      fetch("http://localhost:8000/api/elements/")
        .then(response => response.json())
        .then(data => {
          this.elements = data;
        })
        .catch(error => {
          console.error("Error:", error);
        });
    },
    updateElement(element) {
      console.log("Update button clicked for element:", element);
      this.$emit("updateElement", element);
    },
    deleteElement(element) {
      console.log("Delete button clicked for element:", element);
      this.$emit("deleteElement", element);
    },
  }
};
</script>
