<%--
  Created by IntelliJ IDEA.
  User: daozhi
  Date: 2018/11/6
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: daozhi
  Date: 2018/11/6
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <meta charset="utf-8" />
    <c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
    <link rel="apple-touch-icon" sizes="76x76" href="${domain}/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${domain}/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title></title>

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
    <link href="${domain}/assets/css/themify-icons.css" rel="stylesheet">

    <script language="javascript" for="window" event="onload">
    function MakeForm() {
        var state =
        <%=request.getAttribute("state")%>
        var state1 =
        <%=request.getAttribute("state1")%>
        if (state1) {
            if (state) {
                layer.msg('借用成功!', {icon: 1, time: 2000});
            }
            else {
                layer.msg('借用失败!', {icon: 2, time: 2000});
            }
        }
    }

</script>

</head>
<body onload="MakeForm()">

<div class="wrapper">


    <div class="main-panel">



        <div class="content"><div style="padding-left: 20px;padding-right: 20px">
            <form action="/BorrowApparatusServlet_staff" method="post" name="borrow" id="borrow">
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label>会员编号</label>
                            <input type="text" class="form-control border-input" placeholder="Number"  id="uId" name="uId">
                        </div>
                    </div>
                </div>

                <%String appId=request.getParameter("appId");%>
                <input type="hidden" value="<%=appId%>" id="appId" name="appId">
                <div class="text-center">
                    <button type="button" class="btn btn-info btn-fill btn-wd" onclick="update()">借用器材</button>
                </div>
                <div class="clearfix"></div>
            </form></div>
        </div>
    </div>



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
    function update(){
        var name = document.getElementById("uId").value;
        if(name==""){
            layer.msg('请把信息填写完整!',{icon: 2,time:2000});
            return false;
        }
        document.getElementById("borrow").submit();
        return true;
       /* $.post("addAppInfo",{
            'aname' : name,
        },function(result){
            if(result == "true"){
                layer.msg('添加成功!',{icon: 1,time:2000});
            }
        })*/
    }
</script>
</html>
