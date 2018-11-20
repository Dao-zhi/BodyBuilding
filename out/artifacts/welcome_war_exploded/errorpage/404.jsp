<%@ page import="static com.group.bodyBuilding.ReadCookie.ReadCookieMap" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    
<!DOCTYPE HTML>
<%--<%
    Map<String, Cookie> cookieMap = ReadCookieMap(request);
    String id=null;
    if (cookieMap.containsKey("cookie_id")) {
    }
    else {
        response.sendRedirect("/index.jsp");
    }
%>--%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>404错误页面</title>
<style type="text/css">
body{
	font-family:Arial, Helvetica, sans-serif;
}
.wrap{
	width:1000px;
	margin:0 auto;
}
.logo{
	width:430px;
	position:absolute;
	top:25%;
	left:35%;
}
p a{
	color:#eee;
	font-size:13px;
	margin-left:30px;
	padding:5px;
	background:#FF3366;
	text-decoration:none;
	-webkit-border-radius:.3em;
	   -moz-border-radius:.3em;
	        border-radius:.3em;
}
p a:hover{
	color: #fff;
}
.footer{
	position:absolute;
	bottom:10px;
	right:10px;
	font-size:12px;
	color:#aaa;
}
.footer a{
	color:#666;
	text-decoration:none;
}

</style>
</head>
<body>
<div class="wrap">
    <div class="logo">
        <img src="<%=basePath%>errorpage/images/404.png" alt=""  />
        <p><a href="index.jsp">返回首页</a></p>
    </div>
</div>


</body>
</html>
