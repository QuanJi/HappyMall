<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/16 0016
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<input type="button"  id="button11"  value="sss"/>
<a href="/cart/cart.action">111</a>
<a href="/cart/cart1.action">222</a>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../layui-v2.4.5/layui/layui.js"></script>

<script type="text/javascript">

    layui.use('layer',function () {
        $("#button11").click(function () {
            layer.msg("test");
        })
    })

</script>
</body>
</html>
