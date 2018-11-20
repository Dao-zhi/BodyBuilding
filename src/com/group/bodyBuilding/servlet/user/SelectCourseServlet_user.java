package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.CourseDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Course;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class SelectCourseServlet_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已运行！");
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            /*System.out.println(id);*/
        }
        String cId = req.getParameter("cId");
        CourseDao courseDao = Factory.getCourseDao();
        List<Course> courseList = courseDao.courseList();
        boolean state = courseDao.selectCourse(cId,id);
        req.setAttribute("courseList",courseList);
        req.setAttribute("state",state);
        req.setAttribute("selectState",true);
        req.getRequestDispatcher("/user/classTable.jsp").forward(req,resp);
    }
}
