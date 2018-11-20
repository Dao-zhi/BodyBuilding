package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.AuthorityDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Authority;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CancelCardServlet_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("uId");
        /*System.out.println(id);*/
        UserDao userDao = Factory.getUserDao();
        AuthorityDao authorityDao = Factory.getAuthorityDao();
        authorityDao.del(id);
        boolean delState = userDao.del(id);
        req.setAttribute("state",true);
        req.setAttribute("delState",delState);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
