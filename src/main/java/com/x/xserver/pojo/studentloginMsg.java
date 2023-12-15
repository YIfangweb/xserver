package com.x.xserver.pojo;

public class studentloginMsg {
    public int sid;
    public String sname;
    public String spassword;
    public String sclass;
    public int syear;
    public int state;

    public String sunique;

    public String loginMsg;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSunique() {
        return sunique;
    }

    public void setSunique(String sunique) {
        this.sunique = sunique;
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }

    public studentloginMsg(int sid, String sname, String spassword, String sclass, int syear, int state, String sunique, String loginMsg) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sclass = sclass;
        this.syear = syear;
        this.state = state;
        this.sunique = sunique;
        this.loginMsg = loginMsg;
    }
}
