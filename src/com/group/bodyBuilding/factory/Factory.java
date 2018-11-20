package com.group.bodyBuilding.factory;

import com.group.bodyBuilding.dao.*;
import com.group.bodyBuilding.dao.impl.*;

public class Factory {
    public static AdminDao getAdminDao() {
        return new AdminDaoImpl();
    }

    public static AuthorityDao getAuthorityDao() {
        return new AuthorityDaoImpl();
    }

    public static StaffDao getStaffDao() {
        return new StaffDaoImpl();
    }

    public static TeachDao getTeachDao() {
        return new TeachDaoImpl();
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static  ApparatusDao getApparatusDao(){return  new ApparatusDaoImpl();}

    public static CourseDao getCourseDao(){return new CourseDaoImpl();}

    public static  ScourseDao getScourseDao(){return new ScourseDaoImpl();}

    public static  WardrobeDao getWardrobeDao(){return new WardrobeDaoImpl();}
}
