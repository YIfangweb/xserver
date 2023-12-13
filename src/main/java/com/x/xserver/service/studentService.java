package com.x.xserver.service;

import com.x.xserver.pojo.student;
import org.springframework.stereotype.Service;

public interface studentService {

    public student findById(Integer sid);

    public student loginByidBypassword(Integer sid,String spassword);
}
