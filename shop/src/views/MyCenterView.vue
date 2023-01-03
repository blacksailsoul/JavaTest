<template>
  <div>
    <!-- Header -->

    <!------------------------------idea------------------------------>
    <div class="address mt" id="add">
      <div class="wrapper clearfix">
        <router-link to="/flowerder" class="fl">首页</router-link><span>/</span
        ><router-link to="/mycenter" class="on">个人中心</router-link>
      </div>
    </div>
    <!------------------------------Bott------------------------------>
    <div class="Bott">
      <div class="wrapper clearfix">
        <div class="zuo fl">
          <h3>
            <a href="#"><img src="../assets/img/tx.png" /></a>
            <p class="clearfix">
              <span class="fl">[羊羊羊]</span><span class="fr">[退出登录]</span>
            </p>
          </h3>
          <div>
            <h4>我的交易</h4>
            <ul>
              <li><router-link to="/mycart">我的购物车</router-link></li>
              <li><router-link to="/myorder">我的订单</router-link></li>
              <li><router-link to="/myevaluation">评价晒单</router-link></li>
            </ul>
            <h4>个人中心</h4>
            <ul>
              <li><router-link to="/mycenter">我的中心</router-link></li>
              <li class="on">
                <router-link to="/myaddress">地址管理</router-link>
              </li>
            </ul>
            <h4>账户管理</h4>
            <ul>
              <li><router-link to="/myinformation">个人信息</router-link></li>
              <li>
                <router-link to="/mychangepassword">修改密码</router-link>
              </li>
            </ul>
          </div>
        </div>
        <div class="you fl">
          <div class="tx clearfix">
            <div class="fl clearfix">
              <a href="#" class="fl"><img src="../assets/img/tx.png" /></a>
              <p class="fl">
                <span>六六六</span><router-link to="/myinformation">修改个人信息></router-link>
              </p>
            </div>
            <div class="fr">绑定邮箱：z*@**.com</div>
          </div>
          <div class="bott">
            <div class="clearfix">
              <a href="#" class="fl"><img src="../assets/img/gxin1.jpg" /></a>
              <p class="fl">
                <span>待支付的订单：<strong>0</strong></span
                ><a href="myorderq.html">查看待支付订单></a>
              </p>
            </div>
            <div class="clearfix">
              <a href="#" class="fl"><img src="../assets/img/gxin2.jpg" /></a>
              <p class="fl">
                <span>待收货的订单：<strong>0</strong></span
                ><a href="myorderq.html">查看待收货订单></a>
              </p>
            </div>
            <div class="clearfix">
              <a href="#" class="fl"><img src="../assets/img/gxin3.jpg" /></a>
              <p class="fl">
                <span>待评价的订单：<strong>0</strong></span
                ><a href="myprod.html">查看待评价订单></a>
              </p>
            </div>
            <div class="clearfix">
              <a href="#" class="fl"><img src="../assets/img/gxin4.jpg" /></a>
              <p class="fl">
                <span>喜欢的商品：<strong>0</strong></span
                ><a href="#">查看喜欢的商品></a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--返回顶部-->

    <!-- Footer -->
  </div>
</template>

<script>
export default {
  name: "MyCenterView",
};
</script>

<style></style>
