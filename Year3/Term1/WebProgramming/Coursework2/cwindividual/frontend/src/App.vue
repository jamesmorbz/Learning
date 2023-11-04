<template>
  <div id="app" class="container my-4">
    <h1 class="mb-4">People Auction</h1>

    <ListElement @updateElement="updateElement" @deleteElement="deleteElement" />

    <CreateElement @elementCreated="createElement" class="mt-4" />

    <div v-if="selectedElement" class="row mt-4">
      <div class="col-md-6">
        <UpdateElement :element="selectedElement" @updateElement="updateElement" />
      </div>
      <div class="col-md-6">
        <DeleteElement :element="selectedElement" @deleteElement="deleteElement" />
      </div>
    </div>
  </div>
</template>

<script>
import ListElement from './components/ListElement.vue';
import CreateElement from './components/CreateElement.vue';
import UpdateElement from './components/UpdateElement.vue';
import DeleteElement from './components/DeleteElement.vue';

export default {
  components: {
    ListElement,
    CreateElement,
    UpdateElement,
    DeleteElement,
  },
  data() {
    return {
      selectedElement: null
    };
  },
  methods: {
    updateElement(updatedElement) {
      console.log(updatedElement.target);
      fetch(`http://localhost:8000/api/elements/${updatedElement.id}/`, {
        method: "PUT",
        body: JSON.stringify(updatedElement.target.data)
      })
        .then(response => response.json())
        .then(data => {
          this.$emit("updateElement", data);
        })
        .catch(error => {
          console.error("Error:", error);
        });
    },

    createElement(newElement) {
    },

    deleteElement(deletedElement) {
      console.log(deletedElement);

      fetch(`http://localhost:8000/api/elements/${deletedElement.id}/`, {
        method: "DELETE"
      })
        .then(response => {
          this.$emit("deleteElement", deletedElement.id);
        })
        .catch(error => {
          console.error("Error:", error);
        });
    }
  }

};
</script>
