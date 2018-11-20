package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.CourseDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Course;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseList_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDao courseDao = Factory.getCourseDao();
        List<Course> courseList = new ArrayList<>();
        courseList = courseDao.courseList();
        req.setAttribute("courseList", courseList);
        req.getRequestDispatcher("/user/classTable.jsp").forward(req,resp);
    }
}
