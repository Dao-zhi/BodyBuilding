package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Authority;

public interface AuthorityDao {
    public int queryById(String id);

    public boolean add(Authority authority);

    public boolean del(String id);

}
