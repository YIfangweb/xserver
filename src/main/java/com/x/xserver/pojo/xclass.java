package com.x.xserver.pojo;

public class xclass {
    public String classname;

    public String tunique;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTunique() {
        return tunique;
    }

    public void setTunique(String tunique) {
        this.tunique = tunique;
    }

    public xclass(String classname, String tunique) {
        this.classname = classname;
        this.tunique = tunique;
    }
}
