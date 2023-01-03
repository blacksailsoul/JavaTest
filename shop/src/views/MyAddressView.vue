<template>
  <div>
    <!-- Header -->
    
    <!------------------------------idea------------------------------>
    <div class="address mt">
      <div class="wrapper clearfix">
        <router-link to="/floweder" class="fl">首页</router-link><span>/</span
        ><router-link to="/mycenter">个人中心</router-link><span>/</span
        ><router-link to="/myaddress" class="on">地址管理</router-link>
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
          <h2>收货地址</h2>
          <div class="add">
            <div>
              <a href="#2" id="addxad" @click="addBtn()"
                ><img src="../assets/img/jia.png" /></a
              ><span>添加新地址</span>
            </div>
            <div id="dizhi" v-for="(item, index) in addressList" :key="item.id">
              <p>{{ item.name }}</p>
              <p>{{ item.phone }}</p>
              <p>{{ item.province }}{{ item.city }}{{ item.county }}</p>
              <p>{{ item.detailArea }}{{ item.postCode }}</p>
              <input type="button" value="修改" @click="changeaddress(index)" />
              <input type="button" value="删除" @click="deleteaddress(index)" />
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--编辑弹框--><!--遮罩-->
    <div class="mask"></div>
    <div class="adddz" :style="addaddress">
      <form action="#" method="get">
        <input type="text" placeholder="姓名" class="on" v-model="name" /><input
          type="text"
          placeholder="手机号"
          v-model="phone"
        />
        <div class="city">
          <input type="text" placeholder="省/自治区" v-model="province" />
          <input type="text" placeholder="城市地区" v-model="city" />
          <input type="text" placeholder="区县" v-model="county" />
        </div>
        <textarea
          name=""
          rows=""
          cols=""
          placeholder="详细地址"
          v-model="detailarea"
        ></textarea
        ><input type="text" placeholder="邮政编码" v-model="postcode" />
        <div class="bc">
          <input type="button" value="保存" @click="clickBtn()" /><input
            type="button"
            value="取消"
            @click="disaddBtn()"
          />
        </div>
      </form>
    </div>
    <!--返回顶部-->

    <!--footer-->

  </div>
</template>

<script>
export default {
  name: "MyAddressView",
  data() {
    return {
      aid: "",
      name: "",
      phone: "",
      province: "",
      city: "",
      county: "",
      detailarea: "",
      postcode: "",
      addaddress: "display:none",
      addressList: [],
    };
  },
  methods: {
    addBtn() {
      this.addaddress = "display:block";
    },
    disaddBtn() {
      this.addaddress = "display:none";
    },
    // 添加新地址
    clickBtn() {
      console.log(this.name);
      console.log(this.phone);
      console.log(this.province);
      console.log(this.city);
      console.log(this.county);
      console.log(this.detailarea);
      console.log(this.postcode);
      console.log(this.aid);
      if (
        this.name != "" &&
        this.phone != "" &&
        this.province != "" &&
        this.city != "" &&
        this.county != "" &&
        this.detailarea != "" &&
        this.postcode != ""
      ) {
        var userInfo = JSON.parse(localStorage.getItem("userInfo"));
        console.log(userInfo.uid);
        this.axios
          .post("http://localhost:8080/address/editAddress", {
            uid: userInfo.uid,
            aid: this.aid,
            name: this.name,
            phone: this.phone,
            province: this.province,
            city: this.city,
            county: this.county,
            detailArea: this.detailarea,
            postCode: this.postcode,
          })
          .then((response) => {
            console.log(response.data);
            if (response.data.code == 200) {
              alert("成功");
              this.addaddress = "display:none";
              this.aid = "";
              var userInfo = JSON.parse(localStorage.getItem("userInfo"));
              this.axios
                .get("http://localhost:8080/address/getList", {
                  params: { uid: userInfo.uid },
                })
                .then((res) => {
                  console.log(res.data);
                  if (res.data.code == 200) {
                    this.addressList = res.data.data;
                  } else {
                    alert(res.data.message);
                  }
                });
            } else {
              alert(response.data.message);
            }
          });
      } else {
        alert("请输入完整信息");
      }
    },
    changeaddress(index) {
      this.addaddress = "display:block";
      this.name = this.addressList[index].name;
      this.phone = this.addressList[index].phone;
      this.province = this.addressList[index].province;
      this.city = this.addressList[index].city;
      this.county = this.addressList[index].county;
      this.detailarea = this.addressList[index].detailArea;
      this.postcode = this.addressList[index].postCode;
      this.aid = this.addressList[index].aid;
    },

    // 删除地址
    deleteaddress(index) {
      this.axios
        .delete("http://localhost:8080/address/deleteAddress", {
          params: {
            uid: this.addressList[index].uid,
            aid: this.addressList[index].aid,
          },
        })
        .then((res) => {
          console.log(res.data);
          if (res.data.code == 200) {
            alert("删除成功");
            var userInfo = JSON.parse(localStorage.getItem("userInfo"));
            this.axios
              .get("http://localhost:8080/address/getList", {
                params: { uid: userInfo.uid },
              })
              .then((res) => {
                console.log(res.data);
                if (res.data.code == 200) {
                  this.addressList = res.data.data;
                } else {
                  alert(res.data.message);
                }
              });
          } else {
            alert(res.data.message);
          }
        });
    },
  },
  // 获取地址列表
  created() {
    var userInfo = JSON.parse(localStorage.getItem("userInfo"));
    this.axios
      .get("http://localhost:8080/address/getList", {
        params: { uid: userInfo.uid },
      })
      .then((res) => {
        console.log(res.data);
        if (res.data.code == 200) {
          this.addressList = res.data.data;
        } else {
          alert(res.data.message);
        }
      });
  },
};
</script>

<style></style>
