package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {
    public User queryById(String id);

    public boolean add(User user);

    public boolean del(String id);

    public boolean update(User user);

    public List<User> userList();

    public boolean resetPassword(String id);

    public List<Apparatus> apparatusList(int account);

    public List<Teach> teachList(String courseId);
}
