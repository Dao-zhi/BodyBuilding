package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet_admin extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("account");
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        int age  = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String  tel = req.getParameter("tel");
        String address = req.getParameter("address");
        boolean flag = false;
        User user = new User();
        user.setuId(id);
        user.setName(name);
        user.setPassword(password);
        user.setAccount(1);
        user.setAge(age);
        if(sex.equals("男")){
            user.setSex(1);
        }
        else {
            user.setSex(0);
        }
        user.setTel(tel);
        user.setAddress(address);
        user.setTime(0);
        UserDao userDao = Factory.getUserDao();
        flag = userDao.add(user);
        req.setAttribute("state2",false);
        req.setAttribute("state1",false);
        req.setAttribute("flag",flag);
        req.setAttribute("state",1);
        req.getRequestDispatcher("/admin/addUser.jsp").forward(req,resp);
    }
}
