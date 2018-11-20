package com.group.bodyBuilding.servlet;

import com.group.bodyBuilding.dao.*;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        //System.out.print(id+"+"+password);
        Authority authority = new Authority();
        AuthorityDao authorityDao = Factory.getAuthorityDao();
        int role = authorityDao.queryById(id);
        //查询成功说明账户存在，下一步进行密码验证
        //System.out.println(role);
        if(role>0){
            switch (role){
                //管理员
                case 1:
                    Admin admin = new Admin();
                    AdminDao adminDao = Factory.getAdminDao();
                    admin = adminDao.queryById(id);
                    if(admin.getPassword().equals(password)){
                        Cookie cookie_id = new Cookie("cookie_id", admin.getId());
                        resp.addCookie(cookie_id);
                        resp.sendRedirect("/admin/admin.jsp");
                        //System.out.println("登录成功！");
                    }
                    else {
                        resp.sendRedirect("/passwordError.html");
                    }
                    break;
                //员工
                case 2:
                    Staff staff = new Staff();
                    StaffDao staffDao = Factory.getStaffDao();
                    staff = staffDao.queryById(id);
                    if(staff.getPassword().equals(password)){
                        Cookie cookie_id = new Cookie("cookie_id", staff.getsId());
                        resp.addCookie(cookie_id);
                        resp.sendRedirect("/staff/staff.jsp");
                        //System.out.println("登录成功！");
                    }
                    else {
                        resp.sendRedirect("/passwordError.html");
                    }
                    break;
                //教练
                case 3:
                    Teach teach = new Teach();
                    TeachDao teachDao = Factory.getTeachDao();
                    teach = teachDao.queryById(id);
                    if(teach.getPassword().equals(password)){
                        Cookie cookie_id = new Cookie("cookie_id", teach.gettId());
                        resp.addCookie(cookie_id);
                        int salary = teachDao.calSalary(id);
                        req.setAttribute("salary", salary);//将lists放到作用域
                        req.getRequestDispatcher("/teach/teach.jsp").forward(req,resp);
                        //resp.sendRedirect("/teach/teach.jsp");
                        //System.out.println("登录成功！");
                    }
                    else {
                        resp.sendRedirect("/passwordError.html");
                    }
                    break;
                //学生
                case 4:
                    User user = new User();
                    UserDao userDao = Factory.getUserDao();
                    user = userDao.queryById(id);
                    if(user.getPassword().equals(password)){
                        Cookie cookie_id = new Cookie("cookie_id", user.getuId());
                        resp.addCookie(cookie_id);
                        resp.sendRedirect("/user/user.jsp");
                        //System.out.println("登录成功！");
                    }
                    else {
                        resp.sendRedirect("/passwordError.html");
                    }
                    break;
                default:
                    resp.sendRedirect("/passwordError.html");
                    break;
            }
        }
        //查询失败说明账户不存在，直接跳转错误页面
        else{
            //System.out.println("账户不存在！");
            resp.sendRedirect("accountError.html");
        }
    }
}
