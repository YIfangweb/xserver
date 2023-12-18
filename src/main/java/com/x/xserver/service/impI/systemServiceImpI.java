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
    public student findBySid(Integer sid) {
        return systemMapper.findBySid(sid);
    }

    @Override
    public teacher findByTid(Integer tid) {
        return systemMapper.findByTid(tid);
    }

    @Override
    public student findBySunique(String sunique) {
        return systemMapper.findBySunique(sunique);
    }

    @Override
    public teacher findByTunique(String tunique) {
        return systemMapper.findByTunique(tunique);
    }

    @Override
    public student sloginByidBypassword(Integer sid, String spassword) {
        return systemMapper.sloginByidBypassword(sid,spassword);
    }

    @Override
    public teacher tloginByidBypassword(Integer tid, String tpassword) {
        return systemMapper.tloginByidBypassword(tid,tpassword);
    }

    @Override
    public student checkSunique(String sunique) {
        return systemMapper.checkSunique(sunique);
    }

    @Override
    public teacher checkTunique(String tunique) {
        return systemMapper.checkTunique(tunique);
    }

    @Override
    public Integer onStudentSignIn(Integer sid, String sname, String spassword, String sclass, Integer syear, String sunique) {
        return systemMapper.onStudentSignIn(sid,sname,spassword,sclass,syear,sunique);
    }

    @Override
    public Integer onTeacherSignIn(Integer tid, String tname, String tpassword, String tunique) {
        return systemMapper.onTeacherSignIn(tid,tname,tpassword,tunique);
    }

    @Override
    public Integer updateStudent(Integer sid, String spassword) {
        return systemMapper.updateStudent(sid,spassword);
    }
}
