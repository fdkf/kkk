package pojo;

import java.util.Date;
import java.util.List;

public class Emp  {
private  int empno;
private  String ename;
    private  String job;
    private Date brith;
    private  int sal;
    private  int deptno;
    private String dname;
    private Date date1;
    private   String  photo;
    private Date date2;
    private int did;
    //(emptno,ename,job,brith,sal,deptno,photo)

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public Emp(String ename, Date date1, Date date2, int did) {
        this.ename = ename;
        this.date1 = date1;
        this.date2 = date2;
        this.did = did;
    }



    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }



    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Emp(int empno, String ename, String job, Date brith, int sal, int deptno, String photo) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.brith = brith;
        this.sal = sal;
        this.deptno = deptno;
        this.photo = photo;
    }

    public Emp(int empno, String ename, String job, Date brith, int sal, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.brith = brith;
        this.sal = sal;
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", brith=" + brith +
                ", sal=" + sal +
                ", deptno=" + deptno +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public Emp() {
    }
}
