<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/7 0007
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%><%@ page import="java.util.List" %>
<%@ page import="pojo.Goods" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
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
    <!--/meta 作为公共模版分离出去-->

    <title>商品添加</title>
</head>
<body>
<article class="page-container">
    <form action="article-update.action" method="post" class="form form-horizontal" id="form-article-add" enctype="multipart/form-data" >
        <input name="id" value="${goods.id}" style="display: none"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${goods.goodsName}" required="required" placeholder="请输入商品名称" id="articletitle" name="goodsName">
            </div>
        </div>
        <!--<div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">商品分类：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="articletitle2" name="articletitle2">
            </div>
        </div>-->
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类栏目：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="goodsClassify" class="select">
                     <option value="${goods.goodsClassify}">${goods.goodsClassify}</option>
                    <c:forEach items="${column}" var="item">
                        <c:if test="${item.sonColumn!=goods.goodsClassify}">
                        <option value="${item.sonColumn}">${item.sonColumn}</option>
                        </c:if>
                    </c:forEach>

				</select>
				</span> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">商品价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  onkeypress="keyPress(this)" onkeyup="keyUp(this)" onblur="onBlur(this)" value="${goods.goodsPrice}" required="required"  id="articlesort" name="goodsPrice">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">商品描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="goodsDescribe" required="required"  cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onkeyup="calculate()">${goods.goodsDescribe}</textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">店铺名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" value="${goods.storeName}" class="input-text"  required="required" placeholder="输入店铺名称" id="author" name="storeName"/>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">选择图片：</label>
            <input type="file" name="image" required="required" >
        </div>
        <!--<div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">文章内容：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <script id="editor" type="text/plain" style="width:100%;height:400px;"></script>
            </div>
        </div>-->
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input  type="submit" class="btn btn-primary radius"  value="更改" />
                <!--<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>-->
                <button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    var em=$(".textarea-length");
   em.html($(".textarea").val().length );
});

    function calculate() {

        var textArea=$(".textarea");
        var em=document.querySelector('.textarea-length');
        if(textArea.val().length<=200){
            em.innerHTML=textArea.val().length;
        }
        else {
            textArea.val(textArea.val().substring(0,200));
            setTimeout(function () {
                alert("达到字符限制！")
            },1000)
        }
    }
function keyPress(ob) {
    if (!ob.value.match(/^[\+\-]?\d*?\.?\d*?$/)) ob.value = ob.t_value; else ob.t_value = ob.value; if (ob.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/)) ob.o_value = ob.value;
}
function keyUp(ob) {
    if (!ob.value.match(/^[\+\-]?\d*?\.?\d*?$/)) ob.value = ob.t_value; else ob.t_value = ob.value; if (ob.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/)) ob.o_value = ob.value;
}
function onBlur(ob) {
    if(!ob.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))ob.value=ob.o_value;else{if(ob.value.match(/^\.\d+$/))ob.value=0+ob.value;if(ob.value.match(/^\.$/))ob.value=0;ob.o_value=ob.value};
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
