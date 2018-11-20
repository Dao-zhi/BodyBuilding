package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Scourse;

public interface ScourseDao {
    public Scourse queryById(String id);

    public boolean add(Scourse scourse);

    public boolean del(String id);

    public boolean update(Scourse scourse);
}
