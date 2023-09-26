package service;

import pojo.Emp;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface EmpService {
   List<Emp> findEmps(Emp vo,int  pageNum,int  pageSize) throws SQLException, ParseException;
   int  getCount(Emp vo);
   int dels(String[] ids) throws SQLException;
   int sign(int username,int password) throws SQLException;
   int zhuce(int username,int password) throws SQLException;



}
