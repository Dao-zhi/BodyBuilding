package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.CourseDao;
import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DelTeachServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("teachId");
        /*System.out.println(id);*/
        TeachDao teachDao = Factory.getTeachDao();
        boolean delState = teachDao.del(id);
        CourseDao courseDao = Factory.getCourseDao();
        String courseId = courseDao.queryByTid(id);
        courseDao.del(courseId);
        List<Teach> teachList = new ArrayList<>();
        teachList = teachDao.teachList();
        req.setAttribute("teachList", teachList);
        req.setAttribute("state2",true);
        req.setAttribute("delState",delState);
        req.setAttribute("state1",false);
        req.getRequestDispatcher("/admin/teachTable.jsp").forward(req,resp);
    }
}
