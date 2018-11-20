<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.group.bodyBuilding.vo.Apparatus" %>
<%@ page import="static com.group.bodyBuilding.ReadCookie.ReadCookieMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%--<%
             if(session.getAttribute("account") == null) {      
   %>    
          <script type="text/javascript" language="javascript">        
            alert("您还没有登录，请登录...");   
           top.location.href="../../../../../项目/Bodybuilding/Bodybuilding/WebRoot/WEB-INF/jsp/index.jsp";
           </script>   
   <%    
       }    
   %> --%>
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
	<meta charset="utf-8" />
	<c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
	<link rel="apple-touch-icon" sizes="76x76" href="${domain}/${domain}/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${domain}/${domain}/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>器材管理</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${domain}/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${domain}/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${domain}/assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${domain}/assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${domain}/assets/css/themify-icons.css" rel="stylesheet">

    <script language="javascript" for="window" event="onload">
        function MakeForm() {
            var state =
            <%=request.getAttribute("state")%>
            var delState =
            <%=request.getAttribute("delState") != null%>
            if(state){
                if (delState) {
                    layer.msg('删除成功!', {icon: 1, time: 2000});
                }
                else {
                    layer.msg('删除失败!', {icon: 2, time: 2000});
                }
            }
            <%--<%
                boolean flag = (request.getAttribute("userList") == null);
                System.out.println(flag);
            %>--%>
            var flag =
            <%=(request.getAttribute("apparatusList") == null)%>
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
                form1.action = "/ApparatusListServlet_admin";
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
                    <a href="/admin/admin.jsp">
                        <i class="ti-panel"></i>
                        <p>信息总览</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/userTable.jsp">
                        <i class="ti-user"></i>
                        <p>会员列表</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/teachTable.jsp">
                        <i class="ti-user"></i>
                        <p>教练列表</p>
                    </a>
                </li>
                <li class="active">
                    <a href="/admin/apparatusTable.jsp">
                        <i class="ti-text"></i>
                        <p>器材管理</p>
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
                    <a class="navbar-brand" href="#">器材管理</a>
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
                                <p class="category">请选择你要进行的操作</p>
                                <h4 class="title"><button class="btn btn-info btn-fill " onclick="add()">增加</button></h4>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                        <th>器材编号</th>
                                    	<th>器材名称</th>
                                    	<th>状态</th>
                                    	<th>操作</th>
                                    </thead>
                                    <tbody>
                                    <%
                                        if (request.getAttribute("apparatusList") != null) {
                                            List<Apparatus> apparatusList = (List<Apparatus>) request.getAttribute("apparatusList");
                                            for (int i = 0, len = apparatusList.size(); i < len; i++) {
                                    %>
                                        <tr>
                                        	<td><%=apparatusList.get(i).getAppId()%></td>
                                        	<td><%=apparatusList.get(i).getaName()%></td>
                                        	<td>
                                                <%
                                                    String state = null;
                                                    if (apparatusList.get(i).getaState() == 1) {
                                                        state = "损坏";
                                                    } else {
                                                        state = "完好";
                                                    }
                                                %>
                                                <%=state%>
											</td>
                                        	<td>
                                        	
                                        	<button class="btn btn-danger btn-fill " onclick="del(<%=apparatusList.get(i).getAppId()%>)">删除</button>
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
                    Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="javascript:">Daozhi</a>
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
<script type="text/javascript">
function add(){
	parent.layer.open({
    type: 2,
    shadeClose: true,
    shade: 0.8,
    area: ['450px', '35%'],
    content: '/admin/addApp.jsp',
    end: function () {
       location.reload();
    }
});
}
function del(id){
    layer.confirm('确认要删除该器材吗？', function (index) {
        var form1 = document.createElement("form");
        form1.id = "form1";
        form1.name = "form1";
        // 添加到 body 中
        document.body.appendChild(form1);
        // 创建一个输入
        var input = document.createElement("input");
        // 设置相应参数
        input.type = "text";
        input.name = "apparatusId";
        input.value = id;
        // 将该输入框插入到 form 中
        form1.appendChild(input);
        //form 的提交方式
        form1.method = "POST";
        // form 提交路径
        form1.action = "/DelApparatusServlet_admin";
        // 对该 form 执行提交
        form1.submit();
        // 删除该 form
        document.body.removeChild(form1);
        return true;
        /*$.ajax({
            type: 'get',
            url: 'delUser',
            data: {id: id},
            success: function (data) {
                layer.msg('删除成功!', {icon: 1, time: 2000});
                setTimeout(function () {
                    window.location.href = 'userTable';
                }, 2000)
            },
            error: function (data) {
                console.log(data.msg);
            },
        });*/
    });
}

</script>

</html>
