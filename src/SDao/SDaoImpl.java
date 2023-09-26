package SDao;

import Spojo.Shang;
import duil.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Emp;
import pojo.Users;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SDaoImpl implements SDao{
    QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public int getCount(Shang vo) {
        StringBuffer sf = new StringBuffer("select  count(*) from  goods_type  where   1=1 ");
        if(vo.getTname()!=null  && !"".equals(vo.getTname())){
            sf.append(" and tname   like  '%"+vo.getTname()+"%'");
        }
        if(vo.getDate1()!=null ){
            sf.append(" and  tdate>='"+ new java.sql.Date(vo.getDate1().getTime())+"'" );
        }
        if(vo.getDate2()!=null ){
            sf.append(" and  tdate<='"+ new java.sql.Date(vo.getDate2().getTime())+"'" );
        }
        try {
            return  qr.query(sf.toString(), new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public int dels(String[] ids) throws SQLException {
     String sql="delete from goods_type where tid in( ";
        StringBuffer sf = new StringBuffer(sql);
        for (int i = 0; i <ids.length ; i++) {
            if (i == ids.length - 1) {
                sf.append(ids[i] + ")");
            } else {
                sf.append(ids[i] + ",");
            }
        }
        System.out.println(sf.toString());
        return qr.update(sf.toString());
    }

    @Override
    public Users login(String username, String password) {
        String sql = "select *   from   users  where   username='" + username + "' and  password='" + password + "'";
        try {
            return qr.query(sql, new BeanHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Shang findOne(int tid) throws SQLException {
        String sql="select * from goods_type where tid=?";
        return qr.query(sql,new BeanHandler<Shang>(Shang.class),tid);
    }


    @Override
    public List<Shang> findAll(String tname,Date date1,Date date2,int pageNum,int pageSize) throws SQLException {
        String sql="select * from goods_type where 1=1 ";
        StringBuffer sf = new StringBuffer(sql);
        if(tname!=null  && !"".equals(tname)){
            sf.append(" and tname   like  '%"+tname+"%'");
        }
        if(date1!=null ){
            sf.append(" and  tdate>='"+ new java.sql.Date(date1.getTime())+"'" );
        }
        if(date2!=null ){
            sf.append(" and  tdate<='"+ new java.sql.Date(date2.getTime())+"'" );
        }
        sf.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
        System.out.println(sf.toString());
        return qr.query(sf.toString(),new BeanListHandler<Shang>(Shang.class));
    }

    @Override
    public int alter(Shang s) throws SQLException {
        String sql="update goods_type set tname=?,timg=?,tdate=? where tid=?";
        return qr.update(sql,s.getTname(),s.getTimg(),new java.sql.Date(s.getTdate().getTime()),s.getTid());
    }
}
