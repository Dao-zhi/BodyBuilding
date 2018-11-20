package com.group.bodyBuilding.servlet.staff;

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

public class BorrowApparatusServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appId = req.getParameter("appId");
        String uId = req.getParameter("uId");
        UserDao userDao = Factory.getUserDao();
        User user = new User();
        user = userDao.queryById(uId);
        ApparatusDao apparatusDao = Factory.getApparatusDao();
        Apparatus apparatus = new Apparatus();
        apparatus = apparatusDao.queryById(appId);
        boolean flag1 = true;
        if(user.getAccount()<apparatus.getAccount())
        {
            flag1 = false;
        }
        if(flag1){
            //ApparatusDao apparatusDao = Factory.getApparatusDao();
            if(apparatusDao.queryById(appId).getbState().equals("0")){
                boolean state = apparatusDao.changeBstate(appId,uId);
            /*List<Apparatus> apparatusList = new ArrayList<>();
            apparatusList = apparatusDao.apparatusList();
            req.setAttribute("apparatusList",apparatusList);*/
                req.setAttribute("state2",false);
                req.setAttribute("state1",true);
                req.setAttribute("state",state);
                req.getRequestDispatcher("/staff/borrowApp.jsp").forward(req,resp);
            }
            else {
            /*List<Apparatus> apparatusList = new ArrayList<>();
            apparatusList = apparatusDao.apparatusList();
            req.setAttribute("apparatusList",apparatusList);*/
                req.setAttribute("state",0);
                req.setAttribute("state2",false);
                req.setAttribute("state1",true);
                req.getRequestDispatcher("/staff/borrowApp.jsp").forward(req,resp);

            }
        }
        else {
            req.setAttribute("state",0);
            req.setAttribute("state2",false);
            req.setAttribute("state1",true);
            req.getRequestDispatcher("/staff/borrowApp.jsp").forward(req,resp);
        }

    }
}
