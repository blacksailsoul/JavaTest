<template>
  <div class="reg">
    <img src="../assets/img/temp/20.jpg" />
    <form action="#" method="post">
      <h1>
        <router-link to="/flowerder"><img src="../assets/img/temp/logo.png" /></router-link>
      </h1>
      <p>用户注册</p>
      <p>
        <input
          type="text"
          name=""
          value=""
          placeholder="请输入用户名"
          v-model="username"
        />
      </p> 
            <p class="txtL txt">
        <input
          type="text"
          name=""
          value=""
          placeholder="请输入邮箱地址"
          v-model="email"
        />
      </p>
      <p>
        <input
          type="text"
          name=""
          value=""
          placeholder="请输入密码"
          v-model="password1"
        />
      </p>
      <p>
        <input
          type="text"
          name=""
          value=""
          placeholder="请确认密码"
          v-model="password2"
        />
      </p>
      <p><input type="button" name="" value="注册" @click="clickBtn()" /></p>
      <p class="txtL txt">
        完成此注册，即表明您同意了我们的<a href="#"> 使用条款和隐私策略 </a>
      </p>
      <p class="txt">
        <router-link to="/login"><span></span>已有账号登录</router-link>
      </p>
      <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
  </div>
</template>

<script>
export default {
  name: "RegisterView",
  data() {
    return {
      username: "",
      email:"",
      password1: "",
      password2: "",
    };
  },
  methods: {
    clickBtn() {
      if (this.username != "" && this.email != "" && this.password1 != "" && this.password2 != "") {
        if (this.password1 == this.password2) {
          this.axios
            .post("http://localhost:8080/users/reg", {
              username: this.username,
              email:this.email,
              password: this.password1,
            })
            .then((response) => {
              console.log(response.data);
              if (response.data.code == 200) {
                alert("注册成功");
              } else {
                alert(response.data.message);
              }
            });
        }else{
          alert("密码和确认密码不一致，请重新输入")
        }
      }else{
        alert("请输入完整信息")
      }
    },
  },
};
</script>

<style></style>
