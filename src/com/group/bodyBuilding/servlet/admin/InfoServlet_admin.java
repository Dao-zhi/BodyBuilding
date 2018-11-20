package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.AdminDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class InfoServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            //System.out.println(id);
        }
        AdminDao adminDao = Factory.getAdminDao();
        int maleCount = adminDao.maleCount();
        int femaleCount = adminDao.femaleCount();
        int teachCount = adminDao.teachCount();
        int userCount = maleCount+femaleCount;
        int apparatueCount = adminDao.apparatusCount();
        String lastLoginTime = adminDao.queryById(id).getLastLoginTime();

        //登陆后要设置登录时间
        Admin admin = new Admin();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String startTime = df.format(new Date());
        /*System.out.println(startTime);*/
        admin.setId(id);
        admin.setName(adminDao.queryById(id).getName());
        admin.setPassword(adminDao.queryById(id).getPassword());
        admin.setLastLoginTime(startTime);
        adminDao.update(admin);

        req.setAttribute("maleCount", maleCount);
        req.setAttribute("femaleCount", femaleCount);
        req.setAttribute("userCount", userCount);
        req.setAttribute("teachCount", teachCount);
        req.setAttribute("apparatusCount", apparatueCount);
        req.setAttribute("lastLoginTime",lastLoginTime);
        req.getRequestDispatcher("/admin/admin.jsp").forward(req,resp);
    }
}
