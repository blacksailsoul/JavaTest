<template>
  <div id="app">
    <HeaderCom v-if="$route.meta.requireAuth"/>
    <router-view />
    <RightCom v-if="$route.meta.requireAuth"/>
    <FooterCom v-if="$route.meta.requireAuth"/>
  </div>
</template>

<script>
import HeaderCom from "./components/HeaderCom.vue";
import FooterCom from "./components/FooterCom.vue";
import RightCom from "./components/RightCom.vue";
export default {
  name: "app",
  components: {
    HeaderCom,
    FooterCom,
    RightCom
  }
};
</script>

<style lang="less">

</style>
