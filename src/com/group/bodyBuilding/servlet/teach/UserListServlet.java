package com.group.bodyBuilding.servlet.teach;

import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

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

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = null;
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
        if (cookieMap.containsKey("cookie_id")) {
            Cookie cookie = (Cookie) cookieMap.get("cookie_id");
            id = cookie.getValue();
        }
            TeachDao teachDao = Factory.getTeachDao();
            List<User> userList = new ArrayList<>();
            userList = teachDao.userList(id);

            req.setAttribute("userList", userList);

            req.getRequestDispatcher("/teach/userList.jsp").forward(req,resp);
    }
}
