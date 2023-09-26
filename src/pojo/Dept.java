package pojo;

public class Dept {
    private int deptno;
    private String dname;
    private int did;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Dept(int deptno, String dname, int did) {
        this.deptno = deptno;
        this.dname = dname;
        this.did = did;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                '}';
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Dept(int deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }

    public Dept() {
    }
}
