<template>
  <div>
    <div class="address">
      <div class="wrapper clearfix">
        <router-link to="/flowerder">首页</router-link><span>/</span
        ><router-link :to="bigUrl">{{ bigCategory }}</router-link
        ><span>/</span
        ><router-link :to="smallUrl">{{ smallCategory }}</router-link
        ><span>/</span><a href="#" class="on">{{ detailObj.title }}</a>
      </div>
    </div>
    <!-----------------------Detail------------------------------>
    <div class="detCon">
      <div class="proDet wrapper">
        <div class="proCon clearfix">
          <div class="proImg fl" v-if="detailObj">
            <img
              class="det"
              :src="require('../assets' + detailObj.image + '.jpg')"
              :style="{ display: flag ? 'block' : 'none' }"
            />
            <div
              v-for="item in imageList"
              :key="item.id"
              :style="{ display: item.showBoolean ? 'block' : 'none' }"
            >
              <img :src="item.bUrl" width="100px" height="600px" />
            </div>
            <div
              v-for="(item2, index) in imageList"
              :key="item2.index"
              style="float: left"
              @click="clickSmall(index)"
            >
              <img :src="item2.sUrl" />
            </div>
          </div>
          <div class="fr intro">
            <div class="title">
              <h4>{{ detailObj.title }}</h4>
              <p>
                {{ detailObj.sellPoint }}
              </p>
              <span>￥{{ detailObj.price }}</span>
            </div>
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
              <p>
                数量&nbsp;&nbsp;库存<span>{{ detailObj.stock }}</span
                >件
              </p>
              <div class="num clearfix">
                <img
                  class="fl sub"
                  src="../assets/img/temp/sub.jpg"
                  @click="reduce()"
                />
                <input
                  id="num"
                  type="text"
                  size="2"
                  readonly="readonly"
                  class="fl"
                  contentEditable="true"
                  style="text-align: center"
                  v-model="num"
                />

                <img
                  class="fl add"
                  src="../assets/img/temp/add.jpg"
                  @click="add()"
                />
                <p class="please fl">请选择商品属性!</p>
              </div>
            </div>
            <div class="btns clearfix">
              <a href="#2"><p class="buy fl">立即购买</p></a
              ><a href="#2"
                ><p class="cart fr" @click="toCart()">加入购物车</p></a
              >
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="introMsg wrapper clearfix">
      <div class="msgL fl">
        <div class="msgTit clearfix">
          <a class="on" @click="ShowAndHide">商品详情</a>
          <a @click="ShowAndHide">所有评价</a>
        </div>
        <div class="msgAll">
          <div class="msgImgs" v-if="productBoolean">
            <img src="../assets/img/temp/det01.jpg" /><img
              src="../assets/img/temp/det02.jpg"
            /><img src="../assets/img/temp/det03.jpg" /><img
              src="../assets/img/temp/det04.jpg"
            /><img src="../assets/img/temp/det05.jpg" /><img
              src="../assets/img/temp/det06.jpg"
            /><img src="../assets/img/temp/det07.jpg" />
          </div>
          <div class="eva" v-if="productBoolean">
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per01.jpg" />
              <div class="perR fl">
                <p>馨***呀</p>
                <p>
                  不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分
                </p>
                <div class="clearfix">
                  <p><img src="../assets/img/temp/eva01.jpg" /></p>
                  <p><img src="../assets/img/temp/eva02.jpg" /></p>
                  <p><img src="../assets/img/temp/eva03.jpg" /></p>
                  <p><img src="../assets/img/temp/eva04.jpg" /></p>
                  <p><img src="../assets/img/temp/eva05.jpg" /></p>
                </div>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per02.jpg" />
              <div class="perR fl">
                <p>么***周</p>
                <p>
                  花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！
                </p>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per01.jpg" />
              <div class="perR fl">
                <p>馨***呀</p>
                <p>
                  不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分
                </p>
                <div class="clearfix">
                  <p><img src="../assets/img/temp/eva01.jpg" /></p>
                  <p><img src="../assets/img/temp/eva02.jpg" /></p>
                  <p><img src="../assets/img/temp/eva03.jpg" /></p>
                  <p><img src="../assets/img/temp/eva04.jpg" /></p>
                  <p><img src="../assets/img/temp/eva05.jpg" /></p>
                </div>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per02.jpg" />
              <div class="perR fl">
                <p>么***周</p>
                <p>
                  花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！
                </p>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per01.jpg" />
              <div class="perR fl">
                <p>馨***呀</p>
                <p>
                  不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分
                </p>
                <div class="clearfix">
                  <p><img src="../assets/img/temp/eva01.jpg" /></p>
                  <p><img src="../assets/img/temp/eva02.jpg" /></p>
                  <p><img src="../assets/img/temp/eva03.jpg" /></p>
                  <p><img src="../assets/img/temp/eva04.jpg" /></p>
                  <p><img src="../assets/img/temp/eva05.jpg" /></p>
                </div>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per02.jpg" />
              <div class="perR fl">
                <p>么***周</p>
                <p>
                  花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！
                </p>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per01.jpg" />
              <div class="perR fl">
                <p>馨***呀</p>
                <p>
                  不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分
                </p>
                <div class="clearfix">
                  <p><img src="../assets/img/temp/eva01.jpg" /></p>
                  <p><img src="../assets/img/temp/eva02.jpg" /></p>
                  <p><img src="../assets/img/temp/eva03.jpg" /></p>
                  <p><img src="../assets/img/temp/eva04.jpg" /></p>
                  <p><img src="../assets/img/temp/eva05.jpg" /></p>
                </div>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per02.jpg" />
              <div class="perR fl">
                <p>么***周</p>
                <p>
                  花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！
                </p>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per01.jpg" />
              <div class="perR fl">
                <p>馨***呀</p>
                <p>
                  不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分
                </p>
                <div class="clearfix">
                  <p><img src="../assets/img/temp/eva01.jpg" /></p>
                  <p><img src="../assets/img/temp/eva02.jpg" /></p>
                  <p><img src="../assets/img/temp/eva03.jpg" /></p>
                  <p><img src="../assets/img/temp/eva04.jpg" /></p>
                  <p><img src="../assets/img/temp/eva05.jpg" /></p>
                </div>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
            <div class="per clearfix">
              <img class="fl" src="../assets/img/temp/per02.jpg" />
              <div class="perR fl">
                <p>么***周</p>
                <p>
                  花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！
                </p>
                <p>
                  <span>2016年12月27日08:31</span
                  ><span>颜色分类：大中小三件套（不含花）</span>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="msgR fr">
        <h4>为你推荐</h4>
        <div class="seeList">
          <a href="#">
            <dl>
              <dt><img src="../assets/img/temp/see01.jpg" /></dt>
              <dd>【最家】复古文艺风玻璃花瓶</dd>
              <dd>￥193.20</dd>
            </dl> </a
          ><a href="#">
            <dl>
              <dt><img src="../assets/img/temp/see02.jpg" /></dt>
              <dd>【最家】复古文艺风玻璃花瓶</dd>
              <dd>￥193.20</dd>
            </dl> </a
          ><a href="#">
            <dl>
              <dt><img src="../assets/img/temp/see03.jpg" /></dt>
              <dd>【最家】复古文艺风玻璃花瓶</dd>
              <dd>￥193.20</dd>
            </dl> </a
          ><a href="#">
            <dl>
              <dt><img src="../assets/img/temp/see04.jpg" /></dt>
              <dd>【最家】复古文艺风玻璃花瓶</dd>
              <dd>￥193.20</dd>
            </dl>
          </a>
        </div>
      </div>
    </div>
    <div class="like">
      <h4>猜你喜欢</h4>
      <div class="bottom">
        <div class="hd">
          <span class="prev"><img src="../assets/img/temp/prev.png" /></span
          ><span class="next"><img src="../assets/img/temp/next.png" /></span>
        </div>
        <div class="imgCon bd">
          <div class="likeList clearfix">
            <div>
              <a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like01.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like02.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like03.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like04.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html" class="last">
                <dl>
                  <dt><img src="../assets/img/temp/like05.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl>
              </a>
            </div>
            <div>
              <a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like01.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like02.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like03.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html">
                <dl>
                  <dt><img src="../assets/img/temp/like04.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl> </a
              ><a href="proDetail.html" class="last">
                <dl>
                  <dt><img src="../assets/img/temp/like05.jpg" /></dt>
                  <dd>【最家】复古文艺风玻璃花瓶</dd>
                  <dd>￥193.20</dd>
                </dl>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--返回顶部-->

    <!--footer-->
  </div>
