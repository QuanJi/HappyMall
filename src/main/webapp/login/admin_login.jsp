<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/9 0009
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link href="../static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="../static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="../static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
    <link href="../lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />

    <title>后台登录 - HappyMall -</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" action="/admin.action"  name="submit" method="post">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input  id="admin" name="username" type="text" required="required" placeholder="账户" class="input-text size-L" ><br><font id="username" color="#a52a2a">${errorAdmin}</font>
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password"  name="password" type="password" required="required" placeholder="密码" class="input-text size-L"><br><font  color="#a52a2a">${errorPassword}</font>
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input id="validator" name="validator" class="input-text size-L" type="text" placeholder="验证码"  required="required" style="width:150px;">
                   <img id="validatorImage" style="width: 80px;height: 43px" src="/validatorCode.action"> <a id="kanbuq" onclick="validatorCode()">看不清，换一张</a><br>
                    <font id="validatorError" color="#a52a2a">${validatorError}</font>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <label for="online">
                        <input type="checkbox" name="online" id="online" >
                        記住密碼</label>
                    <input type="text" style="display: none" name="remember" id="remember">
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input id="login"  type="button" onclick="loginButton()" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    <a id="register" href="/register.action" class="btn btn-default radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp</a>
                </div>
            </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">HappyMall</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
    function loginButton(){
        if($("input[type=checkbox]").prop("checked")){
            $("#remember").val("1");
           $("form[name=submit]").submit();
        }
       else{
            $("#remember").val("0")
            $("form[name=submit]").submit();

        }
    }
function validatorCode() {
    var time=new Date();
    $("#validatorImage").attr("src","/validatorCode.action?time="+time);
}
$(document).ready(function () {

    var admin=document.cookie;
    var cookie=admin.split(";");
    for(var i=0;i<cookie.length;i++) {
        var array=cookie[i].split("=");
       if(array[0].indexOf("admin")!=-1){
           $("#admin").val(array[1]);
       }
       if(array[0].indexOf("password")!=-1) {
           $("#password").val(array[1]);
           $("input[type=checkbox]").prop("checked",true);
       }

    }


})

</script>
</body>
</html>
