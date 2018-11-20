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

public class AddApparatusServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String aname = req.getParameter("name");
        int account = Integer.parseInt(req.getParameter("account"));
        boolean flag = false;
        Apparatus apparatus = new Apparatus();
        ApparatusDao apparatusDao = Factory.getApparatusDao();
        String appid = Integer.toString(apparatusDao.apparatusCount()+1);
        apparatus.setAppId(appid);
        apparatus.setaName(aname);
        apparatus.setAccount(account);
        apparatus.setaState(0);
        apparatus.setbState("0");
        flag = apparatusDao.add(apparatus);
        req.setAttribute("state",true);
        req.setAttribute("flag",flag);
        req.getRequestDispatcher("/admin/addApp.jsp").forward(req,resp);
    }
}
