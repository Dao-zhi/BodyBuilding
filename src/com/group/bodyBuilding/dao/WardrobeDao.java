package com.group.bodyBuilding.dao;

import com.group.bodyBuilding.vo.Wardrobe;

import java.util.List;

public interface WardrobeDao {
    public Wardrobe queryById(String id);

    public boolean add(Wardrobe wardrobe);

    public boolean del(String id);

    public boolean update(Wardrobe wardrobe);

    public List<Wardrobe> findAllWardrobe();

    public List<Wardrobe> wardrobeList();

    public boolean changeState(String id,String wid);

    public Wardrobe borrowQuery(String id);
}
