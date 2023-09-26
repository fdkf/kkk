package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Dept;
import pojo.Emp;
import duil.JdbcUtils;
import pojo.Users;

import java.sql.SQLException;
import java.util.List;

public class ScDaoimpl implements ScDao {
    QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public int getCount(Emp vo) {
        StringBuffer sf = new StringBuffer("select  count(*) from  em   e  INNER JOIN   dep  d" +
                " on  e.deptno=d.deptno where   1=1 ");

        //对条件判断
        if (vo.getEname() != null && !"".equals(vo.getEname())) {
            sf.append(" and  e.ename  like '%" + vo.getEname() + "%'");
        }
        if (vo.getDate1() != null) {
            sf.append(" and e.brith >='" + new java.sql.Date(vo.getDate1().getTime()) + "'");
        }
        if (vo.getDate2() != null) {
            sf.append(" and e.brith <='" + new java.sql.Date(vo.getDate2().getTime()) + "'");
        }
        /*部门*/
        if (vo.getDid() != 0) {
            sf.append(" and e.deptno=" + vo.getDid());
        }
        System.out.println("这是");
        System.out.println(sf.toString());
        try {
            return  qr.query(sf.toString(), new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public void addEmp(Emp emp) throws SQLException {
        String   sql="insert  into  em  values(?,?,?,?,?,?,?)";
            qr.update(sql,emp.getEmpno(),emp.getEname(),emp.getJob(),new java.sql.Date(emp.getBrith().getTime()),emp.getSal(),emp.getDeptno(),emp.getPhoto());
    }

    @Override
    public int sign(int username, int password) throws SQLException {
        String sql="select count(*) from users where username=? and  password=?";
        Users query = qr.query(sql, new BeanHandler<Users>(Users.class), username, password);
        if (query!=null){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int exit(int username) throws SQLException {
        String sql="select count(*) from users where username=?";
        Users query = qr.query(sql, new BeanHandler<Users>(Users.class), username);
        if (query!=null){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int zhuce(int username, int password) throws SQLException {
        String sql="insert into users values(?,?)";
        int update = qr.update(sql, username, password);
        if (update==1){
            return 1;
        }else {
            return 0;

        }

    }


    @Override
    public List<Emp> findAll(Emp sa,int pageNum,int pageSize) throws SQLException {
        StringBuffer sf = new StringBuffer("select e.*,d.dname from em e,dep d where e.DEPTNO=d.DEPTNO and 1=1 ");
        if(sa.getEname()!=null  && !"".equals(sa.getEname())){
            sf.append(" and e.ename   like  '%"+sa.getEname()+"%'");
        }
        if(sa.getDate1()!=null ){
            sf.append(" and  e.brith>='"+ new java.sql.Date(sa.getDate1().getTime())+"'" );
        }
        if(sa.getDate2()!=null){
            sf.append(" and  e.brith<='"+ new java.sql.Date(sa.getDate2().getTime())+"'");
        }
        if (sa.getDid()!=0){
            sf.append(" and d.deptno='"+sa.getDid()+"'");
        }
        //追加limit   limit  3,3
        sf.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
        System.out.println(sf.toString());
        try {
            //BeanListHandler:把数据转成list
            return qr.query(sf.toString(), new BeanListHandler<Emp>(Emp.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public List<Emp> findAll() throws SQLException {
        String sql="select e.*,d.dname from em e,dep d where e.DEPTNO=d.DEPTNO ";
        return qr.query(sql,new BeanListHandler<Emp>(Emp.class));
    }

    @Override
    public int add(Emp st) throws SQLException {
        String sql="insert into em values(?,?,?,?,?,?)";
        return qr.update(sql,st.getEmpno(),st.getEname(),st.getJob(),
                st.getBrith(),st.getSal(),st.getDeptno());
    }

    @Override
    public Emp findOne(int empno) throws SQLException {
        String sql="select e.*,d.dname from em e,dep d where e.deptno=d.deptno  and empno=?";
        return qr.query(sql,new BeanHandler<Emp>(Emp.class),empno);
    }


    @Override
    public int del(int empno) throws SQLException {
        String sql="delete from em where empno=?";
        return qr.update(sql,empno);
    }

    @Override
    public int update(Emp st) throws SQLException {
        String sql="update em set ename=?,job=?" +
                ",brith=?,sal=?,deptno=?,photo=? where empno=?";
        return qr.update(sql,st.getEname(),st.getJob(),st.getBrith(),st.getSal(),st.getDeptno(),st.getPhoto(),st.getEmpno());
    }

    @Override
    public Emp findlike(String ename) throws SQLException {
        String sql="select * from em where ename like ?";
        String s="%"+ename+"%";
        return qr.query(sql,new BeanHandler<Emp>(Emp.class),s);
    }

    @Override
    public List<Dept> findDept() throws SQLException {
        String sql="select * from dep";
        return qr.query(sql,new BeanListHandler<Dept>(Dept.class));
    }

    @Override
    public int dels(String[] ids) throws SQLException {
        String sql="delete from em where empno in ( ";
        StringBuffer sf = new StringBuffer(sql);
        for (int i = 0; i < ids.length; i++) {//1,2,3,5,6
            //根据i的值
            if (i == ids.length - 1) {
                sf.append(ids[i] + ")");
            } else {
                sf.append(ids[i] + ",");
            }
        }
        System.out.println(sf.toString());
        return qr.update(sf.toString());
    }



}
