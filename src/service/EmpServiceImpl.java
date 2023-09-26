package service;

import dao.ScDao;
import dao.ScDaoimpl;
import pojo.Emp;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class EmpServiceImpl implements EmpService
{
  private ScDao scDao=  new ScDaoimpl();

    public List<Emp> findEmps(Emp vo,int  pageNum,int  pageSize) throws SQLException, ParseException {
        return scDao.findAll(vo,pageNum,pageSize);
    }

    @Override
    public int getCount(Emp vo) {
        return scDao.getCount(vo);
    }

    @Override
    public int dels(String[] ids) throws SQLException {
        return scDao.dels(ids);
    }

    @Override
    public int sign(int username, int password) throws SQLException {
        return scDao.sign(username,password);
    }

    @Override
    public int zhuce(int username, int password) throws SQLException {
        return scDao.zhuce(username,password);
    }
}
