<template>
  <div>
    <!-- Header -->

    <!------------------------------idea------------------------------>
    <div class="address mt">
      <div class="wrapper clearfix">
        <router-link to="/flowerder" class="fl">首页</router-link><span>/</span
        ><router-link to="/myinformation" class="on">个人信息</router-link>
      </div>
    </div>
    <!------------------------------Bott------------------------------>
    <div class="Bott">
      <div class="wrapper clearfix">
        <div class="zuo fl">
          <h3>
            <a href="#"><img src="../assets/img/tx.png" /></a>
            <p class="clearfix">
              <span class="fl">[张三]</span><span class="fr">[退出登录]</span>
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
          <h2>修改密码</h2>
          <form action="#" method="get" class="remima">
            <p>
              <span>原密码：</span><input type="text" v-model="oldpassword" />
            </p>
            <p class="op">输入原密码</p>
            <p>
              <span>新密码：</span><input type="text" v-model="newpassword1" />
            </p>
            <p class="op">
              6-16
              个字符，需使用字母、数字或符号组合，不能使用纯数字、纯字母、纯符号
            </p>
            <p>
              <span>重复新密码：</span
              ><input type="text" v-model="newpassword2" />
            </p>
            <input type="submit" value="提交" @click="clickBtn()" />
          </form>
        </div>
      </div>
    </div>
    <!--返回顶部-->

    <!--footer-->

  </div>
</template>

<script>
export default {
  name: "MyChangepasswordView.vue",
  data() {
    return {
      uid: "",
      oldpassword: "",
      newpassword1: "",
      newpassword2: "",
    };
  },
  methods: {
    clickBtn() {
      var userInfo = JSON.parse(localStorage.getItem("userInfo"));
      this.uid = userInfo.uid;
      var param = new URLSearchParams();
      param.append("uid", this.uid);
      param.append("oldPassword", this.oldpassword);
      param.append("newPassword", this.newpassword1);
      param.append("conNewPassword", this.newpassword2);
      if (
        this.oldpassword != "" &&
        this.newpassword1 != "" &&
        this.newpassword2 != ""
      ) {
        this.axios
          .post("http://localhost:8080/users/editPassword", param)
          .then((res) => {
            console.log(res.data);
            if (res.data.code == 200) {
              alert("修改密码成功");
              this.$router.push({ path: "/login" });
            } else {
              alert(res.data.message);
            }
          });
      } else {
        alert("请输入完整信息");
      }
    },
  },
};
</script>

<style></style>
