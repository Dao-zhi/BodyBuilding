package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public User queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        User user = new User();
        ResultSet rs = null;
        String sql = "SELECT uid,name,pwd,account,age,sex,tel,address,time FROM user WHERE uid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                user.setuId(rs.getString("uid"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("pwd"));
                user.setAccount(rs.getInt("account"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                user.setTime(rs.getInt("time"));
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
        return user;
    }

    public boolean add(User user) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO user (uid,name,pwd,account,age,sex,tel,address,time) VALUE (?,?,?,?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, user.getuId());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setInt(4, user.getAccount());
            st.setInt(5, user.getAge());
            st.setInt(6, user.getSex());
            st.setString(7, user.getTel());
            st.setString(8, user.getAddress());
            st.setInt(9, user.getTime());
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
        String sql = "DELETE FROM user WHERE uid=?";
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

    public boolean update(User user) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update user " +
                "Set uid = ?,name = ?,pwd = ?,account = ?,age = ?, " +
                "sex = ?,tel = ?,address = ?,time = ? " +
                "Where uid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, user.getuId());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setInt(4, user.getAccount());
            st.setInt(5, user.getAge());
            st.setInt(6, user.getSex());
            st.setString(7, user.getTel());
            st.setString(8, user.getAddress());
            st.setInt(9, user.getTime());
            st.setString(10, user.getuId());
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
    public List<User> userList() {
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setuId(rs.getString("uid"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("pwd"));
                user.setAccount(rs.getInt("account"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                user.setTime(rs.getInt("time"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean resetPassword(String id) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update user " +
                "Set pwd = \"123456\"" +
                "Where uid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
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
    public List<Apparatus> apparatusList(int account) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "SELECT * FROM apparatus WHERE bstate = \"0\" AND account <= ? ";
        List<Apparatus> list = new ArrayList<>();
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, account);
            ResultSet rs = st.executeQuery();
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
    public List<Teach> teachList(String courseId) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "SELECT teach.tid,teach.name,teach.pwd,teach.tel,teach.address,teach.age,teach.sex,teach.salary" +
                " FROM teach,course WHERE teach.tid = course.tid AND course.cid = ? ";
        List<Teach> list = new ArrayList<>();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, courseId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Teach teach = new Teach();
                teach.settId(rs.getString("tid"));
                teach.setName(rs.getString("name"));
                teach.setPassword(rs.getString("pwd"));
                teach.setTel(rs.getString("tel"));
                teach.setAddress(rs.getString("address"));
                teach.setAge(rs.getInt("age"));
                teach.setSex(rs.getInt("sex"));
                teach.setSalary(rs.getInt("salary"));
                list.add(teach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
