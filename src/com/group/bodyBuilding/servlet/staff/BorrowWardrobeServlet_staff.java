package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.ApparatusDao;
import com.group.bodyBuilding.dao.WardrobeDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Apparatus;
import com.group.bodyBuilding.vo.Wardrobe;
import sun.security.timestamp.HttpTimestamper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BorrowWardrobeServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wardrobeId = req.getParameter("wardrobeId");
        String uId = req.getParameter("uId");
       /* System.out.println(wardrobeId);
        System.out.println(uId);*/
        WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        if(wardrobeDao.queryById(wardrobeId).getState().equals("0")){
            boolean state = wardrobeDao.changeState(uId,wardrobeId);
            req.setAttribute("state2",false);
            req.setAttribute("state1",true);
            req.setAttribute("state",state);
            req.getRequestDispatcher("/staff/borrowWardrobe.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("state",0);
            req.setAttribute("state2",false);
            req.setAttribute("state1",true);
            req.getRequestDispatcher("/staff/borrowWardrobe.jsp").forward(req,resp);

        }
    }
}
