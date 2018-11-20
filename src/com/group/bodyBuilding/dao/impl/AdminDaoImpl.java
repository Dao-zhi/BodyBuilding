package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.AdminDao;
import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.vo.Admin;
import com.group.bodyBuilding.vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    public Admin queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Admin admin = new Admin();
        ResultSet rs = null;
        String sql = "SELECT aid,name,pwd,lastlogintime FROM admin WHERE aid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                admin.setId(rs.getString("aid"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("pwd"));
                admin.setLastLoginTime(rs.getString("lastlogintime"));
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
        return admin;
    }

    public boolean add(Admin admin) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO admin (aid,name,pwd,lastlogintime) VALUE (?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, admin.getId());
            st.setString(2, admin.getName());
            st.setString(3, admin.getPassword());
            st.setString(4, admin.getLastLoginTime());
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
        String sql = "DELETE FROM admin WHERE aid=?";
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

    public boolean update(Admin admin) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update admin " +
                "Set aid = ?,name = ?,pwd = ?,lastlogintime = ? " +
                "Where aid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, admin.getId());
            st.setString(2, admin.getName());
            st.setString(3, admin.getPassword());
            st.setString(4, admin.getLastLoginTime());
            st.setString(5, admin.getId());
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
    public int maleCount() {
        int maleCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(user.uid) AS malecount FROM user WHERE sex = 1";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                maleCount = rs.getInt("malecount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maleCount;
    }

    public int femaleCount() {
        int femaleCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(user.uid) AS femalecount FROM user WHERE sex = 0";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                femaleCount= rs.getInt("femalecount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return femaleCount;
    }

    @Override
    public int teachCount() {
        int teachCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(teach.tid) AS teachcount FROM teach";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                teachCount = rs.getInt("teachcount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachCount;
    }

    @Override
    public int apparatusCount() {
        int apparatusCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(apparatus.appid) AS apparatusCount FROM apparatus ";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                apparatusCount = rs.getInt("apparatusCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apparatusCount;
    }
}
