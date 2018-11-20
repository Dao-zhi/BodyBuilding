<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.group.bodyBuilding.vo.User" %>
<%@ page import="static com.group.bodyBuilding.ReadCookie.ReadCookieMap" %>
<!doctype html>
<%
    Map<String, Cookie> cookieMap = ReadCookieMap(request);
    String id=null;
    if (cookieMap.containsKey("cookie_id")) {
    }
    else {
        response.sendRedirect("/index.jsp");
    }
%>
<html>
<head>
    <meta charset="utf-8"/>
    <c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
    <link rel="apple-touch-icon" sizes="76x76" href="${domain}/${domain}/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${domain}/${domain}/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>学员列表</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>


    <!-- Bootstrap core CSS     -->
    <link href="${domain}/assets/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link href="${domain}/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${domain}/assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${domain}/assets/css/demo.css" rel="stylesheet"/>

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${domain}/assets/css/themify-icons.css" rel="stylesheet">

    <%--本来想法是用JavaScript提交一个表单，向后台请求数据，但是用不了，嘤嘤嘤~~~--%>
    <script language="javascript" for="window" event="onload">
        function MakeForm() {
            <%--<%
                boolean flag = (request.getAttribute("userList") == null);
                System.out.println(flag);
            %>--%>
            var flag =
            <%=(request.getAttribute("userList") == null)%>
            if (flag) {
                // 创建一个 form
                var form1 = document.createElement("form");
                form1.id = "form1";
                form1.name = "form1";
                // 添加到 body 中
                document.body.appendChild(form1);
                // 创建一个输入
                var input = document.createElement("input");
                // 设置相应参数
                input.type = "text";
                input.name = "flag";
                input.value = 1;
                // 将该输入框插入到 form 中
                form1.appendChild(input);
                //form 的提交方式
                form1.method = "POST";
                // form 提交路径
                form1.action = "/UserListServlet_teach";
                // 对该 form 执行提交
                form1.submit();
                // 删除该 form
                document.body.removeChild(form1);
                return true;
            }
            else {
                return false;
            }
        };

    </script>

</head>
<body onload="MakeForm()">
<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    健身房管理系统
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="/teach/teach.jsp">
                        <i class="ti-panel"></i>
                        <p>工资查询</p>
                    </a>
                </li>
                <li class="active">
                    <a href="/teach/userList.jsp">
                        <i class="ti-user"></i>
                        <p>学员列表</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="/index.jsp">
                        <i class="ti-export"></i>
                        <p>退出</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">学员列表</a>
                </div>
                <div class="collapse navbar-collapse">

                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                    <th>编号</th>
                                    <th>会员等级</th>
                                    <th>会员姓名</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>联系方式</th>
                                    <th>住址</th>
                                    </thead>
                                    <tbody>
                                    <%
                                        if (request.getAttribute("userList") != null) {
                                            List<User> userList = (List<User>) request.getAttribute("userList");
                                            for (int i = 0, len = userList.size(); i < len; i++) {
                                    %>
                                    <tr>
                                        <td><%=userList.get(i).getuId()%>
                                        </td>
                                        <td><%=userList.get(i).getAccount()%>
                                        </td>
                                        <td><%=userList.get(i).getName()%>
                                        </td>
                                        <td>
                                            <%
                                                String sex = null;
                                                if (userList.get(i).getSex() == 0) {
                                                    sex = "女";
                                                } else {
                                                    sex = "男";
                                                }
                                            %>
                                            <%=sex%>
                                        </td>
                                        <td><%=userList.get(i).getAge()%>
                                        </td>
                                        <td><%=userList.get(i).getTel()%>
                                        </td>
                                        <td><%=userList.get(i).getAddress()%>
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="container-fluid">
                <div class="copyright">
                    Copyright &copy; 2018.Company name All rights reserved.<a target="_blank"
                                                                              href="javascript:">Daozhi</a>
                </div>
            </div>
        </footer>


    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="${domain}/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${domain}/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="${domain}/assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="${domain}/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="${domain}/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<!---<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--->

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="${domain}/assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="${domain}/assets/js/demo.js"></script>
<script src="${domain}/js/layer.js"></script>

</html>
