package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.dao.CourseDao;
import com.group.bodyBuilding.vo.Course;
import com.group.bodyBuilding.vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    public Course queryById(String id) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        Course course = new Course();
        ResultSet rs = null;
        String sql = "SELECT id,cname,tid FROM course WHERE id=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                course.setcId(rs.getString("id"));
                course.setcName(rs.getString("cname"));
                course.settId(rs.getString("tid"));
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
        return course;
    }

    public boolean add(Course course) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO course (id,cname,tid) VALUE (?,?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, course.getcId());
            st.setString(2, course.getcName());
            st.setString(3, course.gettId());
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
        String sql = "DELETE FROM course WHERE id=?";
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

    public boolean update(Course course) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update course " +
                "Set id = ?,cname = ?,tid = ? " +
                "Where id = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, course.getcId());
            st.setString(2, course.getcName());
            st.setString(3, course.gettId());
            st.setString(4, course.getcId());
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
    public List<Course> courseList() {
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM course";
        List<Course> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Course course = new Course();
                course.setcId(rs.getString("id"));
                course.setcName(rs.getString("cname"));
                course.settId(rs.getString("tid"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int courseCount() {
        int courseCount = 0;
        Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT COUNT(id) AS courseCount FROM course";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                courseCount = rs.getInt("courseCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseCount;
    }

    @Override
    public String queryByTid(String tid) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
       String id = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM course WHERE id=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, tid);
            rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getString("id");
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
        return id;
    }

    @Override
    public boolean selectCourse(String cid, String uid) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        String sql = "Update course " +
                "Set uid = ? " +
                "Where id = ?";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, uid);
            st.setString(2, cid);
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
    public String queryByUid(String uid) {
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String cname = null;
        ResultSet rs = null;
        String sql = "SELECT cname FROM course WHERE uid=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, uid);
            rs = st.executeQuery();
            if (rs.next()) {
                cname = rs.getString("cname");
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
        return cname;
    }
}
