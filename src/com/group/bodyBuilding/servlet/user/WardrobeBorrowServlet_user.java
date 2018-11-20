package com.group.bodyBuilding.servlet.user;

import com.group.bodyBuilding.dao.WardrobeDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.User;
import com.group.bodyBuilding.vo.Wardrobe;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class WardrobeBorrowServlet_user extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*int flag = Integer.parseInt(req.getParameter("flag"));
        System.out.println(flag);*/
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            //System.out.println("cookie存在");
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
            /*System.out.println(id);*/
        }
        Wardrobe wardrobe = new Wardrobe();
        List<Wardrobe> wardrobes = new ArrayList<>();
        List<Wardrobe> wardrobeList = new ArrayList<>();
        WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        wardrobe = wardrobeDao.borrowQuery(id);
        wardrobes.add(wardrobe);
        wardrobeList = wardrobeDao.wardrobeList();
        if(wardrobes.get(0).getId() != null){
            req.setAttribute("wardrobeList", wardrobes);
            req.getRequestDispatcher("/user/borrowWardrobe.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("wardrobeList", wardrobeList);
            req.getRequestDispatcher("/user/borrowWardrobe.jsp").forward(req,resp);
        }
    }
}
