package com.group.bodyBuilding.servlet.admin;

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

public class ResetTeachPwdServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        System.out.println(id);
        TeachDao teachDao = Factory.getTeachDao();
        boolean resState = teachDao.resetPassword(id);
        List<Teach> teachList = new ArrayList<>();
        teachList = teachDao.teachList();
        req.setAttribute("teachList", teachList);
        req.setAttribute("state1",true);
        req.setAttribute("resState",resState);
        req.setAttribute("state2",false);
        req.getRequestDispatcher("/admin/teachTable.jsp").forward(req,resp);
    }
}
