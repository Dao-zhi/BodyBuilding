package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Staff;

public interface StaffDao {
    public Staff queryById(String id);

    public boolean add(Staff staff);

    public boolean del(String id);

    public boolean update(Staff staff);

    public int calSalary(String id);
}
