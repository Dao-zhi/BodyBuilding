package com.group.bodyBuilding.servlet.teach;

import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Teach;
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

public class QuerySalary extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println("已调用！");*/
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            /*System.out.println(id);*/
        }
        TeachDao teachDao = Factory.getTeachDao();
        int salary = teachDao.calSalary(id);
        req.setAttribute("salary", salary);//将lists放到作用域
        req.getRequestDispatcher("/teach/teach.jsp").forward(req,resp);
    }
}
