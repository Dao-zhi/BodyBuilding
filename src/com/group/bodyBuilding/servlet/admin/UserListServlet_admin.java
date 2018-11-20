package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.AdminDao;
import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.FaultAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class UserListServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*int flag = Integer.parseInt(req.getParameter("flag"));
        System.out.println(flag);*/
        /*if(flag == 0)*/
        UserDao userDao = Factory.getUserDao();

        List<User> userList = new ArrayList<>();
        userList = userDao.userList();

        req.setAttribute("userList", userList);
            /*for(int i = 0;i<userList.size();i++){
                System.out.println(userList.get(i).getuId());
            }*/
        req.getRequestDispatcher("/admin/userTable.jsp").forward(req,resp);
    }
}
