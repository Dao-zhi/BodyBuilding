package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Apparatus;

import java.util.List;

public interface ApparatusDao {
    public Apparatus queryById(String id);

    public boolean add(Apparatus apparatus);

    public boolean del(String id);

    public boolean update(Apparatus apparatus);

    public boolean changeBstate(String id,String uid);

    public List<Apparatus> apparatusList();

    public int apparatusCount();
}
