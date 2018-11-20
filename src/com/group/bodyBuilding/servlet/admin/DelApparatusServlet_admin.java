package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.ApparatusDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Apparatus;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DelApparatusServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("apparatusId");
        /*System.out.println(id);*/
        ApparatusDao apparatusDao = Factory.getApparatusDao();
        boolean delState = apparatusDao.del(id);
        List<Apparatus> apparatusList = new ArrayList<>();
        apparatusList = apparatusDao.apparatusList();
        req.setAttribute("apparatusList", apparatusList);
        req.setAttribute("state",true);
        req.setAttribute("delState",delState);
        req.getRequestDispatcher("/admin/apparatusTable.jsp").forward(req,resp);
    }
}
