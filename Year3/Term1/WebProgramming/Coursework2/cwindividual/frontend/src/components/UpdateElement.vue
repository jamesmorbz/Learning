<template>
  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updateModal">
    Edit
</button>
<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Edit</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
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
    <div class="form-group">
      <input type="radio" id="available" v-model="elementData.available" name="available" value=1>
      <label for="available" class="p-1">Available</label><br>
      <input type="radio" id="available" v-model="elementData.available" name="available" value=0>
      <label for="available" class="p-1">Not Currently Available</label>
    </div>
  </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" @click=updateElement class="btn btn-primary">Update Element</button>
      </div>
    </div>
  </div>
</div>
  
</template>

<script>
export default {
  props: {
    elementData: {
      type: Object,
      default: () => ({
        id: 0,
        name: "",
        description: "",
        price: 0.00,
        available: 1,
      }),
      required: false,
    },
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
