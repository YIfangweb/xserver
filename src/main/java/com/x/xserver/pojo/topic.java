package com.x.xserver.pojo;

public class topic {
    public Integer topid;
    public String toptitle;
    public String topdescript;
    public String topauthor;
    public String toplist;

    public Integer getTopid() {
        return topid;
    }

    public void setTopid(Integer topid) {
        this.topid = topid;
    }

    public String getToptitle() {
        return toptitle;
    }

    public void setToptitle(String toptitle) {
        this.toptitle = toptitle;
    }

    public String getTopdescript() {
        return topdescript;
    }

    public void setTopdescript(String topdescript) {
        this.topdescript = topdescript;
    }

    public String getTopauthor() {
        return topauthor;
    }

    public void setTopauthor(String topauthor) {
        this.topauthor = topauthor;
    }

    public String getToplist() {
        return toplist;
    }

    public void setToplist(String toplist) {
        this.toplist = toplist;
    }

    public topic(Integer topid, String toptitle, String topdescript, String topauthor, String toplist) {
        this.topid = topid;
        this.toptitle = toptitle;
        this.topdescript = topdescript;
        this.topauthor = topauthor;
        this.toplist = toplist;
    }
}
