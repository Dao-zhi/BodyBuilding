package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Admin;

public interface AdminDao {
    public Admin queryById(String id);

    public boolean add(Admin admin);

    public boolean del(String id);

    public boolean update(Admin admin);

    public int maleCount();

    public int femaleCount();

    public int teachCount();

    public int apparatusCount();
}