</template>

<script>
export default {
  name: "ProDetail",
  data() {
    return {
      detailObj: "",
      bigCategory: "",
      smallCategory: "",
      bigUrl: "",
      smallUrl: "",
      num: 1,
      flag: true,
      productBoolean:true,

      // <img
      // src="../assets/img/temp/proDet01.jpg"
      // data-src="../assets/img/temp/proDet01_big.jpg"
      // /><img
      // src="../assets/img/temp/proDet02.jpg"
      // data-src="../assets/img/temp/proDet02_big.jpg"
      // /><img
      // src="../assets/img/temp/proDet03.jpg"
      // data-src="../assets/img/temp/proDet03_big.jpg"
      // /><img
      // src="../assets/img/temp/proDet04.jpg"
      // data-src="../assets/img/temp/proDet04_big.jpg"
      // />
      imageList: [
        {
          id: 1,
          bUrl: require("../assets/img/temp/proDet01_big.jpg"),
          sUrl: require("../assets/img/temp/proDet01.jpg"),
          showBoolean: false,
        },
        {
          id: 2,
          bUrl: require("../assets/img/temp/proDet02_big.jpg"),
          sUrl: require("../assets/img/temp/proDet02.jpg"),
          showBoolean: false,
        },
        {
          id: 3,
          bUrl: require("../assets/img/temp/proDet03_big.jpg"),
          sUrl: require("../assets/img/temp/proDet03.jpg"),
          showBoolean: false,
        },
        {
          id: 4,
          bUrl: require("../assets/img/temp/proDet04_big.jpg"),
          sUrl: require("../assets/img/temp/proDet04.jpg"),
          showBoolean: false,
        },
      ],
    };
  },
  created() {
    console.log(this.$route.query);
    // 拿到首页传递过来的商品pid
    // 发送ajax请求到服务器根据pid获取商品详情数据
    this.axios
      .get("http://localhost:8080/products/detail/" + this.$route.query.pid, {
        params: {
          pid: this.$route.query.pid,
        },
      })
      .then((res) => {
        console.log(res.data);
        if (res.data.code == 200) {
          this.detailObj = res.data.data;

          if (this.detailObj.bigCategory == 3) {
            this.bigCategory = "装饰摆件";
            this.bigUrl = "/flowerder";
            if (this.detailObj.smallCategory == 1) {
              this.smallCategory = "干花花艺";
              this.smallUrl = "/prolist";
            } else if (this.detailObj.smallCategory == 2) {
              this.smallCategory = "花瓶花器";
              this.smallUrl = "/vaseprolist";
            }
          } else if (this.detailObj.bigCategory == 4) {
            this.bigCategory = "布艺软饰";
            this.bigUrl = "";
            if (this.detailObj.smallCategory == 1) {
              this.smallCategory = "桌布罩件";
              this.smallUrl = "";
            } else if (this.detailObj.smallCategory == 2) {
              this.smallCategory = "抱枕靠垫";
              this.smallUrl = "";
            }
          } else if (this.detailObj.bigCategory == 5) {
            this.bigCategory = "墙饰壁挂";
            this.bigUrl = "";
          } else if (this.detailObj.bigCategory == 6) {
            this.bigCategory = "蜡艺香薰";
            this.bigUrl = "";
          } else if (this.detailObj.bigCategory == 7) {
            this.bigCategory = "创意家居";
            this.bigUrl = "";
          }
        }
      });
  },
  methods: {
    reduce() {
      if (this.num > 1) {
        this.num = this.num - 1;
      }
    },
    add() {
      this.num = this.num + 1;
    },
    ShowAndHide(){
      this.productBoolean = !this.productBoolean
    }
    ,
    clickSmall(index) {
      this.flag = false;

      // 循环大图片数组将所有的大图片隐藏
      this.imageList.forEach((item) => {
        item.showBoolean = false;
      });
      // 将当前点击小图片对应的下标的大图片展示
      this.imageList[index].showBoolean = true;
    },
    toCart() {
      this.$store.state.list.push({ tile: this.detailObj.title, price: this.detailObj.price,num:1 });
      alert("加入购物车")
    },
  },

    
};

</script>

<style></style>
