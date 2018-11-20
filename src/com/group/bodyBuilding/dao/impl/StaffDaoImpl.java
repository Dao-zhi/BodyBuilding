package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.dao.StaffDao;
import com.group.bodyBuilding.vo.Staff;
import com.group.bodyBuilding.vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {
    public Staff queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Staff staff = new Staff();
        ResultSet rs = null;
        String sql = "SELECT sid,name,pwd,age,sex,tel,address,salary FROM staff WHERE sid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                staff.setsId(rs.getString("sid"));
                staff.setName(rs.getString("name"));
                staff.setPassword(rs.getString("pwd"));
                staff.setPassword(rs.getString("pwd"));
                staff.setAge(rs.getInt("age"));
                staff.setSex(rs.getInt("sex"));
                staff.setTel(rs.getString("tel"));
                staff.setAddress(rs.getString("address"));
                staff.setSalary(rs.getInt("salary"));
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
        return staff;
    }

    public boolean add(Staff staff) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO staff (sid,name,pwd,age,sex,tel,address,salary) VALUE (?,?,?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, staff.getsId());
            st.setString(2, staff.getName());
            st.setString(3, staff.getPassword());
            st.setInt(4, staff.getAge());
            st.setInt(5, staff.getSex());
            st.setString(6, staff.getTel());
            st.setString(7, staff.getAddress());
            st.setInt(8, staff.getSalary());
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
        String sql = "DELETE FROM staff WHERE sid=?";
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

    public boolean update(Staff staff) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update staff " +
                "Set sid = ?,name = ?,pwd = ?,age = ?, " +
                "sex = ?,tel = ?,address = ?, salary = ? " +
                "Where sid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, staff.getsId());
            st.setString(2, staff.getName());
            st.setString(3, staff.getPassword());
            st.setInt(4, staff.getAge());
            st.setInt(5, staff.getSex());
            st.setString(6, staff.getTel());
            st.setString(7, staff.getAddress());
            st.setInt(8, staff.getSalary());
            st.setString(9, staff.getsId());
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
    public int calSalary(String id) {
        int userCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(user.uid) AS usercount FROM user WHERE user.account >= 2";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                userCount = rs.getInt("usercount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int salary = queryById(id).getSalary()+100*userCount;
        return salary;
    }
}
