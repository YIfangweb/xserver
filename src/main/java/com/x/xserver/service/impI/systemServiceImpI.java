package com.x.xserver.service.impI;

import com.x.xserver.mapper.systemMapper;
import com.x.xserver.pojo.student;
import com.x.xserver.pojo.teacher;
import com.x.xserver.service.systemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class systemServiceImpI implements systemService {

    @Autowired
    private systemMapper systemMapper;

    @Override
    public student findById(Integer sid) {
        return systemMapper.findById(sid);
    }

    @Override
    public student sloginByidBypassword(Integer sid, String spassword) {
        return systemMapper.sloginByidBypassword(sid,spassword);
    }

    @Override
    public teacher tloginByidBypassword(Integer tid, String tpassword) {
        return systemMapper.tloginByidBypassword(tid,tpassword);
    }
}
