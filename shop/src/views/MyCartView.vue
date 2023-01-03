<template>
  <div>
    <!-- Header -->

    <div class="cart mt">
      <!-----------------site------------------->
      <div class="site">
        <p class="wrapper clearfix">
          <span class="fl">购物车</span>
          <!-- <img class="topIco" src="../assets/img/temp/cartTop01.png" style="height:20px,width:50px,float:left"/> -->
          <router-link to="/flowerder" class="fr">继续购物&gt;</router-link>
        </p>
      </div>
      <!-----------------table------------------->
      <div class="table wrapper">
        <div class="tr">
          <div>商品</div>
          <div>单价</div>
          <div>数量</div>
          <div>小计</div>
          <div>操作</div>
        </div>

        <div class="th" v-for="(item, i) in $store.state.list" :key="item.id">
          <div class="pro clearfix">
            <label class="fl"><input type="checkbox" /><span></span></label
            ><a class="fl" href="#">
              <dl class="clearfix">
                <dt class="fl"><img src="../assets/img/temp/proDet01.jpg" /></dt>
                <dd class="fl">
                  <p>{{ item.tile }}</p>
                </dd>
              </dl>
            </a>
          </div>
          <div class="price">￥{{ item.price }}</div>
          <div class="number">
            <p class="num clearfix">
              <img
                @click="reduceCount(i)"
                class="fl decrease"
                src="../assets/img/temp/sub.jpg"
              />
              <span class="fl">{{ item.num }} </span>
              <img
                @click="addCount(i)"
                class="fl increase"
                src="../assets/img/temp/add.jpg"
              />
            </p>
          </div>
          <div class="price sAll">￥{{ item.price * item.num }}</div>
          <div class="price">
            <td>
              <input
                type="button"
                class="cart-del btn btn-default btn-xs"
                value="删除"
                @click="del(index)"
              />
            </td>
          </div>
        </div>
        <!--  -->

        <div class="goOn">
          空空如也~<router-link to="index.html">去逛逛</router-link>
        </div>
        <div class="tr clearfix">
          <label class="fl"
            ><input class="checkAll" type="checkbox" /><span></span
          ></label>
          <p class="fl">
            <router-link to="#">全选</router-link
            ><router-link to="#" class="del">删除</router-link>
          </p>
          <p class="fr">
            <span>共<small id="sl">0</small>件商品</span
            ><span>合计:&nbsp;<small id="all">￥0.00</small></span
            ><router-link to="count" class="count">结算</router-link>
          </p>
        </div>
      </div>
    </div>
    <div class="mask"></div>
    <div class="tipDel">
      <p>确定要删除该商品吗？</p>
      <p class="clearfix">
        <a class="fl cer" href="#">确定</a
        ><a class="fr cancel" href="#">取消</a>
      </p>
    </div>
    <!--返回顶部-->

    <!--footer-->


    <!-------------------mask内容------------------->
    <!-- <div class="proDets">
      <img class="off" src="../assets/img/temp/off.jpg" />
      <div class="proCon clearfix">
        <div class="proImg fr">
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
        <div class="fl">
          <div class="proIntro change">
            <p>颜色分类</p>
            <div class="smallImg clearfix">
              <p class="fl on">
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
          </div>
          <div class="changeBtn clearfix">
            <router-link to="#2" class="fl"><p class="buy">确认</p></router-link
            ><router-link to="#2" class="fr"
              ><p class="cart">取消</p></router-link
            >
          </div>
        </div>
      </div>
    </div> -->
    <div class="pleaseC">
      <p>请选择宝贝</p>
      <img class="off" src="../assets/img/temp/off.jpg" />
    </div>
  </div>
</template>

<script>
export default {
  name: "MyCartView",
  methods: {
    addCount(index) {
      //点击加count按钮让state中的count默认每次加1
      //提交mutations中的修改数据源的方法，通过commit("定义的方法"，chuan'di)
      this.$store.state.list[index].num = this.$store.state.list[index].num + 1;
    },

    reduceCount(index) {
      this.$store.state.list[index].num = this.$store.state.list[index].num - 1;
    },
    del(index) {
      if (confirm("您确认删除这条商品吗？")) {
        this.$store.state.list.splice(index, 1);
      }
    },
  },
};
</script>

<style></style>
