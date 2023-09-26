package dao;

import pojo.Dept;
import pojo.Emp;

import java.sql.SQLException;
import java.util.List;

public interface ScDao {
    List<Emp> findAll(Emp sa,int pageNum,int pageSize) throws SQLException;
    List<Emp> findAll() throws SQLException;
    int add(Emp st) throws SQLException;
    Emp findOne(int empno) throws SQLException;
    int del(int empno) throws SQLException;
    int update(Emp st) throws SQLException;
    Emp findlike(String ename) throws SQLException;
    List<Dept> findDept() throws SQLException;
    int dels(String[] ids) throws SQLException;
    int getCount(Emp vo);
    void addEmp(Emp emp) throws SQLException;
    int sign(int username,int password) throws SQLException;
    int zhuce(int username,int password) throws SQLException;
    int exit(int username) throws SQLException;


}
