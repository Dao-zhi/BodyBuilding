package com.group.bodyBuilding;

import com.group.bodyBuilding.dao.*;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.naming.ldap.StartTlsRequest;
import javax.xml.stream.events.StartDocument;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String args[]) throws SQLException {
        //以下是数据持久化操作测试代码
        //AuthorityDao
        /*AuthorityDao authorityDao = Factory.getAuthorityDao();
        int i = 0;
        i = authorityDao.queryById("123456");
        System.out.print(i);*/
        /*AuthorityDao authorityDao = Factory.getAuthorityDao();
        boolean flag = authorityDao.del("123456");
        System.out.print(flag);*/
       /* AuthorityDao authorityDao = Factory.getAuthorityDao();
        Authority authority = new Authority();
        authority.setId("123456");
        authority.setAuthority(1);
        boolean flag = authorityDao.add(authority);
        System.out.print(flag);*/

        //AdminDao
        /*AdminDao adminDao = Factory.getAdminDao();
        Admin admin = new Admin();
        admin = adminDao.queryById("1");
        System.out.print(admin.getId()+"    ");
        System.out.print(admin.getName()+"    ");
        System.out.print(admin.getPassword()+"    ");
        System.out.print(admin.getLastLoginTime()+"    \n");*/
        /*AdminDao adminDao = Factory.getAdminDao();
        Admin admin = new Admin();
        admin.setId("2");
        admin.setName("admin2");
        admin.setPassword("root");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String startTime = df.format(new Date());
        System.out.println(startTime);// new Date()为获取当前系统时间
        admin.setLastLoginTime(startTime);
        adminDao.add(admin);*/
       /* AdminDao adminDao = Factory.getAdminDao();
        Admin admin = new Admin();
        admin.setId("2");
        admin.setName("admin2");
        admin.setPassword("root");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String startTime = df.format(new Date());
        System.out.println(startTime);
        admin.setLastLoginTime(startTime);
        System.out.println(adminDao.update(admin));*/
        /*AdminDao adminDao = Factory.getAdminDao();
        System.out.println(adminDao.del("2"));*/
        /*AdminDao adminDao = Factory.getAdminDao();
        int maleCount = adminDao.maleCount();
        int femalCount = adminDao.femaleCount();
        System.out.print(maleCount+"\n"+femalCount);*/
        /*AdminDao adminDao = Factory.getAdminDao();
        int teachCount = adminDao.teachCount();
        System.out.print(teachCount);*/
        /*AdminDao adminDao = Factory.getAdminDao();
        int apparatusCount = adminDao.apparatusCount();
        System.out.print(apparatusCount);*/

        //ApparatusDao
        /*ApparatusDao apparatusDao = Factory.getApparatusDao();
        Apparatus apparatus = new Apparatus();
        apparatus = apparatusDao.queryById("1");
        System.out.print(apparatus.getAppId()+"    ");
        System.out.print(apparatus.getaName()+"    ");
        System.out.print(apparatus.getaState()+"    ");
        System.out.print(apparatus.getbState()+"    ");
        System.out.print(apparatus.getAccount()+"\n");*/
        /*ApparatusDao apparatusDao = Factory.getApparatusDao();
        Apparatus apparatus = new Apparatus();
        apparatus.setAppId("11");
        apparatus.setaName("测试");
        apparatus.setaState(0);
        apparatus.setbState("0");
        apparatus.setAccount(3);
        System.out.println(apparatusDao.add(apparatus));*/
        /*ApparatusDao apparatusDao = Factory.getApparatusDao();
        Apparatus apparatus = new Apparatus();
        apparatus.setAppId("11");
        apparatus.setaName("测试2");
        apparatus.setaState(1);
        apparatus.setbState("1");
        apparatus.setAccount(2);
        System.out.println(apparatusDao.update(apparatus));*/
        /*ApparatusDao apparatusDao = Factory.getApparatusDao();
        System.out.println(apparatusDao.del("11"));*/
        /*ApparatusDao apparatusDao = Factory.getApparatusDao();
        System.out.print(apparatusDao.changeBstate("1","10086"));*/
        /*ApparatusDao apparatusDao = Factory.getApparatusDao();
        List<Apparatus> apparatusList = new ArrayList<>();
        apparatusList = apparatusDao.apparatusList();
        for(int i=0;i<apparatusList.size();i++){
            System.out.println(apparatusList.get(i).getAppId());
        }*/


        //CourseDao
        /*CourseDao courseDao = Factory.getCourseDao();
        Course course = new Course();
        course = courseDao.queryById("1");
        System.out.print(course.getcId()+"    ");
        System.out.print(course.getcName()+"    ");
        System.out.print(course.gettId()+"    \n");*/
        /*CourseDao courseDao = Factory.getCourseDao();
        Course course = new Course();
        course.setcId("5");
        course.setcName("测试");
        course.settId("0");
        System.out.println(courseDao.add(course));*/
        /*CourseDao courseDao = Factory.getCourseDao();
        Course course = new Course();
        course.setcId("5");
        course.setcName("测试1");
        course.settId("1");
        System.out.println(courseDao.update(course));*/
        /*CourseDao courseDao = Factory.getCourseDao();
        System.out.println(courseDao.del("5"));*/
        /*CourseDao courseDao = Factory.getCourseDao();
        List<Course> courseList = new ArrayList<>();
        courseList = courseDao.courseList();
        for(int i=0;i<courseList.size();i++){
            System.out.print(courseList.get(i).getcId()+"    ");
            System.out.print(courseList.get(i).gettId()+"    ");
            System.out.print(courseList.get(i).getcName()+"    \n");
        }*/

        //ScourseDao
        /*ScourseDao scourseDao = Factory.getScourseDao();
        Scourse scourse = new Scourse();
        scourse = scourseDao.queryById("1");
        System.out.print(scourse.getsCid()+"    ");
        System.out.print(scourse.getuId()+"    ");
        System.out.print(scourse.gettId()+"    \n");*/
        /*ScourseDao scourseDao = Factory.getScourseDao();
        Scourse scourse = new Scourse();
        scourse.setsCid("5");
        scourse.setuId("5");
        scourse.settId("5");
        System.out.println(scourseDao.add(scourse));*/
        /*ScourseDao scourseDao = Factory.getScourseDao();
        Scourse scourse = new Scourse();
        scourse.setsCid("5");
        scourse.setuId("6");
        scourse.settId("6");
        System.out.println(scourseDao.update(scourse));*/
        /*ScourseDao scourseDao = Factory.getScourseDao();
        System.out.println(scourseDao.del("5"));*/

        //StaffDao
        /*StaffDao staffDao = Factory.getStaffDao();
        Staff staff = new Staff();
        staff = staffDao.queryById("1");
        System.out.print(staff.getsId()+"    ");
        System.out.print(staff.getName()+"    ");
        System.out.print(staff.getPassword()+"    ");
        System.out.print(staff.getAge()+"    ");
        System.out.print(staff.getSex()+"    ");
        System.out.print(staff.getTel()+"    ");
        System.out.print(staff.getAddress()+"    ");
        System.out.print(staff.getSalary()+"    \n");*/
        /*StaffDao staffDao = Factory.getStaffDao();
        Staff staff = new Staff();
        staff.setsId("2");
        staff.setName("大姐姐");
        staff.setPassword("456789");
        staff.setAge(18);
        staff.setSex(1);
        staff.setTel("13088043229");
        staff.setAddress("西南财经大学");
        staff.setSalary(2000);
        System.out.println(staffDao.add(staff));*/
        /*StaffDao staffDao = Factory.getStaffDao();
        Staff staff = new Staff();
        staff.setsId("2");
        staff.setName("小姐");
        staff.setPassword("963258");
        staff.setAge(19);
        staff.setSex(2);
        staff.setTel("15896325874");
        staff.setAddress("西南财经小学");
        staff.setSalary(5000);
        System.out.println(staffDao.update(staff));*/
        /*StaffDao staffDao = Factory.getStaffDao();
        System.out.println(staffDao.del("2"));*/
        /*StaffDao staffDao = Factory.getStaffDao();
        System.out.print(staffDao.calSalary("1"));*/

        //TeachDao
        /*TeachDao teachDao = Factory.getTeachDao();
        Teach teach = new Teach();
        teach = teachDao.queryById("1");
        System.out.print(teach.gettId()+"    ");
        System.out.print(teach.getName()+"    ");
        System.out.print(teach.getPassword()+"    ");
        System.out.print(teach.getTel()+"    ");
        System.out.print(teach.getAddress()+"    ");
        System.out.print(teach.getAge()+"    ");
        System.out.print(teach.getSex()+"    ");
        System.out.print(teach.getSalary()+"    \n");*/
       /* TeachDao teachDao = Factory.getTeachDao();
        Teach teach = new Teach();
        teach.settId("9");
        teach.setName("大姐姐");
        teach.setPassword("456789");
        teach.setTel("13088043229");
        teach.setAddress("西南财经大学");
        teach.setAge(18);
        teach.setSex(1);
        teach.setSalary(2000);
        System.out.println(teachDao.add(teach));*/
        /*TeachDao teachDao = Factory.getTeachDao();
        Teach teach = new Teach();
        teach.settId("9");
        teach.setName("小姐");
        teach.setPassword("4891");
        teach.setTel("2308895629");
        teach.setAddress("西南财经小学");
        teach.setAge(20);
        teach.setSex(2);
        teach.setSalary(5000);
        System.out.println(teachDao.update(teach));*/
        /*TeachDao teachDao = Factory.getTeachDao();
        System.out.println(teachDao.del("9"));*/
        /*TeachDao teachDao = Factory.getTeachDao();
        List<Teach> teachList = new ArrayList<>();
        teachList = teachDao.teachList();
        for(int i=0;i<teachList.size();i++){
            System.out.print(teachList.get(i).gettId()+"    ");
            System.out.print(teachList.get(i).getName()+"    ");
            System.out.print(teachList.get(i).getPassword()+"    ");
            System.out.print(teachList.get(i).getTel()+"    ");
            System.out.print(teachList.get(i).getAddress()+"    ");
            System.out.print(teachList.get(i).getAge()+"    ");
            System.out.print(teachList.get(i).getSex()+"    ");
            System.out.print(teachList.get(i).getSalary()+"    \n");
        }*/
        /*TeachDao teachDao = Factory.getTeachDao();
        List<User> userList = new ArrayList<>();
        userList = teachDao.userList("1");
        for(int i=0;i<userList.size();i++){
            System.out.print(userList.get(i).getuId()+"    ");
            System.out.print(userList.get(i).getName()+"    ");
            System.out.print(userList.get(i).getPassword()+"    ");
            System.out.print(userList.get(i).getAccount()+"    ");
            System.out.print(userList.get(i).getAge()+"    ");
            System.out.print(userList.get(i).getSex()+"    ");
            System.out.print(userList.get(i).getTel()+"    ");
            System.out.print(userList.get(i).getAddress()+"    ");
            System.out.print(userList.get(i).getTime()+"    \n");
        }*/
        /*TeachDao teachDao = Factory.getTeachDao();
        int salary = teachDao.calSalary("1");
        System.out.print(salary);*/
        /*TeachDao teachDao = Factory.getTeachDao();
        System.out.print(teachDao.resetPassword("1"));*/

        //UserDao
        /*UserDao userDao = Factory.getUserDao();
        User user = new User();
        user = userDao.queryById("1");
        System.out.print(user.getuId()+"    ");
        System.out.print(user.getName()+"    ");
        System.out.print(user.getPassword()+"    ");
        System.out.print(user.getAccount()+"    ");
        System.out.print(user.getAge()+"    ");
        System.out.print(user.getSex()+"    ");
        System.out.print(user.getTel()+"    ");
        System.out.print(user.getAddress()+"    ");
        System.out.print(user.getTime()+"    \n");*/
        /*UserDao userDao = Factory.getUserDao();
        User user = new User();
        user.setuId("5");
        user.setName("董永");
        user.setPassword("125892");
        user.setAccount(2);
        user.setAge(18);
        user.setSex(1);
        user.setTel("13088043229");
        user.setAddress("西南财经大学");
        user.setTime(200);
        System.out.println(userDao.add(user));*/
        /*UserDao userDao = Factory.getUserDao();
        User user = new User();
        user.setuId("5");
        user.setName("小花");
        user.setPassword("78895");
        user.setAccount(3);
        user.setAge(22);
        user.setSex(2);
        user.setTel("982563222");
        user.setAddress("西南财经");
        user.setTime(50);
        System.out.println(userDao.update(user));*/
        /*UserDao userDao = Factory.getUserDao();
        System.out.println(userDao.del("5"));*/
        /*UserDao userDao = Factory.getUserDao();
        List<User> userList = new ArrayList<>();
        userList = userDao.userList();
        for(int i=0;i<userList.size();i++){
            System.out.print(userList.get(i).getuId()+"    ");
            System.out.print(userList.get(i).getName()+"    ");
            System.out.print(userList.get(i).getPassword()+"    ");
            System.out.print(userList.get(i).getAccount()+"    ");
            System.out.print(userList.get(i).getAge()+"    ");
            System.out.print(userList.get(i).getSex()+"    ");
            System.out.print(userList.get(i).getTel()+"    ");
            System.out.print(userList.get(i).getAddress()+"    ");
            System.out.print(userList.get(i).getTime()+"    \n");
        }*/
        /*UserDao userDao = Factory.getUserDao();
        System.out.print(userDao.resetPassword("1"));*/
        /*UserDao userDao = Factory.getUserDao();
        List<Apparatus> apparatusList = new ArrayList<>();
        apparatusList = userDao.apparatusList(2);
        for(int i = 0; i<apparatusList.size();i++){
            System.out.print(apparatusList.get(i).getAppId()+"    ");
            System.out.print(apparatusList.get(i).getaName()+"    ");
            System.out.print(apparatusList.get(i).getaState()+"    ");
            System.out.print(apparatusList.get(i).getbState()+"    ");
            System.out.print(apparatusList.get(i).getAccount()+"\n");
        }*/

        //WardrobeDao
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        Wardrobe wardrobe = new Wardrobe();
        wardrobe = wardrobeDao.queryById("1");
        System.out.print(wardrobe.getId()+"    ");
        System.out.print(wardrobe.getState()+"    \n");*/
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setId("6");
        wardrobe.setState("1");
        System.out.println(wardrobeDao.add(wardrobe));*/
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setId("6");
        wardrobe.setState("0");
        System.out.println(wardrobeDao.update(wardrobe));*/
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        System.out.println(wardrobeDao.del("6"));*/
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        List<Wardrobe> wardrobeList = new ArrayList<>();
        wardrobeList = wardrobeDao.findAllWardrobe();
        for(int i=0;i<wardrobeList.size();i++){
            System.out.print(wardrobeList.get(i).getId()+"    ");
            System.out.print(wardrobeList.get(i).getState()+"    \n");
        }*/
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        List<Wardrobe> wardrobeList = new ArrayList<>();
        wardrobeList = wardrobeDao.wardrobeList();
        for(int i=0;i<wardrobeList.size();i++){
            System.out.print(wardrobeList.get(i).getId()+"    ");
            System.out.print(wardrobeList.get(i).getState()+"    \n");
        }*/
        /*WardrobeDao wardrobeDao = Factory.getWardrobeDao();
        System.out.print(wardrobeDao.changeState("1","10086"));*/
    }
}
