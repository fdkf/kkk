package SDao;

import Spojo.Shang;
import pojo.Users;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface SDao {
    Shang findOne (int tid) throws SQLException;
    List<Shang> findAll(String tname,Date date1,Date date2,int pageNum,int pageSize) throws SQLException;
    int alter(Shang s) throws SQLException;
    int getCount(Shang vo);
    int dels(String[] ids) throws SQLException;
    Users login(String username, String password);

}
