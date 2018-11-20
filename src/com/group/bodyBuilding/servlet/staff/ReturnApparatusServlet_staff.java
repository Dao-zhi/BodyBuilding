package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.ApparatusDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.dao.impl.ApparatusDaoImpl;
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

public class ReturnApparatusServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("appId");
        /*System.out.println(id);*/
        ApparatusDao apparatusDao = Factory.getApparatusDao();
        if(apparatusDao.queryById(id).getbState().equals("0")){
            List<Apparatus> apparatusList = new ArrayList<>();
            apparatusList = apparatusDao.apparatusList();
            req.setAttribute("apparatusList",apparatusList);
            req.setAttribute("state",0);
            req.setAttribute("state2",true);
            req.setAttribute("state1",false);
            req.getRequestDispatcher("/staff/apparatusManage.jsp").forward(req,resp);
        }
        else {
            boolean state = apparatusDao.changeBstate(id,"0");
            List<Apparatus> apparatusList = new ArrayList<>();
            apparatusList = apparatusDao.apparatusList();
            req.setAttribute("apparatusList",apparatusList);
            req.setAttribute("state",state);
            req.setAttribute("state2",true);
            req.setAttribute("state1",false);
            req.getRequestDispatcher("/staff/apparatusManage.jsp").forward(req,resp);
        }
    }
}
