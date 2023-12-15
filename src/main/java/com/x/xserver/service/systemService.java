package com.x.xserver.service;

import com.x.xserver.pojo.student;
import com.x.xserver.pojo.teacher;

public interface systemService {

    public student findById(Integer sid);

    public student sloginByidBypassword(Integer sid,String spassword);

    public teacher tloginByidBypassword(Integer tid, String tpassword);
}
