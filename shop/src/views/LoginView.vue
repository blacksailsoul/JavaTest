<template>
  <div class="login">
    <img src="../assets/img/temp/19.jpg" />
    <form action="#" method="post">
      <h1> 
        <router-link to="/flowerder"><img src="../assets/img/temp/logo.png" /></router-link>
      </h1>
      <p></p>
      <div class="msg-warn hide">
        <b></b>公共场所不建议自动登录，以防账号丢失
      </div>
      <p>
        <input type="text" name="" value="" placeholder="用户名" v-model="username"/>
      </p>
      <p><input type="text" name="" value="" placeholder="密码" v-model="password"/></p>
      <p><input type="button" name="" value="登录"  @click="clickBtn()"/></p>
      <p class="txt">
        <router-link class="" to="/register">免费注册</router-link
        ><router-link to="/forgetpassword">忘记密码？</router-link>
      </p>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginView",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    clickBtn() {
      var param = new URLSearchParams();
      param.append("username", this.username);
      param.append("password", this.password);
      if (this.username != "" && this.password != "") {
        this.axios
          .post("http://localhost:8080/users/login", param)
          .then((response) => {
            console.log(response.data);
            localStorage.setItem(
              "userInfo",
              JSON.stringify(response.data.data)
            );
            if (response.data.code == 200) {
              localStorage.setItem("userInfo", JSON.stringify(response.data.data));
              this.$router.push({ path: "/flowerder" });
            } else {
              alert(response.data.message);
            }
          });
      }else{
        alert("请输入完整信息")
      }
    },
  },
};
</script>

<style></style>
