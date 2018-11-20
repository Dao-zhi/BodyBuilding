package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.WardrobeDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Wardrobe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddWardrobeServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setId(id);
        wardrobe.setState("0");
        boolean flag = wardrobeDao.add(wardrobe);
        req.setAttribute("flag",flag);
        req.setAttribute("state",1);
        req.getRequestDispatcher("/staff/addWardrobe.jsp").forward(req,resp);
    }
}
