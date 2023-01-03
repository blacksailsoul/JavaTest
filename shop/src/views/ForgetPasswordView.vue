<template>
  <div>
    <div class="forgetPwd">
      <!-----------------logo------------------->
      <div class="logo">
        <h1 class="wrapper clearfix">
          <router-link to="/flowerder">
          <img class="forgetPicture" src="../assets/img/logo.png" />
          </router-link>
        </h1>
      </div>
      <div class="forCon">
        <p>安全设置-找回密码</p>
        <ul>
          <li :class="check1"><span>01/</span>输入登录名</li>
          <li :class="check2"><span>02/</span>验证信息</li>
          <li :class="check3"><span>03/</span>重置密码</li>
        </ul>
        <div class="formCon">
          <!--步骤1-->
          <form action="#" method="post" class="one" :style="first">
            <input
              type="text"
              value=""
              placeholder="昵称"
              v-model="username"
            /><label>请输入昵称</label
            ><input
              type="button"
              value="下一步"
              class="next"
              @click="clickfirst()"
            />
          </form>
          <!--步骤2-->
          <form
            action="#"
            method="post"
            class="two"
            :style="second"
            @click="clicksecond()"
          >
            <p>电子邮箱：<input/>{{ email }}</p>
            <p class="tip">
              验证邮件已发往你的电子邮箱，请点击邮件中的链接完成验证
            </p>
            <input type="button" value="去邮箱验证" class="next1" />
          </form>
          <!--步骤3-->
          <form action="#" method="post" class="three" :style="third">
            <label>新密码：</label><input type="text" value=""  v-model="password1"/><br /><label
              >确认密码：</label
            ><input type="text" value="" v-model="password2"/><br /><input
              type="button"
              value="完成"
              @click="clickthird()"
            />
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ForgetPasswordView",
  data() {
    return {
      uid: "",
      username: "",
      email: "",
      password1: "",
      password2: "",
      first: "display:block",
      second: "display:none",
      third: "display:none",
      check1: "on",
      check2: "none",
      check3: "none",
    };
  },
  methods: {
    clickfirst() {
      var param = new URLSearchParams();
      param.append("username", this.username);
      if (this.username != "") {
        this.axios
          .post("http://localhost:8080/users/getPwdBack", param)
          .then((res) => {
            console.log(res.data);
            if (res.data.code == 200) {
              this.email = res.data.data.email;
              this.uid = res.data.data.uid;
              this.first = "display:none";
              this.second = "display:block";
              this.check1 = "none";
              this.check2 = "on";
            } else {
              alert(res.data.message);
            }
          });
      } else {
        alert("请输入完整信息");
      }
    },
    clicksecond() {
      this.second = "display:none";
      this.third = "display:block";
      this.check2 = "none";
      this.check3 = "on";
    },
    clickthird() {
      var param = new URLSearchParams();
      param.append("uid",this.uid)
      param.append("newPassword",this.password1)
      param.append("conNewPassword",this.password2)
      if(this.password1 != "" && this.password2 != ""){
        if(this.password1 == this.password2){
          this.axios.post("http://localhost:8080/users/editPwdGetPwdBack",param).then((res) => {
          console.log(res.data);
          if(res.data.code == 200){
            this.$router.push({path:"/login"});
          }else{
            alert(res.data.message);
          }
        })
        }else{
          alert("新密码与确认密码不一致，请重新输入")
        }
      }else{
        alert("请输入完整信息")
      }
    },
  },
};
</script>

<style></style>
