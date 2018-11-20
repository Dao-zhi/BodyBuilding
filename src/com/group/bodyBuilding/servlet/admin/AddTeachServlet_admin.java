package com.group.bodyBuilding.servlet.admin;

import com.group.bodyBuilding.dao.CourseDao;
import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Course;
import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTeachServlet_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("pwd");
        int age  = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String  tel = req.getParameter("tel");
        String address = req.getParameter("address");
        int salary = 0;

        String cid = req.getParameter("cid");
        String cname = null;
        /*value="1">杠铃<
                value="2">跑步<
                value="3">瑜伽<
                value="4">健美操*/
        switch (cid){
            case "1":
                cname = "杠铃";
                break;
            case "2":
                cname = "跑步";
                break;
            case "3":
                cname = "瑜伽";
                break;
            case "4":
                cname = "健美操";
                break;
            default:
                cname = "杠铃";
                break;
        }
        String tid = id;
        boolean flag = false;
        Teach teach = new Teach();
        teach.settId(id);
        teach.setName(name);
        teach.setPassword(password);
        teach.setTel(tel);
        teach.setAddress(address);
        teach.setAge(age);
        if(sex.equals("男")){
            teach.setSex(1);
        }
        else {
            teach.setSex(0);
        }
        teach.setSalary(0);

        Course course = new Course();
        CourseDao courseDao = Factory.getCourseDao();
        course.settId(Integer.toString(courseDao.courseCount()+1));
        course.setcName(cname);
        course.setcId(cid);
        course.settId(tid);
        course.setuId("0");
        TeachDao teachDao = Factory.getTeachDao();
        flag = teachDao.add(teach);
        courseDao.add(course);
        req.setAttribute("state2",false);
        req.setAttribute("state1",false);
        req.setAttribute("flag",flag);
        req.setAttribute("state",1);
        req.getRequestDispatcher("/admin/addUser.jsp").forward(req,resp);
    }
}
