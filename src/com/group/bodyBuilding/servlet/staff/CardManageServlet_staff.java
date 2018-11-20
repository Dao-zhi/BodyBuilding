package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class CardManageServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*int flag = Integer.parseInt(req.getParameter("flag"));
        System.out.println(flag);*/
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            //System.out.println(id);
        }
        UserDao userDao = Factory.getUserDao();
        List<User> userList = new ArrayList<>();
        userList = userDao.userList();
        req.setAttribute("userList", userList);
            /*for(int i = 0;i<userList.size();i++){
                System.out.println(userList.get(i).getuId());
            }*/
        req.getRequestDispatcher("/staff/cardManage.jsp").forward(req,resp);
    }
}
