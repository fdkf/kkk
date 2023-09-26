package Spojo;

import java.util.Date;

public class Shang {
    private int tid;
    private String tname;
    private String timg;
    private Date tdate;
    private Date date1;

    public Shang(int tid, String tname, String timg, Date tdate) {
        this.tid = tid;
        this.tname = tname;
        this.timg = timg;
        this.tdate = tdate;
    }

    public Shang(String tname, Date date1, Date date2) {
        this.tname = tname;
        this.date1 = date1;
        this.date2 = date2;
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

    private Date date2;


    public Shang(String tname, String timg, Date tdate) {
        this.tname = tname;
        this.timg = timg;
        this.tdate = tdate;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTimg() {
        return timg;
    }

    public void setTimg(String timg) {
        this.timg = timg;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    @Override
    public String toString() {
        return "Shang{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", timg='" + timg + '\'' +
                ", tdate=" + tdate +
                '}';
    }

    public Shang(String tname, String timg) {
        this.tname = tname;
        this.timg = timg;
    }

    public Shang() {
    }
}
