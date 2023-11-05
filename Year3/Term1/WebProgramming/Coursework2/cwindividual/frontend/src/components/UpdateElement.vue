<template>
  <form @submit.prevent="updateElement" class="my-4">
    <div class="form-group">
      <label for="id">Id:</label>
      <input type="number" id="id" v-model="elementData.id" required class="form-control">
    </div>

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
    <div class="form-group">
      <input type="radio" id="available" v-model="elementData.available" name="available" value=1>
      <label for="available" class="p-1">Available</label><br>
      <input type="radio" id="available" v-model="elementData.available" name="available" value=0>
      <label for="available" class="p-1">Not Currently Available</label>
    </div>
    <button type="submit" class="btn btn-primary m-1 p-2">Update Element</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      elementData: {
        id: "",
        name: "",
        description: "",
        price: 0.00,
        available: 1,
      }
    };
  },
  methods: {
    updateElement() {
      fetch(`http://localhost:8000/api/elements/${this.elementData.id}/`, {
        method: "PUT",
        body: JSON.stringify(this.elementData)
      })
        .then(response => response.json())
        .then(data => {
          this.$emit('elementRefresh')
        })
        .catch(error => {
          console.error("Error:", error);
        });
    },
  }
};
</script>
