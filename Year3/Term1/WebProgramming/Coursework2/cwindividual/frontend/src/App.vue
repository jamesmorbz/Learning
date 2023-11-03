<template>
    <div id="app">
      <h1>People Auction</h1>
  
      <!-- Element List component -->
      <ListElement @updateElement="updateElement" @deleteElement="deleteElement" />
  
      <!-- Create Element component -->
      <CreateElement @elementCreated="createElement" />
  
      <!-- Update Element component (conditional rendering based on a selected element) -->
      <UpdateElement
        v-if="selectedElement"
        :element="selectedElement"
        @updateElement="updateElement"
      />
  
      <!-- Delete Element component (conditional rendering based on a selected element) -->
      <DeleteElement
        v-if="selectedElement"
        :element="selectedElement"
        @deleteElement="deleteElement"
      />
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
      DeleteElement
    },
    data() {
      return {
        selectedElement: null
      };
    },
    methods: {
      // Function to update the list of elements after an update
      updateElement(updatedElement) {
      },
  
      createElement(newElement) {
      },
  
      deleteElement(deletedElementId) {
        console.log(deletedElementId)
      }
    }
  };
  </script>
  