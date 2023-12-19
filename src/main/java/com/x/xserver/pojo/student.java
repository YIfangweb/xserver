package com.x.xserver.pojo;

public class student {
    public int sid;
    public String sname;
    public String spassword;
    public String sclassname;
    public  String sunique;

    public student(int sid, String sname, String spassword, String sclassname, String sunique) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sclassname = sclassname;
        this.sunique = sunique;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSclassname() {
        return sclassname;
    }

    public void setSclassname(String sclassname) {
        this.sclassname = sclassname;
    }

    public String getSunique() {
        return sunique;
    }

    public void setSunique(String sunique) {
        this.sunique = sunique;
    }
}
