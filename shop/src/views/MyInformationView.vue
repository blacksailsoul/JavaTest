<template>
  <div>
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
          <h2>个人信息</h2>
          <div class="gxin">
            <div class="tx">
              <a href="#"
                ><img src="../assets/img/tx.png" />
                <p id="avatar" @click="changeavatar()">修改头像</p></a
              >
            </div>
            <div class="xx">
              <h3 class="clearfix">
                <strong class="fl">基础资料</strong
                ><a href="#" class="fr" id="edit1" @click="changebase()"
                  >编辑</a
                >
              </h3>
              <div>姓名：{{ username }}</div>
              <div>生日:{{ birthday }}</div>
              <div>性别：{{ sex }}</div>
              <h3>高级设置</h3>
              <!--<div><span class="fl">银行卡</span><a href="#" class="fr">管理</a></div>-->
              <div>
                <span class="fl">{{address}}</span
                ><a href="#" class="fr" id="edit2" @click="changearea">修改</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--遮罩-->
    <div class="mask"></div>
    <!--编辑弹框-->
    <div class="bj" :style="base">
      <div class="clearfix">
        <a href="#" class="fr gb"><img src="../assets/img/icon4.png" /></a>
      </div>
      <h3>编辑基础资料</h3>
      <form action="#" method="get">
        <p><label>姓名：</label><input type="text" v-model="username" /></p>
        <p><label>生日：</label><input type="date" v-model="birthday" /></p>
        <p>
          <label>性别：</label
          ><span
            ><input type="radio" name="sex" value="男" v-model="sex" />男</span
          ><span
            ><input type="radio" name="sex" value="女" v-model="sex" />女</span
          >
        </p>
        <div class="bc">
          <input type="button" value="保存" @click="updatebase()" /><input
            type="button"
            value="取消"
            @click="dischangebase()"
          />
        </div>
      </form>
    </div>
    <!--高级设置修改-->
    <div class="xg" :style="area">
      <div class="clearfix">
        <a href="#" class="fr gb"><img src="../assets/img/icon4.png" /></a>
      </div>
      <h3>切换账号地区</h3>
      <form action="#" method="get">
        <p><label>地区：</label><input type="text" v-model="address" /></p>
        <div class="bc">
          <input type="button" value="保存" @click="updatearea()" /><input
            type="button"
            value="取消"
            @click="dischangearea()"
          />
        </div>
      </form>
    </div>
    <!--修改头像-->
    <div class="avatar" :style="avatar">
      <div class="clearfix">
        <a href="#" class="fr gb"><img src="../assets/img/icon4.png" /></a>
      </div>
      <h3>修改头像</h3>
      <form action="#" method="get">
        <h4>请上传图片</h4>
        <input type="button" value="上传头像" />
        <p>jpg或png,大小不超过2M</p>
        <input type="button" value="提交" @click="dischangeavatar()" />
      </form>
    </div>
    <!--返回顶部-->

    <!--footer-->
  </div>
</template>

<script>
export default {
  name: "MyInformationView",
  data() {
    return {
      base: "display:none",
      area: "display:none",
      avatar: "display:none",
      username: "",
      birthday: "",
      sex: "男",
      address: "",
    };
  },
  methods: {
    changebase() {
      this.base = "display:block";
    },
    changearea() {
      this.area = "display:block";
    },
    changeavatar() {
      this.avatar = "display:block";
    },
    dischangebase() {
      this.base = "display:none";
    },
    dischangearea() {
      this.area = "display:none";
    },
    dischangeavatar() {
      this.avatar = "display:none";
    },
    updatebase() {
      if (this.username != "" && this.birthday != "" && this.sex != "") {
        var userInfo = JSON.parse(localStorage.getItem("userInfo"));
        var sexnum = 1;
        if (this.sex == "男") {
          sexnum = 1;
        } else {
          sexnum = 2;
        }
        this.axios
          .post("http://localhost:8080/users/editInfo", {
            uid: userInfo.uid,
            username: this.username,
            birthday: this.birthday,
            sex: sexnum,
          })
          .then((response) => {
            console.log(response.data);
            if (response.data.code == 200) {
              alert("修改信息成功");
              userInfo.username = this.username;
              userInfo.birthday = this.birthday;
              if(sexnum == 1){
                userInfo.sex = "男"
              }else{
                userInfo.sex = "女"
              }
              this.base = "display:none";

            } else {
              alert(response.data.message);
            }
          });
      } else {
        alert("请输入完整信息");
      }
    },
    updatearea() {
      if (this.address != "") {
        var param = new URLSearchParams();
        var userInfo = JSON.parse(localStorage.getItem("userInfo"));
        param.append("uid",userInfo.uid);
        param.append("address", this.address);
        this.axios
          .post("http://localhost:8080/users/editAddress", param)
          .then((res) => {
            console.log(res.data);
            if (res.data.code == 200) {
              alert("修改地址成功");
              this.area = "display:none";
            } else {
              alert(res.data.message);
            }
          });
      } else {
        alert("请输入完整信息");
      }
    },
  },
  created() {
    var userInfo = JSON.parse(localStorage.getItem("userInfo"));
    this.username = userInfo.username;
    this.birthday = userInfo.birthday;
    this.address = userInfo.address;
    if (userInfo.sex == 1) {
      this.sex = "男";
    } else {
      this.sex = "女";
    }
  },
};
</script>

<style></style>
