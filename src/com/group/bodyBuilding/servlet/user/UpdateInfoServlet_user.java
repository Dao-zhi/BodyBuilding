package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class UpdateInfoServlet_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            /*System.out.println(id);*/
        }
        //String id = req.getParameter("account");
        UserDao userDao = Factory.getUserDao();
        int time = userDao.queryById(id).getTime();
        int account = userDao.queryById(id).getAccount();
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        int age  = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String  tel = req.getParameter("tel");
        String address = req.getParameter("address");
        boolean flag1 = false;
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
        user.setTime(time);
        user.setAccount(account);
        user.setAddress(address);
        user.setTime(0);
        flag1 = userDao.update(user);
        System.out.println(flag1);
        req.setAttribute("flag1",flag1);
        req.setAttribute("state",1);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/user/user.jsp").forward(req,resp);
    }
}
