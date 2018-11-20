package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.dao.WardrobeDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardCancelServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uId = req.getParameter("uId");
       /* System.out.println(wardrobeId);
        System.out.println(uId);*/
        UserDao userDao = Factory.getUserDao();
        boolean state = userDao.del(uId);
        List<User> userList = new ArrayList<>();
        userList = userDao.userList();
        req.setAttribute("userList",userList);
        req.setAttribute("state2",false);
        req.setAttribute("state1",true);
        req.setAttribute("state",state);
        req.getRequestDispatcher("/staff/cardManage.jsp").forward(req,resp);
    }
}
