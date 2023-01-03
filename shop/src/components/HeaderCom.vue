<template>
  <div>
    <div class="head" v-if="$route.meta.IndexOnly">
      <div class="wrapper clearfix">
        <div class="clearfix" id="top">
          <h1 class="fl">
            <router-link to="/flowerder"
              ><img src="../assets/img/logo.png"
            /></router-link>
          </h1>
          <div class="fr clearfix" id="top1">
            <p class="fl">
              <router-link to="/login" id="login">登录</router-link
              ><router-link to="/register" id="reg">注册</router-link>
            </p>
            <!-- 表单传递值给后端，供其查找商品 -->
            <form action="#" method="get" class="fl">
              <input type="text" placeholder="搜索" /><input type="button" />
            </form>
            <div class="btn fl clearfix">
              <router-link to="/mycenter"
                ><img src="../assets/img/grzx.png" /></router-link
              ><span @mouseover="sss()" @mouseout="ddd()"><router-link to="#" class="er1"
                ><img src="../assets/img/ewm.png" /></router-link
              >
              
              </span><router-link to="/mycart"
                ><img src="../assets/img/gwc.png"
              /></router-link>
              <p :style="ggg">
                <router-link to="#"
                  ><img src="../assets/img/smewm.png"
                /></router-link>
              </p>
            </div>
          </div>
        </div>
        <ul class="clearfix" id="bott">
          <li><router-link to="/flowerder">首页</router-link></li>
          <!-- 第一个品类 -->
          <li @mouseover="overShow()" @mouseout="outShow()">
            <router-link to="#">所有商品</router-link>
            <div class="sList" :style="visitable1">
              <div class="wrapper clearfix">
                <router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav1.jpg" /></dt>
                    <dd>浓情欧式</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav2.jpg" /></dt>
                    <dd>浪漫美式</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav3.jpg" /></dt>
                    <dd>雅致中式</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav6.jpg" /></dt>
                    <dd>简约现代</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav7.jpg" /></dt>
                    <dd>创意装饰</dd>
                  </dl>
                </router-link>
              </div>
            </div>
          </li>
          <!-- 第二个品类 -->
          <li @mouseover="overTag()" @mouseout="outTag()">
            <router-link to="/flowerder">装饰摆件</router-link>
            <div class="sList2" :style="visitable">
              <div class="clearfix">
                <router-link to="/prolist">干花花艺</router-link
                ><router-link to="/vaseprolist">花瓶花器</router-link>
              </div>
            </div>
          </li>
          <!-- 第三个品类，未完待续。。。。 -->
          <li>
            <router-link to="decoration.html">布艺软饰</router-link>
            <div class="sList2">
              <div class="clearfix">
                <router-link to="zbproList.html">桌布罩件</router-link
                ><router-link to="bzproList.html">抱枕靠垫</router-link>
              </div>
            </div>
          </li>
          <!-- 第四、N个品类。。。。。。。。。 -->
          <li><router-link to="paint.html">墙式壁挂</router-link></li>
          <li><router-link to="perfume.html">蜡艺香薰</router-link></li>
          <li><router-link to="idea.html">创意家居</router-link></li>
        </ul>
      </div>
    </div>



    <div class="head ding" v-else>
      <div class="wrapper clearfix">
        <div class="clearfix" id="top">
          <h1 class="fl">
            <router-link to="/flowerder"
              ><img src="../assets/img/logo.png"
            /></router-link>
          </h1>
          <div class="fr clearfix" id="top1">
            <p class="fl">
              <router-link to="/login" id="login">登录</router-link
              ><router-link to="/register" id="reg">注册</router-link>
            </p>
            <!-- 表单传递值给后端，供其查找商品 -->
            <form action="#" method="get" class="fl">
              <input type="text" placeholder="搜索" /><input type="button" />
            </form>
          </div>
        </div>
        <ul class="clearfix" id="bott">
          <li>
            <router-link to="/flowerder">首页</router-link>
          </li>
          <!-- 第一个品类 -->
          <li @mouseover="overTag2()" @mouseout="outTag2()">
            <router-link to="#">所有商品</router-link>
            <div class="sList" :style="visitable2">
              <div class="wrapper clearfix">
                <router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav1.jpg" /></dt>
                    <dd>浓情欧式</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav2.jpg" /></dt>
                    <dd>浪漫美式</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav3.jpg" /></dt>
                    <dd>雅致中式</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav6.jpg" /></dt>
                    <dd>简约现代</dd>
                  </dl> </router-link
                ><router-link to="paint.html">
                  <dl>
                    <dt><img src="../assets/img/nav7.jpg" /></dt>
                    <dd>创意装饰</dd>
                  </dl>
                </router-link>
              </div>
            </div>
          </li>
          <!-- 第二个品类 -->
          <li @mouseover="overTag()" @mouseout="outTag()">
            <router-link to="/flowerder">装饰摆件</router-link>
            <div class="sList2" :style="visitable">
              <div class="clearfix">
                <router-link to="/prolist">干花花艺</router-link
                ><router-link to="/vaseprolist">花瓶花器</router-link>
              </div>
            </div>
          </li>
          <!-- 第三个品类，未完待续。。。。 -->
          <li>
            <router-link to="decoration.html">布艺软饰</router-link>
            <div class="sList2">
              <div class="clearfix">
                <router-link to="zbproList.html">桌布罩件</router-link
                ><router-link to="bzproList.html">抱枕靠垫</router-link>
              </div>
            </div>
          </li>
          <!-- 第四、N个品类。。。。。。。。。 -->
          <li><router-link to="paint.html">墙式壁挂</router-link></li>
          <li><router-link to="perfume.html">蜡艺香薰</router-link></li>
          <li><router-link to="idea.html">创意家居</router-link></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderCom",
  data() {
    return {
      visitable: "display:none;",
      visitable1: "display:none;",
      sList111:"disply:none;",
      visitable2:"disply:none;",
      ggg:"disply:none;"
    };
  },
  methods: {
    overTag() {
      this.visitable = "display:block;";
      //console.log(this.flag)
    },
    outTag() {
      this.visitable = "display:none;";
    },
    overTag2() {
      this.visitable2 = "display:block;";
      //console.log(this.flag)
    },
    outTag2() {
      this.visitable2 = "display:none;";
    },
    overShow(){
      this.visitable1 = "display:block;"
    },
    outShow(){
      this.visitable1 = "display:none;"
    },
    sss(){
      this.ggg="display:block;"
    },
    ddd(){
      this.ggg="display:none;"
    },
  },
};
</script>

<style></style>
