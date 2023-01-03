<template>
  <div>
    <!-- Header -->

    <div class="banner">
      <a href="#"><img src="../assets/img/temp/banner1.jpg" /></a>
    </div>
    <!-----------------address------------------------------->
    <div class="address">
      <div class="wrapper clearfix">
        <router-link to="/flowerder">首页</router-link><span>/</span
        ><router-link to="/flowerder">装饰摆件</router-link><span>/</span
        ><router-link to="/vaseprolist" class="on">花瓶花器</router-link>
      </div>
    </div>
    <!-------------------current---------------------->
    <div class="current">
      <div class="wrapper clearfix">
        <h3 class="fl">花瓶花器</h3>
        <div class="fr choice" @click="clickOut()">
          <p class="default">排序方式</p>
          <ul class="select" :style="visitable">
            <li @click="newProducts()">新品上市</li>
            <li @click="saleUpToDown()">销量从高到低</li>
            <li @click="saleDownToUp()">销量从低到高</li>
            <li @click="priceUpToDown()">价格从高到低</li>
            <li @click="priceDownToUp()">价格从低到高</li>
          </ul>
        </div>
      </div>
    </div>
    <!----------------proList------------------------->
    <ul class="proList wrapper clearfix">
      <li v-for="item in productList" :key="item.pid">
        <router-link :to="'/prodetail?pid=' + item.pid">
          <dl>
            <dt><img :src="require('../assets' + item.image + '.jpg')" /></dt>
            <dd>{{ item.title }}</dd>
            <dd>￥{{ item.price }}</dd>
          </dl>
        </router-link>
      </li>
    </ul>

    <!-------------------mask内容------------------->

    <!--返回顶部-->

    <!--footer-->

  </div>
</template>

<script>
export default {
  name: "VaseProlistView",
  data() {
    return {
      bigCategory: "",
      smallCategory: "",
      productList: [],
      visitable: "display:none;",
    };
  },
  methods: {
    clickOut() {
      if (this.visitable == "display: none;") {
        this.visitable = "display: block;";
      } else {
        this.visitable = "display: none;";
      }
    },
    newProducts() {
      this.axios
        .get("http://localhost:8080/products/orderByTime", {})
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            this.productList = res.data.data;
            for (var i = 0; i < this.productList.length; i++) {
              if (
                this.productList[i].bigCategory != this.bigCategory ||
                this.productList[i].smallCategory != this.smallCategory
              ) {
                this.productList.splice(i, 1);
                i--;
              }
            }
          }
        });
    },
    saleUpToDown() {
      this.axios
        .get("http://localhost:8080/products/orderBySaleNum", {
          params: {
            order: 2,
          },
        })
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            this.productList = res.data.data;
            for (var i = 0; i < this.productList.length; i++) {
              if (
                this.productList[i].bigCategory != this.bigCategory ||
                this.productList[i].smallCategory != this.smallCategory
              ) {
                this.productList.splice(i, 1);
                i--;
              }
            }
          }
        });
    },
    saleDownToUp() {
      this.axios
        .get("http://localhost:8080/products/orderBySaleNum", {
          params: {
            order: 1,
          },
        })
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            this.productList = res.data.data;
            for (var i = 0; i < this.productList.length; i++) {
              if (
                this.productList[i].bigCategory != this.bigCategory ||
                this.productList[i].smallCategory != this.smallCategory
              ) {
                this.productList.splice(i, 1);
                i--;
              }
            }
          }
        });
    },
    priceUpToDown() {
      this.axios
        .get("http://localhost:8080/products/orderByPrice", {
          params: {
            order: 2,
          },
        })
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            this.productList = res.data.data;
            for (var i = 0; i < this.productList.length; i++) {
              if (
                this.productList[i].bigCategory != this.bigCategory ||
                this.productList[i].smallCategory != this.smallCategory
              ) {
                this.productList.splice(i, 1);
                i--;
              }
            }
          }
        });
    },
    priceDownToUp() {
      this.axios
        .get("http://localhost:8080/products/orderByPrice", {
          params: {
            order: 1,
          },
        })
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            this.productList = res.data.data;
            for (var i = 0; i < this.productList.length; i++) {
              if (
                this.productList[i].bigCategory != this.bigCategory ||
                this.productList[i].smallCategory != this.smallCategory
              ) {
                this.productList.splice(i, 1);
                i--;
              }
            }
          }
        });
    },
  },
  created() {
    this.bigCategory = 3;
    this.smallCategory = 2;
    this.axios
      .get("http://localhost:8080/products/bigAndSmallCategory", {
        params: {
          bigCategory: this.bigCategory,
          smallCategory: this.smallCategory,
        },
      })
      .then((res) => {
        console.log(res.data);
        if (res.data.code == 200) {
          this.productList = res.data.data;
        }
      });
  },
};
</script>

<style></style>
