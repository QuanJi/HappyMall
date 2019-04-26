<%@ page import="java.util.List" %>
<%@ page import="pojo.Goods" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/7 0007
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--_footer 作为公共模版分离出去-->
    <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

    <!--请在下方写此页面业务相关的脚本-->
    <script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>

    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->

    <title>商品列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>商品管理 <span class="c-gray en">&gt;</span> 商品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form action="article-list.action" method="post">
        <input type="text" style="display: none" name="page" value="1"/>
         <div class="text-c">
        <!--<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>-->
        <span class="select-box inline">
		<select name="condition"  class="select">
			<option value="">全部分类</option>
            <C:forEach items="${column}" var="item">
                <option value="${item.sonColumn}">${item.sonColumn}</option>
            </C:forEach>

		</select>
		</span><!-- 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">

		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;">-->
        <input type="text" name="content"   placeholder=" 搜索内容" style="width:250px" class="input-text">
        <button  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l"><input type="button" class="btn btn-danger radius" onclick="deleteAllID()" value="批量删除" > </input> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.action" onClick="Hui_admin_tab(this)" href="javascript:;"><em class="Hui-iconfont"></em> 添加商品</a></span> <span class="r">当前：<strong>${page} </strong>   页;共有数据：<strong id="Alltotal">54</strong> 条</span></div>
    <form name="deleteID" method="post">
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="50">ID</th>
                <th width="100">商品名称</th>
                <th width="80">分类</th>
                <th width="80">价格</th>
                <th width="100">店铺名称</th>
                <th width="150">图片链接</th>
                <th width="120">操作</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${goodsList.goodsList}" var="goods" varStatus="item">
            <tr class="text-c">
                <td><input type="checkbox" value="${goods.id}" name="deleteID"></td>
                <td>${goods.id}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.goodsClassify}</td>
                <td>${goods.goodsPrice}</td>
                <td>${goods.storeName}</td>
                <td>${goods.goodsImage}</td>

                <td class="f-14 td-manage"><a style="text-decoration:none"  onclick="displayInfo('${goods.goodsDescribe}')"  title="详情">详情</a> <a style="text-decoration:none" class="ml-5"  href="updateGoods.action?index=${goods.id}" title="编辑"><em class="Hui-iconfont"></em></a> <a style="text-decoration:none" class="ml-5" onClick="goods_del('${goods.id}')" href="javascript:;" title="删除"><em class="Hui-iconfont"></em></a></td>
            </tr>

            </c:forEach>

            <div id="info" style="display: none"></div>
            </tbody>

        </table>
        <a class="btn btn-primary radius" id="nextPage"  style="float: right;margin: 10px">下一页</a>
        <a class="btn btn-primary radius" id="previousPage" style="float: right;margin: 10px">上一页</a>
    </div>
    </form>
</div>

<script type="text/javascript">
$(document).ready(function () {
   var page=${page};
   var total=${goodsList.total};
   $("#Alltotal").html(total);
   console.log($("#Alltotal").val());
   if(page*10>=total){
       $("#nextPage").click(function () {
           alert("已经最后一页！");
       })
   }
   else
       $("#nextPage").attr("href","article-list.action?page=${page+1}&condition&content");
    if(page>=2)
        $("#previousPage").attr("href","article-list.action?page=${page-1}&condition&content");
    else
        $("#previousPage").click(function () {
            alert("当前为第一页！");
        })
});

    function goods_del(id) {
        $.ajax({
            type:"post",
            async:true,
            data:{deleteID:id},
            datatype:"json",
            url:"deleteAllID.action",
            success:function () {
                    alert("删除成功！")
                    location.reload();
            },
            error:function () {
                alert("删除失败！")
            }
        })
    }
    function displayInfo(info) {
        alert(info);
    }
function deleteAllID() {
    var deleteNum = $("input[name='deleteID']:checked").length;
    if(deleteNum==0){
        alert("请至少选择一项！")
    }
    else {
        if(confirm("您确定删除吗？")){
            document.deleteID.action="deleteAllID.action";
            document.deleteID.submit();
        }
        alert("删除成功！")
    }

};
    var judgeInfo='${judge}';
    if(judgeInfo=="ok"){
        alert("添加成功！");
    }
    var updateInfo='${update}';
    if(updateInfo=="ok")
        alert("更改成功！")


</script>
</body>
</html>
