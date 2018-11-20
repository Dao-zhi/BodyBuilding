<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="static com.group.bodyBuilding.ReadCookie.ReadCookieMap" %>

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
    <meta charset="utf-8"/>
    <c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
    <link rel="apple-touch-icon" sizes="76x76" href="${domain}/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${domain}/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>信息总览</title>

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
    <link href="${domain}/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="${domain}/assets/css/themify-icons.css" rel="stylesheet">

    <script language="javascript" for="window" event="onload">
        function MakeForm() {
            <%--<%
                boolean flag = (request.getAttribute("userList") == null);
                System.out.println(flag);
            %>--%>
            var flag =
            <%=(request.getAttribute("userCount") == null)%>
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
                form1.action = "/InfoServlet_admin";
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
                <li class="active">
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
                <li>
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
                    <a class="navbar-brand" href="#">信息总览</a>
                </div>
                <div class="collapse navbar-collapse">

                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-warning text-center">
                                            <i class="ti-server"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>学员总数</p>
                                            <%=request.getAttribute("userCount")%>人
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr/>
                                    <div class="stats">
                                        <a href="/admin/admin.jsp"> <i class="ti-reload"></i> Updated now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-danger text-center">
                                            <i class="ti-user"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>教练总数</p>
                                            <%=request.getAttribute("teachCount")%>人
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr/>
                                    <div class="stats">
                                        <a href="/admin/admin.jsp"> <i class="ti-reload"></i> Updated now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-danger text-center">
                                            <i class="ti-cup"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>器材总数</p>
                                            <%=request.getAttribute("apparatusCount")%>个
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr/>
                                    <div class="stats">
                                        <a href="/admin/admin.jsp"> <i class="ti-reload"></i> Updated now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-success text-center">
                                            <i class="ti-wallet"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers" style="font-size: 1.5em">
                                            <%=request.getAttribute("lastLoginTime")%>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr/>
                                    <div class="stats">
                                        <i class="ti-calendar"></i> 上次登录时间
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">男女人数比例</h4>
                                <hr>
                            </div>
                            <div class="content">
                                <div class="panel-body" id="sex" style="height: 300px;"></div>
                            </div>
                            <div class="footer">

                                <hr>
                                <div class="stats">
                                    &nbsp;&nbsp;<a href="/admin/admin.jsp"> <i class="ti-reload"></i> Updated now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <div class="copyright ">
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
<script src="${domain}/js/echarts.js"></script>
<script type="text/javascript">
    //性别统计
    var myChart = echarts.init(document.getElementById('sex')); //渲染组件
    myChart.showLoading({ //加载动画
        text: '正在加载数据。。。。'
    });
    var names2 = []; //类别数组（实际用来盛放X轴坐标值）
    var nums2 = []; //销量数组（实际用来盛放Y坐标值）
    names2[0] = '男';
    names2[1] = '女';
    nums2[0] = <%=request.getAttribute("maleCount")%>;
    nums2[1] = <%=request.getAttribute("femaleCount")%>;
    myChart.hideLoading(); //隐藏动画
    var option = {

        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [{
            name: '性别比例',
            type: 'pie',
            radius: '80%',
            center: ['50%', '50%'],
            data: [{
                name: '男',
                value: nums2[0]
            }, {
                name: '女',
                value: nums2[1]
            }],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    myChart.setOption(option); //绑定数据
    var myChart = echarts.init(document.getElementById('sex')); //渲染组件
    myChart.showLoading({ //加载动画
        text: '正在加载数据。。。。'
    });
    var names2 = []; //类别数组（实际用来盛放X轴坐标值）
    var nums2 = []; //销量数组（实际用来盛放Y坐标值）
    names2[0] = '男';
    names2[1] = '女';
    nums2[0] = <%=request.getAttribute("maleCount")%>;
    nums2[1] = <%=request.getAttribute("femaleCount")%>;
    myChart.hideLoading(); //隐藏动画
    var option = {

        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [{
            name: '性别比例',
            type: 'pie',
            radius: '80%',
            center: ['50%', '50%'],
            data: [{
                name: '男',
                value: nums2[0]
            }, {
                name: '女',
                value: nums2[1]
            }],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };
    myChart.setOption(option); //绑定数据
    //加载数据
    /*jQuery.ajax({
        url : "getSex",
        type : 'get',
        datatype : 'json',
        async : true,
        success : function(jsons) {
            if (jsons) {
                myChart.hideLoading(); //隐藏动画
                $.each(jsons, function(i, value) {
                    //alert(jsons[index].price);
                    names2[i] = value['sex'];
                    nums2[i] = value['num'];
                    var option = {

                        tooltip : {
                            trigger : 'item',
                            formatter : "{a} <br/>{b} : {c} ({d}%)"
                        },
                        series : [ {
                            name : '性别比例',
                            type : 'pie',
                            radius : '55%',
                            center : [ '50%', '60%' ],
                            data : [ {
                                name : '男',
                                value : nums2[1]
                            }, {
                                name : '女',
                                value : nums2[0]
                            } ],
                            itemStyle : {
                                emphasis : {
                                    shadowBlur : 10,
                                    shadowOffsetX : 0,
                                    shadowColor : 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        } ]
                    };
                    myChart.setOption(option); //绑定数据
                });
            }
        },
        /!*error : function() {
            alert("数据加载失败！请检查数据链接是否正确");
        }*!/
    });
    // 初次加载图表(无数据)
    myChart.setOption(option);*/
</script>


</html>
