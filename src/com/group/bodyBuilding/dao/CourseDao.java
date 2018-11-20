package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Course;

import java.util.List;

public interface CourseDao {
    public Course queryById(String id);

    public boolean add(Course course);

    public boolean del(String id);

    public boolean update(Course course);

    public List<Course> courseList();

    public int courseCount();

    public String queryByTid(String tid);

    public boolean selectCourse(String cid,String uid);

    public String queryByUid(String uid);
}
