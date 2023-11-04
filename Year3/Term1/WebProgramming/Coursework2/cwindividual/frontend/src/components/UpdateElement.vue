<template>
  <div>
    <h2 class="my-4">Edit Element</h2>
    <form @submit.prevent="updateElement" class="my-4">
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" v-model="elementData.name" required class="form-control">
      </div>

      <div class="form-group">
        <label for="description">Description:</label>
        <input type="text" id="description" v-model="elementData.description" required class="form-control">
      </div>

      <div class="form-group">
        <label for="price">Price:</label>
        <input type="number" id="price" v-model="elementData.price" required class="form-control">
      </div>

      <label for="available">Status:</label>
      <div class="form-check form-check-inline">
        <input type="radio" id="available1" v-model="elementData.available" name="available" value=1
          class="form-check-input">
        <label for="available1" class="form-check-label">Available</label>
      </div>
      <div class="form-check form-check-inline">
        <input type="radio" id="available0" v-model="elementData.available" name="available" value=0
          class="form-check-input">
        <label for="available0" class="form-check-label">Not Currently Available</label>
      </div>

      <button type="submit" class="btn btn-primary">Update Element</button>
    </form>
  </div>
</template>

<script>
export default {
  props: {
    element: Object
  },
  data() {
    return {
      elementData: {
        name: "",
        description: "",
        price: 0.00,
        available: 1,
      }
    };
  },
  created() {
    this.elementData = { ...this.element };
  },
  methods: {
    updateElement() {
      fetch(`http://localhost:8000/api/elements/${this.element.id}/`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.elementData)
      })
        .then(response => response.json())
        .then(data => {
          this.$emit("updateElement", data);
        })
        .catch(error => {
          console.error("Error:", error);
        });
    }
  }
};
</script>
