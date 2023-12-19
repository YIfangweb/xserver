package com.x.xserver.pojo;

public class loginMsg {
    public Object object;

    public String msg;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public loginMsg(Object object, String msg) {
        this.object = object;
        this.msg = msg;
    }
}
