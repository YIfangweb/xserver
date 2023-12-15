package com.x.xserver.pojo;

public class teacherloginMsg {
    public int tid;
    public String tname;
    public String tpassword;
    public String tunique;
    public int state;

    public String loginMsg;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }

    public teacherloginMsg(int tid, String tname, String tpassword, String tunique, int state, String loginMsg) {
        this.tid = tid;
        this.tname = tname;
        this.tpassword = tpassword;
        this.tunique = tunique;
        this.state = state;
        this.loginMsg = loginMsg;
    }
}
