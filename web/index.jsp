﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=320,maximum-scale=1.3,user-scalable=no">
    <c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
    <title>健身房管理系统</title>
    <style>
        html, body {
            height: 100%;
        }

        body {
            font: 12px 'Lucida Sans Unicode', 'Trebuchet MS', Arial, Helvetica;
            margin: 0;
            background-color: #d9dee2;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#ebeef2), to(#d9dee2));
            background-image: -webkit-linear-gradient(top, #ebeef2, #d9dee2);
            background-image: -moz-linear-gradient(top, #ebeef2, #d9dee2);
            background-image: -ms-linear-gradient(top, #ebeef2, #d9dee2);
            background-image: -o-linear-gradient(top, #ebeef2, #d9dee2);
            background-image: linear-gradient(top, #ebeef2, #d9dee2);
            background-image: url('assets/img/index/back-image.jpg');
        }

        #login {
            background-color: #fff;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#eee));
            background-image: -webkit-linear-gradient(top, #fff, #eee);
            background-image: -moz-linear-gradient(top, #fff, #eee);
            background-image: -ms-linear-gradient(top, #fff, #eee);
            background-image: -o-linear-gradient(top, #fff, #eee);
            background-image: linear-gradient(top, #fff, #eee);
            height: 260px;
            width: 400px;
            margin: -150px 0 0 -230px;
            padding: 30px;
            position: absolute;
            top: 40%;
            left: 50%;
            z-index: 0;
            -moz-border-radius: 3px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 0 2px rgba(0, 0, 0, 0.2),
            0 1px 1px rgba(0, 0, 0, .2),
            0 3px 0 #fff,
            0 4px 0 rgba(0, 0, 0, .2),
            0 6px 0 #fff,
            0 7px 0 rgba(0, 0, 0, .2);
            -moz-box-shadow: 0 0 2px rgba(0, 0, 0, 0.2),
            1px 1px 0 rgba(0, 0, 0, .1),
            3px 3px 0 rgba(255, 255, 255, 1),
            4px 4px 0 rgba(0, 0, 0, .1),
            6px 6px 0 rgba(255, 255, 255, 1),
            7px 7px 0 rgba(0, 0, 0, .1);
            box-shadow: 0 0 2px rgba(0, 0, 0, 0.2),
            0 1px 1px rgba(0, 0, 0, .2),
            0 3px 0 #fff,
            0 4px 0 rgba(0, 0, 0, .2),
            0 6px 0 #fff,
            0 7px 0 rgba(0, 0, 0, .2);
        }

        #login:before {
            content: '';
            position: absolute;
            z-index: -1;
            border: 1px dashed #ccc;
            top: 5px;
            bottom: 5px;
            left: 5px;
            right: 5px;
            -moz-box-shadow: 0 0 0 1px #fff;
            -webkit-box-shadow: 0 0 0 1px #fff;
            box-shadow: 0 0 0 1px #fff;
        }

        h1 {
            text-shadow: 0 1px 0 rgba(255, 255, 255, .7), 0px 2px 0 rgba(0, 0, 0, .5);
            text-transform: uppercase;
            text-align: center;
            color: #666;
            margin: 0 0 30px 0;
            letter-spacing: 4px;
            font: normal 26px/1 Verdana, Helvetica;
            position: relative;
        }

        h1:after, h1:before {
            background-color: #777;
            content: "";
            height: 1px;
            position: absolute;
            top: 15px;
            width: 120px;
        }

        h1:after {
            background-image: -webkit-gradient(linear, left top, right top, from(#777), to(#fff));
            background-image: -webkit-linear-gradient(left, #777, #fff);
            background-image: -moz-linear-gradient(left, #777, #fff);
            background-image: -ms-linear-gradient(left, #777, #fff);
            background-image: -o-linear-gradient(left, #777, #fff);
            background-image: linear-gradient(left, #777, #fff);
            right: 0;
        }

        h1:before {
            background-image: -webkit-gradient(linear, right top, left top, from(#777), to(#fff));
            background-image: -webkit-linear-gradient(right, #777, #fff);
            background-image: -moz-linear-gradient(right, #777, #fff);
            background-image: -ms-linear-gradient(right, #777, #fff);
            background-image: -o-linear-gradient(right, #777, #fff);
            background-image: linear-gradient(right, #777, #fff);
            left: 0;
        }

        fieldset {
            border: 0;
            padding: 0;
            margin: 0;
        }

        #name {
            background: #f1f1f1 url(/assets/img/index/login-sprite.png) left 5px top -3px no-repeat;
            padding: 15px 15px 15px 30px;
            margin: 0 0 10px 0;
            width: 353px; /* 353 + 2 + 45 = 400 */
            border: 1px solid #ccc;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            -moz-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
            -webkit-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
            box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
        }

        #pwd {
            background: #f1f1f1 url(/assets/img/index/login-sprite.png) left 5px bottom -3px no-repeat;
            padding: 15px 15px 15px 30px;
            margin: 0 0 10px 0;
            width: 353px; /* 353 + 2 + 45 = 400 */
            border: 1px solid #ccc;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            -moz-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
            -webkit-box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
            box-shadow: 0 1px 1px #ccc inset, 0 1px 0 #fff;
        }

        select {
            width: 100%;
            height: 34px;
            padding: 6px 12px;
            font-size: 14px;
            line-height: 1.42857143;
            color: #555;
            background-color: #fff;
            background-image: none;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-left: 70px;
        }

        #username {
            background-position: 5px -2px !important;
        }

        #password {
            background-position: 5px -52px !important;
        }

        #inputs input:focus {
            background-color: #fff;
            border-color: #e8c291;
            outline: none;
            -moz-box-shadow: 0 0 0 1px #e8c291 inset;
            -webkit-box-shadow: 0 0 0 1px #e8c291 inset;
            box-shadow: 0 0 0 1px #e8c291 inset;
        }

        #actions {
            margin: 10px 0 0 0;
            margin-left: 140px;
        }

        #submit_button {
            background-color: #ffb94b;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#fddb6f), to(#ffb94b));
            background-image: -webkit-linear-gradient(top, #fddb6f, #ffb94b);
            background-image: -moz-linear-gradient(top, #fddb6f, #ffb94b);
            background-image: -ms-linear-gradient(top, #fddb6f, #ffb94b);
            background-image: -o-linear-gradient(top, #fddb6f, #ffb94b);
            background-image: linear-gradient(top, #fddb6f, #ffb94b);
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
            -moz-box-shadow: 0 0 1px rgba(0, 0, 0, 0.3), 0 1px 0 rgba(255, 255, 255, 0.3) inset;
            -webkit-box-shadow: 0 0 1px rgba(0, 0, 0, 0.3), 0 1px 0 rgba(255, 255, 255, 0.3) inset;
            box-shadow: 0 0 1px rgba(0, 0, 0, 0.3), 0 1px 0 rgba(255, 255, 255, 0.3) inset;
            border-width: 1px;
            border-style: solid;
            border-color: #d69e31 #e3a037 #d5982d #e3a037;
            float: left;
            height: 35px;
            padding: 0;
            width: 120px;
            cursor: pointer;
            font: bold 15px Arial, Helvetica;
            color: #8f5a0a;
        }

        #submit:hover, #submit:focus {
            background-color: #fddb6f;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#ffb94b), to(#fddb6f));
            background-image: -webkit-linear-gradient(top, #ffb94b, #fddb6f);
            background-image: -moz-linear-gradient(top, #ffb94b, #fddb6f);
            background-image: -ms-linear-gradient(top, #ffb94b, #fddb6f);
            background-image: -o-linear-gradient(top, #ffb94b, #fddb6f);
            background-image: linear-gradient(top, #ffb94b, #fddb6f);
        }

        #submit:active {
            outline: none;
            -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
            -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5) inset;
        }

        #submit::-moz-focus-inner {
            border: none;
        }

        #actions a {
            color: #3151A2;
            float: right;
            line-height: 35px;
            margin-left: 10px;
        }

        /*--------------------*/
        #back {
            display: block;
            text-align: center;
            position: relative;
            top: 60px;
            color: #999;
        }
    </style>
    <script>
        function logout() {
            var state =
            <%=request.getAttribute("state")%>
            var delState =
            <%=request.getAttribute("delState")%>
            if(delState){
                if (state) {
                    layer.msg('注销成功!', {icon: 1, time: 2000});
                }
                else {
                    layer.msg('注销失败!请重试！', {icon: 2, time: 2000});
                }
            }
        }
    </script>

</head>
<body onload="logout()">
<form  id="login" action="/LoginServlet" method="post">
    <h1>健身房管理系统</h1>

    <h1>LogIn</h1>

    <fieldset id="inputs">

        <input id="name" type="text" placeholder="用户名" autofocus name="id">
        <input id="pwd" type="password" placeholder="密码" name="password">

    </fieldset>

    <fieldset id="actions">
        <input type="button" id="submit_button" value="登录" onclick="sub()">
    </fieldset>
</form>

<script src="${domain}/js/jquery-3.2.1.js"></script>
<script src="${domain}/js/layer.js"></script>

<script type="text/javascript">
    function sub() {
        var name = document.getElementById("name").value;
        var pwd = document.getElementById("pwd").value;
        /*var type = document.getElementById("type").value;*/
        if (name == "") {
            layer.msg('请输入用户名!', {icon: 2, time: 2000});
            return false;
        }
        if (pwd == "") {
            layer.msg('请输入密码!', {icon: 2, time: 2000});
            return false;
        }
        if(pwd != "" && name != ""){
            document.getElementById("login").submit();
            return true;
        }
        /*$.post("/LoginServlet", {
            'id': name,
            'password': pwd
        })*/

        /*if(type==""){
            layer.msg('请选择一个身份!',{icon:2,time:2000});
            return false;
        }
         {
            $.post("/LoginServlet", {
                'id': name,
                'password': pwd
            }, function (data) {
                if (data == "true") {
                    layer.msg('登录成功!', {icon: 1, time: 1000});
                    setTimeout(function () {
                        window.location.href = 'user/Forward';
                    }, 1000)
                }
                if (data == "false") {
                    layer.msg('用户名或密码错误，请重试!', {icon: 2, time: 2000});
                    setTimeout(function () {
                        location.reload();
                    }, 2000)
                }
            })
        }
        if (type == 0) {
            $.post("sys/loginAdmin", {
                'name': name,
                'pwd': pwd
            }, function (data) {
                if (data == "true") {
                    layer.msg('登录成功!', {icon: 1, time: 1000});
                    setTimeout(function () {
                        window.location.href = 'sys/ForwardAdmin';
                    }, 1000)
                }
                if (data == "false") {
                    layer.msg('用户名或密码错误，请重试!', {icon: 2, time: 2000});
                    setTimeout(function () {
                        location.reload();
                    }, 2000)
                }
            })
        }*/
    }

</script>


<div style="clear:both"></div>
<br><br>
<div style="text-align:center">

    <br><br>

</div>
</body>
</html>
