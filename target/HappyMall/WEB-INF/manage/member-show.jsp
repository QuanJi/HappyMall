<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25 0025
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
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
    <title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
    <img class="avatar size-XL l" src="static/h-ui/images/ucnter/avatar-default.jpg">
    <dl style="margin-left:80px; color:#fff">
        <dt>
            <span class="f-18">张三</span>
            <span class="pl-10 f-12">余额：40</span>
        </dt>
        <dd class="pt-10 f-12" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
    </dl>
</div>
<div class="pd-20">
    <table class="table">
        <tbody>
        <c:forEach items="${goods}" var="goods" varStatus="index">
            <tr class="text-c">
                <td><input type="checkbox" value="${goods.id}" name="deleteID"></td>
                <td>${goods.id}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.goodsClassify}</td>
                <td>${goods.goodsPrice}</td>
                <td>${goods.storeName}</td>
                <td>${goods.goodsImage}</td>
                <td>${detail[index.index].number}</td>


            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<script type="text/javascript">

</script>
<!--请在下方写此页面业务相关的脚本-->
</body>
</html>