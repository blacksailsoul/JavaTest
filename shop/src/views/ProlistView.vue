<template>
    <div>
      <!------------------------------banner------------------------------>
      <div class="banner">
        <a href="#"><img src="../assets/img/ib1.jpg" /></a>
      </div>
      <!-----------------address------------------------------->
      <div class="address">
        <div class="wrapper clearfix">
          <router-link to="/flowerder">首页</router-link><span>/</span
          ><router-link to="/flowerder">装饰摆件</router-link><span>/</span
          ><router-link to="/prolist" class="on">干花花艺</router-link>
        </div>
      </div>
      <!-------------------current---------------------->
      <div class="current">
        <div class="wrapper clearfix">
          <h3 class="fl">干花花艺</h3>
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
              <dt>
                <img :src="require('../assets' + item.image + '.jpg')" />
              </dt>
              <dd>{{ item.title }}</dd>
              <dd>￥{{ item.price }}</dd>
            </dl>
          </router-link>
        </li>
      </ul>

      <!-------------------mask内容------------------->
      <!-- <div class="proDets">
        <img class="off" src="../assets/img/temp/off.jpg" />
        <div class="tit clearfix">
          <h4 class="fl">【最家】非洲菊仿真花干花</h4>
          <span class="fr">￥17.90</span>
        </div>
        <div class="proCon clearfix">
          <div class="proImg fl">
            <img class="list" src="../assets/img/temp/proDet.jpg" />
            <div class="smallImg clearfix">
              <img
                src="../assets/img/temp/proDet01.jpg"
                data-src="../assets/img/temp/proDet01_big.jpg"
              /><img
                src="../assets/img/temp/proDet02.jpg"
                data-src="../assets/img/temp/proDet02_big.jpg"
              /><img
                src="../assets/img/temp/proDet03.jpg"
                data-src="../assets/img/temp/proDet03_big.jpg"
              /><img
                src="../assets/img/temp/proDet04.jpg"
                data-src="../assets/img/temp/proDet04_big.jpg"
              />
            </div>
          </div>
          <div class="fr">
            <div class="proIntro">
              <p>颜色分类</p>
              <div class="smallImg clearfix categ">
                <p class="fl">
                  <img
                    src="../assets/img/temp/prosmall01.jpg"
                    alt="白瓷花瓶+20支快乐花"
                    data-src="../assets/img/temp/proBig01.jpg"
                  />
                </p>
                <p class="fl">
                  <img
                    src="../assets/img/temp/prosmall02.jpg"
                    alt="白瓷花瓶+20支兔尾巴草"
                    data-src="../assets/img/temp/proBig02.jpg"
                  />
                </p>
                <p class="fl">
                  <img
                    src="../assets/img/temp/prosmall03.jpg"
                    alt="20支快乐花"
                    data-src="../assets/img/temp/proBig03.jpg"
                  />
                </p>
                <p class="fl">
                  <img
                    src="../assets/img/temp/prosmall04.jpg"
                    alt="20支兔尾巴草"
                    data-src="../assets/img/temp/proBig04.jpg"
                  />
                </p>
              </div>
              <p>数量&nbsp;&nbsp;库存<span>2096</span>件</p>
              <div class="num clearfix">
                <img class="fl sub" src="../assets/img/temp/sub.jpg" /><span
                  class="fl"
                  contentEditable="true"
                  >1</span
                ><img class="fl add" src="../assets/img/temp/add.jpg" />
                <p class="please fl">请选择商品属性!</p>
              </div>
            </div>
            <div class="btns clearfix">
              <a href="#2"><p class="buy fl">立即购买</p></a
              ><a href="#2"><p class="cart fr">加入购物车</p></a>
            </div>
          </div>
        </div>
        <a class="more" href="proDetail.html">查看更多细节</a>
      </div> -->
      </div>
      <!--返回顶部-->
      <!--footer-->  
</template>

<script>
export default {
  name: "ProlistView",
  data() {
    return {
      // 装饰摆件（3）->干花花艺（1）
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
            params:{
                order:2
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
            params:{
                order:1
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
            params:{
                order:2
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
            params:{
                order:1
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
    this.smallCategory = 1;
    //var param = new URLSearchParams();
    //param.append("bigCategory", this.bigCategory);
    //param.append("smallCategory", this.smallCategory);
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
