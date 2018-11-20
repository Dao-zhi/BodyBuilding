package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Teach;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeachListServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeachDao teachDao = Factory.getTeachDao();
        List<Teach> teachList = new ArrayList<>();
        teachList = teachDao.teachList();
        req.setAttribute("teachList", teachList);
        req.getRequestDispatcher("/admin/teachTable.jsp").forward(req,resp);
    }
}
