<template>
  <div id="app" class="container my-4">
    <h1 class="mb-4">People Auction</h1>

    <ListElement :key="count" @elementRefresh="refreshElements" class="mt-4" />
    <CreateElement @elementRefresh="refreshElements" class="mt-4" />
    <UpdateElement @elementRefresh="refreshElements" class="mt-4" />

  </div>
</template>

<script>
import ListElement from './components/ListElement.vue';
import CreateElement from './components/CreateElement.vue';
import UpdateElement from './components/UpdateElement.vue';

export default {
  components: {
    ListElement,
    CreateElement,
    UpdateElement,
  },
  data() {
    return {
      count: 1
    };
  },
  methods: {
    refreshElements() {
      console.log("Lets go refresh the elements!")
      this.count += 1
    }
  }
};
</script>
