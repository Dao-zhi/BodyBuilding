package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.dao.TeachDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Teach;
import com.group.bodyBuilding.vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeachDaoImpl implements TeachDao {
    public Teach queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Teach teach = new Teach();
        ResultSet rs = null;
        String sql = "SELECT tid,pwd,name,tel,address,age,sex,salary FROM teach WHERE tid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                teach.settId(rs.getString("tid"));
                teach.setName(rs.getString("name"));
                teach.setPassword(rs.getString("pwd"));
                teach.setTel(rs.getString("tel"));
                teach.setAddress(rs.getString("address"));
                teach.setAge(rs.getInt("age"));
                teach.setSex(rs.getInt("sex"));
                teach.setSalary(rs.getInt("salary"));
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
        return teach;
    }

    public boolean add(Teach teach) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO teach (tid,name,pwd,tel,address,age,sex,salary) VALUE (?,?,?,?,?,?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, teach.gettId());
            st.setString(2, teach.getName());
            st.setString(3, teach.getPassword());
            st.setString(4, teach.getTel());
            st.setString(5, teach.getAddress());
            st.setInt(6, teach.getAge());
            st.setInt(7, teach.getSex());
            st.setInt(8, teach.getSalary());
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
        String sql = "DELETE FROM teach WHERE tid=?";
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

    public boolean update(Teach teach) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update teach " +
                "Set tid = ?,name = ?,pwd = ?,tel = ?, " +
                "address = ?,age = ?,sex = ?,salary = ? " +
                "Where tid = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, teach.gettId());
            st.setString(2, teach.getName());
            st.setString(3, teach.getPassword());
            st.setString(4, teach.getTel());
            st.setString(5, teach.getAddress());
            st.setInt(6, teach.getAge());
            st.setInt(7, teach.getSex());
            st.setInt(8, teach.getSalary());
            st.setString(9, teach.gettId());
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
    public List<Teach> teachList() {
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM teach";
        List<Teach> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
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

    @Override
    public List<User> userList(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "SELECT user.uid,name,pwd,account,age,sex,tel,address,time FROM scourse,user WHERE scourse.tid = ? AND user.uid = scourse.uid";
        List<User> list = new ArrayList<>();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
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

    public int calSalary(String id) {
        int userCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "SELECT COUNT(user.uid) AS usercount FROM course,user WHERE tid = ? AND user.uid = course.uid";
        List<User> list = new ArrayList<>();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                userCount = rs.getInt("usercount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int salary = queryById(id).getSalary()+100*userCount;
        return salary;
    }

    @Override
    public boolean resetPassword(String id) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update teach " +
                "Set pwd = \"123456\"" +
                "Where tid = ?";
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
    public Teach queryByUid(String uId) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Teach teach = new Teach();
        ResultSet rs = null;
        String sql = "SELECT teach.tid,pwd,name,tel,address,age,sex,salary FROM teach,course WHERE teach.tid = course.tid AND course.uid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, uId);
            rs = st.executeQuery();
            if (rs.next()) {
                teach.settId(rs.getString("tid"));
                teach.setName(rs.getString("name"));
                teach.setPassword(rs.getString("pwd"));
                teach.setTel(rs.getString("tel"));
                teach.setAddress(rs.getString("address"));
                teach.setAge(rs.getInt("age"));
                teach.setSex(rs.getInt("sex"));
                teach.setSalary(rs.getInt("salary"));
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
        return teach;
    }
}
