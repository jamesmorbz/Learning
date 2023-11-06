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
            <UpdateElement @elementRefresh="fetchElements" :elementData="element" class="mt-4" />
            <button @click="deleteElement(element)" class="btn btn-danger m-2">Delete</button>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import UpdateElement from './UpdateElement.vue';

export default {
  data() {
    return {
      elements: [],
      elementData: null
    };
  },
  created() {
    this.fetchElements();
  },
  components: {
    UpdateElement, // Register the UpdateElement component
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
    deleteElement(element) {
      console.log(element)
      fetch(`http://localhost:8000/api/elements/${element.id}/`, {
        method: "DELETE"
      })
        .then(response => {
          this.$emit("elementRefresh", element.id);
        })
        .catch(error => {
          console.error("Error:", error);
        });
    },
    editElement(element) {
      console.log("Pressing Update for element: " + element.id)
      this.elementData = element;
    },
  }
};
</script>
