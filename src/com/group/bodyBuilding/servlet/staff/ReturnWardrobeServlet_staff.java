package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.ApparatusDao;
import com.group.bodyBuilding.dao.WardrobeDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Apparatus;
import com.group.bodyBuilding.vo.Wardrobe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.FaultAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReturnWardrobeServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("wardrobeId");
        System.out.println(id);
        WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        if(wardrobeDao.queryById(id).getState().equals("0")){
            List<Wardrobe> wardrobeList = new ArrayList<>();
            wardrobeList = wardrobeDao.findAllWardrobe();
            req.setAttribute("wardrobeList",wardrobeList);
            req.setAttribute("state",0);
            req.setAttribute("state2",true);
            req.setAttribute("state1",false);
            req.getRequestDispatcher("/staff/wardrobeManage.jsp").forward(req,resp);
        }
        else {
            boolean state = wardrobeDao.changeState("0",id);
            List<Wardrobe> wardrobeList = new ArrayList<>();
            wardrobeList = wardrobeDao.findAllWardrobe();
            req.setAttribute("wardrobeList", wardrobeList);
            req.setAttribute("state", state);
            req.setAttribute("state2", true);
            req.setAttribute("state1", false);
            req.getRequestDispatcher("/staff/wardrobeManage.jsp").forward(req, resp);
        }
    }
}
