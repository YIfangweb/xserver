package com.x.xserver.service.impI;

import com.x.xserver.pojo.student;
import com.x.xserver.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImpI implements studentService {

    @Autowired
    private com.x.xserver.mapper.studentMapper studentMapper;

    @Override
    public student findById(Integer sid) {
        return studentMapper.findById(sid);
    }

    @Override
    public student loginByidBypassword(Integer sid, String spassword) {
        return studentMapper.loginByidBypassword(sid,spassword);
    }
}
