package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

import java.util.List;

public interface TeachDao {
    public Teach queryById(String id);

    public boolean add(Teach teach);

    public boolean del(String id);

    public boolean update(Teach teach);

    public List<Teach> teachList();

    public List<User> userList(String id);

    public int calSalary(String id);

    public boolean resetPassword(String id);

    public Teach queryByUid(String uId);
}
