<template>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Create Element
</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Create Element</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form @submit.prevent="createElement" class="my-4">
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
        <button @submit.prevent="createElement" type="submit" @click=createElement class="btn btn-primary">Create Element</button>
      </div>
    </div>
  </div>
</div>
  
</template>

<script>
export default {
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
  methods: {
    createElement() {
      fetch("http://localhost:8000/api/elements/", {
        method: "POST",
        body: JSON.stringify(this.elementData)
      })
        .then(response => response.json())
        .then(data => {
          this.$emit('elementRefresh');
        })
        .catch(error => {
          console.error("Error:", error);
        });

    }
  }
};
</script>
