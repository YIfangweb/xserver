package com.x.xserver.pojo;

public class student {
    public int sid;
    public String sname;
    public String spassword;
    public String sclass;
    public int syear;

    public student(int sid, String sname, String spassword, String sclass, int syear) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sclass = sclass;
        this.syear = syear;
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

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public int getSyear() {
        return syear;
    }

    public void setSyear(int syear) {
        this.syear = syear;
    }
}
