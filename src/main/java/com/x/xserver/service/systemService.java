package com.x.xserver.service;

import com.x.xserver.pojo.student;
import com.x.xserver.pojo.teacher;

public interface systemService {


    public student findBySid(Integer sid);

    public teacher findByTid(Integer tid);

    public student findBySunique(String sunique);

    public teacher findByTunique(String tunique);

    public student sloginByidBypassword(Integer sid,String spassword);

    public teacher tloginByidBypassword(Integer tid, String tpassword);

    public student checkSunique(String sunique);

    public teacher checkTunique(String tunique);

    public Integer onStudentSignIn(Integer sid, String sname, String spassword , String sclass , Integer syear, String sunique);

    public Integer onTeacherSignIn(Integer tid, String tname, String tpassword , String tunique);

    public Integer updateStudent(Integer sid, String spassword);
}
