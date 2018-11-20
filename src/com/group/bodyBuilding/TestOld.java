package com.group.bodyBuilding;

public class TestOld {
     /*Student_old student = new Student_old();
        student.setId("1001");
        student.setSid("18941651321");
        student.setSname("张三");
        student.setStel("15548523256");
        student.setSaddress("电子科大");
        student.setSroom("1520");
        student.setClass_id("1007");
        student.setStat(0);
        StudentDao_old studentDao = Factory.getStudentDao();
        studentDao.add(student);*/
       /* Student_old student = new Student_old();
        StudentDao_old studentDao = Factory.getStudentDao();
        student = studentDao.queryById("1001");
        System.out.println(student.getSname());*/
        /*List<Student_old> student = new ArrayList<Student_old>();
        StudentDao_old studentDao = Factory.getStudentDao();
        student = studentDao.queryByName("张三");
        System.out.println(student.get(0).getSname());*/
        /*StudentDao_old studentDao = Factory.getStudentDao();
        ResultSet rs = studentDao.queryJoinByCollege("001");
        if(rs.next()){
            System.out.println(rs.getString("sname"));
        }*/
        /*StudentDao_old studentDao = Factory.getStudentDao();
        ResultSet rs = studentDao.queryJoinById("1001");
        if(rs.next()){
            System.out.println(rs.getString("sname"));
        }*/
        /*Student_old student = new Student_old();
        student.setId("1001");
        student.setSid("641261425");
        student.setSname("李四");
        student.setStel("1262506");
        student.setSaddress("电子科基大");
        student.setSroom("597");
        student.setClass_id("124267");
        student.setStat(0);
        StudentDao_old studentDao = Factory.getStudentDao();
        studentDao.update(student);*/
        /*StudentDao_old studentDao = Factory.getStudentDao();
        studentDao.deleteById("1001");*/
        /*StudentDao_old studentDao = Factory.getStudentDao();
        List<Student_old> student = studentDao.findAll();
        System.out.println(student.get(0).getSname());
        System.out.println(studentDao.findBySid("123456789"));*/
        /*StudentDao_old studentDao = Factory.getStudentDao();
        studentDao.findAll();*/
        /*for(int i=0;i<30;i++) {
            Student_old student = new Student_old();
            student.setId("010101"+i);
            student.setSid("189416513211551");
            student.setSname("王"+i);
            student.setClass_id("010101");
            student.setStat(0);
            StudentDao_old studentDao = Factory.getStudentDao();
            studentDao.add(student);
            Authority_old authority = new Authority_old();
            authority.setId(student.getId());
            authority.setAuthority(2);
            authority.setPassword(student.getId().substring(student.getId().length()-6));
            AuthorityDao_old authorityDao = Factory.getAuthorityDao();
            authorityDao.add(authority);
        }*/
        /*Connection conn=new ConnectionDatabase().getConnnection();
        Statement st=null;
        String sql ="SELECT *FROM user";
        try {
            st=conn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                System.out.print(rs.getString("uid")+"\t");
                System.out.print(rs.getString("name")+"\t");
                System.out.print(rs.getString("pwd")+"\t");
                System.out.print(rs.getString("account")+"\t");
                System.out.print(rs.getString("age")+"\t");
                System.out.print(rs.getString("sex")+"\t");
                System.out.print(rs.getString("tel")+"\t");
                System.out.print(rs.getString("address")+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
      /*  Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM admin";
        List<Admin> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getString("aid"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("pwd"));
                admin.setLastLoginTime(rs.getString("lastlogintime"));
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getId() + "    ");
            System.out.print(list.get(i).getName() + "    ");
            System.out.print(list.get(i).getPassword() + "    ");
            System.out.print(list.get(i).getLastLoginTime() + "\n");
        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM apparatus";
        List<Apparatus> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Apparatus apparatus= new Apparatus();
                apparatus.setAppId(rs.getString("appid"));
                apparatus.setaName(rs.getString("aname"));
                apparatus.setaState(rs.getInt("astate"));
                apparatus.setbState(rs.getString("bstate"));
                list.add(apparatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getAppId()+"    ");
            System.out.print(list.get(i).getaName()+"    ");
            System.out.print(list.get(i).getaState()+"    ");
            System.out.print(list.get(i).getbState()+"\n");
        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM authority";
        List<Authority> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Authority authority= new Authority();
                authority.setId(rs.getString("id"));
                authority.setAuthority(rs.getInt("authority"));
                list.add(authority);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getId()+"    ");
            System.out.print(list.get(i).getAuthority()+"    \n");
        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM course";
        List<CourseDao> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CourseDao course= new CourseDao();
                course.setcId(rs.getString("id"));
                course.setcName(rs.getString("cname"));
                course.settId(rs.getString("tid"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getcId()+"    ");
            System.out.print(list.get(i).getcName()+"    ");
            System.out.print(list.get(i).gettId()+"    \n");

        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM scourse";
        List<ScourseDao> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ScourseDao scourse= new ScourseDao();
                scourse.setsCid(rs.getString("scid"));
                scourse.setuId(rs.getString("uid"));
                scourse.settId(rs.getString("tid"));
                list.add(scourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getsCid()+"    ");
            System.out.print(list.get(i).getuId()+"    ");
            System.out.print(list.get(i).gettId()+"    \n");

        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM staff";
        List<Staff> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Staff staff= new Staff();
                staff.setsId(rs.getString("sid"));
                staff.setName(rs.getString("name"));
                staff.setPassword(rs.getString("pwd"));
                staff.setAge(rs.getInt("age"));
                staff.setSex(rs.getInt("sex"));
                staff.setTel(rs.getString("tel"));
                staff.setAddress(rs.getString("address"));
                staff.setSalary(rs.getInt("salary"));
                list.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getsId()+"    ");
            System.out.print(list.get(i).getName()+"    ");
            System.out.print(list.get(i).getPassword()+"    ");
            System.out.print(list.get(i).getAge()+"    ");
            System.out.print(list.get(i).getSex()+"    ");
            System.out.print(list.get(i).getTel()+"    ");
            System.out.print(list.get(i).getAddress()+"    ");
            System.out.print(list.get(i).getSalary()+"    ");
        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM teach";
        List<Teach> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Teach teach= new Teach();
                teach.settId(rs.getString("tid"));
                teach.setName(rs.getString("name"));
                teach.setPassword(rs.getString("pwd"));
                teach.setTel(rs.getString("tel"));
                teach.setAge(rs.getInt("age"));
                teach.setSex(rs.getInt("sex"));
                teach.setAddress(rs.getString("address"));
                teach.setSalary(rs.getInt("salary"));
                list.add(teach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).gettId()+"    ");
            System.out.print(list.get(i).getName()+"    ");
            System.out.print(list.get(i).getPassword()+"    ");
            System.out.print(list.get(i).getAge()+"    ");
            System.out.print(list.get(i).getSex()+"    ");
            System.out.print(list.get(i).getTel()+"    ");
            System.out.print(list.get(i).getAddress()+"    ");
            System.out.print(list.get(i).getSalary()+"    \n");
        }*/
        /*Connection conn = new ConnectionDatabase().getConnnection();
        Statement st = null;
        String sql = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                User user= new User();
                user.setuId(rs.getString("uid"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("pwd"));
                user.setAccount(rs.getInt("account"));
                user.setTel(rs.getString("tel"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                user.setAddress(rs.getString("address"));
                user.setTime(rs.getInt("time"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getuId()+"    ");
            System.out.print(list.get(i).getName()+"    ");
            System.out.print(list.get(i).getPassword()+"    ");
            System.out.print(list.get(i).getAccount()+"    ");
            System.out.print(list.get(i).getAge()+"    ");
            System.out.print(list.get(i).getSex()+"    ");
            System.out.print(list.get(i).getTel()+"    ");
            System.out.print(list.get(i).getAddress()+"    ");
            System.out.print(list.get(i).getTime()+"    \n");
        }*/
}
