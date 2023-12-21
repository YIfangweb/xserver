package com.x.xserver.pojo;

import org.springframework.web.multipart.MultipartFile;

public class paper {
    public Integer pid;
    public String unique;
    public String ptitle;
    public String pauthor;
    public String pteacher;
    public String pgrade;
    public String patatus;
    public String pdata;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPauthor() {
        return pauthor;
    }

    public void setPauthor(String pauthor) {
        this.pauthor = pauthor;
    }

    public String getPteacher() {
        return pteacher;
    }

    public void setPteacher(String pteacher) {
        this.pteacher = pteacher;
    }

    public String getPgrade() {
        return pgrade;
    }

    public void setPgrade(String pgrade) {
        this.pgrade = pgrade;
    }

    public String getPatatus() {
        return patatus;
    }

    public void setPatatus(String patatus) {
        this.patatus = patatus;
    }

    public String getPdata() {
        return pdata;
    }

    public void setPdata(String pdata) {
        this.pdata = pdata;
    }

    public paper(Integer pid, String unique, String ptitle, String pauthor, String pteacher, String pgrade, String patatus, String pdata) {
        this.pid = pid;
        this.unique = unique;
        this.ptitle = ptitle;
        this.pauthor = pauthor;
        this.pteacher = pteacher;
        this.pgrade = pgrade;
        this.patatus = patatus;
        this.pdata = pdata;
    }
}
