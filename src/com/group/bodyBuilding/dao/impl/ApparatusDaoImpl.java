package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.ApparatusDao;
import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Apparatus;
import com.group.bodyBuilding.vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApparatusDaoImpl implements ApparatusDao {
    public Apparatus queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Apparatus apparatus = new Apparatus();
        ResultSet rs = null;
        String sql = "SELECT appid,aname,astate,bstate,account FROM apparatus WHERE appid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                apparatus.setAppId(rs.getString("appid"));
                apparatus.setaName(rs.getString("aname"));
                apparatus.setaState(rs.getInt("astate"));
                apparatus.setbState(rs.getString("bstate"));
                apparatus.setAccount(rs.getInt("account"));
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
        return apparatus;
    }

    public boolean add(Apparatus apparatus) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO apparatus (appid,aname,astate,bstate,account) VALUE (?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, apparatus.getAppId());
            st.setString(2, apparatus.getaName());
            st.setInt(3, apparatus.getaState());
            st.setString(4, apparatus.getbState());
            st.setInt(5, apparatus.getAccount());
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
        String sql = "DELETE FROM apparatus WHERE appid=?";
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

    public boolean update(Apparatus apparatus) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update apparatus " +
                "Set appid = ?,aname = ?,astate = ?,bstate = ?,account = ? " +
                "Where appid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, apparatus.getAppId());
            st.setString(2, apparatus.getaName());
            st.setInt(3, apparatus.getaState());
            st.setString(4, apparatus.getbState());
            st.setInt(5, apparatus.getAccount());
            st.setString(6, apparatus.getAppId());
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
    public boolean changeBstate(String id, String uid) {
        boolean flag = false;
        /*UserDao userDao = Factory.getUserDao();
        User user = new User();
        user = userDao.queryById(uid);
        Apparatus apparatus = new Apparatus();
        apparatus = this.queryById(id);
        if(user.getAccount()<apparatus.getAccount())
        {
            return false;
        }*/
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update apparatus " +
                "Set bstate = ?" +
                "Where appid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, uid);
            st.setString(2, id);
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
    public List<Apparatus> apparatusList() {
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM apparatus";
        List<Apparatus> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Apparatus apparatus = new Apparatus();
                apparatus.setAppId(rs.getString("appid"));
                apparatus.setaName(rs.getString("aname"));
                apparatus.setaState(rs.getInt("astate"));
                apparatus.setbState(rs.getString("bstate"));
                apparatus.setAccount(rs.getInt("account"));
                list.add(apparatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int apparatusCount() {
        int apparatusCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(appid) AS apparatusCount FROM apparatus";
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
