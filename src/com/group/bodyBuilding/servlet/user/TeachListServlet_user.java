package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Course;
import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeachListServlet_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String id = (String) req.getAttribute("course_id");*/
        TeachDao teachDao = Factory.getTeachDao();
        List<Teach> teachList = new ArrayList<>();
        /*if(id.equals(null)){
            id = "1";
        }*/
        teachList = teachDao.teachList();
        /*for(int i=0;i<teachList.size();i++){
            System.out.println(teachList.get(i).gettId());
        }*/
        req.setAttribute("teachList", teachList);
        req.getRequestDispatcher("/user/teachList.jsp").forward(req,resp);
    }
}
