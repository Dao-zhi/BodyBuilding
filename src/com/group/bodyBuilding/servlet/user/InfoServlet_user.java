package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.CourseDao;
import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class InfoServlet_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            //System.out.println(id);
        }
        CourseDao courseDao = Factory.getCourseDao();
        String courseName = courseDao.queryByUid(id);
        TeachDao teachDao = Factory.getTeachDao();
        Teach teach = new Teach();
        teach = teachDao.queryByUid(id);
        UserDao userDao = Factory.getUserDao();
        User user = new User();
        user = userDao.queryById(id);
        req.setAttribute("user", user);
        req.setAttribute("courseName", courseName);
        req.setAttribute("teach", teach);
        req.getRequestDispatcher("/user/user.jsp").forward(req,resp);
    }
}
