package com.x.xserver.pojo;

public class teacher {
    public int tid;
    public String tname;
    public String tpassword;
    public String tunique;

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

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTunique() {
        return tunique;
    }

    public void setTunique(String tunique) {
        this.tunique = tunique;
    }

    public teacher(int tid, String tname, String tpassword, String tunique) {
        this.tid = tid;
        this.tname = tname;
        this.tpassword = tpassword;
        this.tunique = tunique;
    }
}
