<template>
<div>
  <div class="order cart mt"><!-----------------site------------------->
    <div class="site"><p class="wrapper clearfix"><span class="fl">订单确认</span>
    <!-- <img class="top" src="../assets/img/temp/cartTop02.png"> -->
    </p>
    </div><!-----------------orderCon------------------->
    <div class="orderCon wrapper clearfix">
        <div class="orderL fl"><!--------h3----------------><h3>收件信息<a href="#" class="fr">新增地址</a></h3>
            <!--------addres---------------->
            <div class="addres clearfix">
                <div class="addre fl on">
                    <div class="tit clearfix"><p class="fl">张三 <span class="default">[默认地址]</span></p>
                        <p class="fr"><a href="#">删除</a><span>|</span><a href="#" class="edit">编辑</a></p></div>
                    <div class="addCon"><p>湖北省&nbsp;武汉市&nbsp;洪山区&nbsp;武汉理工大学</p>
                        <p>123</p></div>
                </div>
            </div>
            <h3>支付方式</h3><!--------way---------------->
            <div class="way clearfix"><img class="onmoney" src="../assets/img/temp/way01.jpg"><img class="onmoney" src="../assets/img/temp/way02.jpg"><img class="onmoney"
                    src="../assets/img/temp/way03.jpg"><img class="onmoney" src="../assets/img/temp/way04.jpg"></div>
            <h3>选择快递</h3><!--------dis---------------->
            <div class="dis clearfix"><span class="on">顺风快递</span><span>百世汇通</span><span>圆通快递</span><span>中通快递</span>
            </div>
        </div>
        <div class="orderR fr">
            <div class="msg"><h3>订单内容<router-link to="mycart" class="fr">返回购物车</router-link></h3><!--------ul---------------->
                <!-- <ul class="clearfix">
                    <li class="fl"><img src="../assets/img/temp/order02.jpg"></li>
                    <li class="fl"><p>非洲菊仿真花干花</p>
                        <p>颜色分类：白色</p>
                        <p>数量：1</p></li>
                    <li class="fr">￥11</li>
                </ul>
                <ul class="clearfix">
                    <li class="fl"><img src="../assets/img/temp/order02.jpg"></li>
                    <li class="fl"><p>非洲菊仿真花干花</p>
                        <p>颜色分类：白色</p>
                        <p>数量：1</p></li>
                    <li class="fr">￥11</li>
                </ul> -->
            </div><!--------tips---------------->
            <div class="tips"><p><span class="fl">商品金额：</span><span class="fr">￥0</span></p>
                <p><span class="fl">优惠金额：</span><span class="fr">￥0.00</span></p>
                <p><span class="fl">运费：</span><span class="fr">免运费</span></p></div><!--------tips count---------------->
            <div class="count tips"><p><span class="fl">合计：</span><span class="fr">￥0</span></p></div>
        <a href="ok.html" class="pay">去支付</a></div>
</div>
</div><!--编辑弹框--><!--遮罩-->
<div class="mask"></div>
<div class="adddz editAddre">
    <form action="#" method="get"><input type="text" placeholder="姓名" class="on"/><input type="text" placeholder="手机号"/>
        <div class="city"><select name="">
            <option value="省份/自治区">省份/自治区</option>
        </select><select>
            <option value="城市/地区">城市/地区</option>
        </select><select>
            <option value="区/县">区/县</option>
        </select><select>
            <option value="配送区域">配送区域</option>
        </select></div>
        <textarea name="" rows="" cols="" placeholder="详细地址"></textarea><input type="text" placeholder="邮政编码"/>
        <div class="bc"><input type="button" value="保存"/><input type="button" value="取消"/></div>
    </form>
</div>
</div>
</template>

<script>
export default {
    name:"ComputedCom"

}
</script>

<style>

</style>