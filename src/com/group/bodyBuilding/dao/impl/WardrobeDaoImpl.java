package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.dao.WardrobeDao;
import com.group.bodyBuilding.vo.Wardrobe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WardrobeDaoImpl implements WardrobeDao{
    public Wardrobe queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Wardrobe wardrobe = new Wardrobe();
        ResultSet rs = null;
        String sql = "SELECT id,state FROM wardrobe WHERE id=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                wardrobe.setId(rs.getString("id"));
                wardrobe.setState(rs.getString("state"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wardrobe;
    }

    public boolean add(Wardrobe wardrobe) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO wardrobe (id,state) VALUE (?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, wardrobe.getId());
            st.setString(2, wardrobe.getState());
            int i = st.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean del(String id) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "DELETE FROM wardrobe WHERE id=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            int i = st.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean update(Wardrobe wardrobe) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update wardrobe " +
                "Set id = ?,state = ? " +
                "Where id = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, wardrobe.getId());
            st.setString(2, wardrobe.getState());
            st.setString(3, wardrobe.getId());
            if (st.executeUpdate() != 0) {
                //System.out.println("修改成功！");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public List<Wardrobe> findAllWardrobe(){
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM wardrobe";
        List<Wardrobe> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Wardrobe wardrobe = new Wardrobe();
                wardrobe.setId(rs.getString("id"));
                wardrobe.setState(rs.getString("state"));
                list.add(wardrobe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Wardrobe> wardrobeList(){
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM wardrobe WHERE state = '0'";
        List<Wardrobe> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Wardrobe wardrobe = new Wardrobe();
                wardrobe.setId(rs.getString("id"));
                wardrobe.setState(rs.getString("state"));
                list.add(wardrobe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean changeState(String uid,String wid) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update wardrobe " +
                "Set state = ?" +
                "Where id = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, uid);
            st.setString(2, wid);
            if (st.executeUpdate() != 0) {
                //System.out.println("修改成功！");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public Wardrobe borrowQuery(String id) {
        Wardrobe wardrobe = new Wardrobe();
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "SELECT id,state FROM wardrobe WHERE state = ?";
        List<Wardrobe> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,id);
            rs = st.executeQuery();
           if (rs.next()) {
               /*System.out.println("已运行！");
               System.out.println(rs.getString("id"));
               System.out.println(rs.getString("state"));*/
                wardrobe.setId(rs.getString("id"));
                wardrobe.setState(rs.getString("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wardrobe;
    }
}
