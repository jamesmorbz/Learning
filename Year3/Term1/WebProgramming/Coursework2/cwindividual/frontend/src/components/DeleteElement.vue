<template>
  <div class="my-4">
    <h2 class="mb-3">Delete Element</h2>
    <p>Are you sure you want to delete this element?</p>
    <button @click="deleteElement" class="btn btn-danger">Delete</button>
  </div>
</template>

<script>
export default {
  props: {
    element: Object
  },
  methods: {
    deleteElement() {
      fetch(`http://localhost:8000/api/elements/${this.element.id}/`, {
        method: "DELETE"
      })
        .then(response => {
          this.$emit("deleteElement", this.element.id);
        })
        .catch(error => {
          console.error("Error:", error);
        });
    }
  }
};
</script>
