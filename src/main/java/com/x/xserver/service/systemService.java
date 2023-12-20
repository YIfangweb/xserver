package com.x.xserver.service;

import com.x.xserver.pojo.*;

import java.util.List;

public interface systemService {


    public student findBySid(Integer sid);

    public teacher findByTid(Integer tid);

    public student findBySunique(String sunique);

    public teacher findByTunique(String tunique);

    public student sloginByidBypassword(Integer sid,String spassword);

    public teacher tloginByidBypassword(Integer tid, String tpassword);

    public student checkSunique(String sunique);

    public teacher checkTunique(String tunique);

    Integer onStudentSignIn(Integer sid, String sname, String spassword, String sclassname, String sunique);

    public Integer onTeacherSignIn(Integer tid, String tname, String tpassword , String tunique);

    public Integer updateStudent(Integer sid, String spassword);

    List<xclass> getAllClass();

    List<paper> getPaperList(String unique);

    Integer addPaper(Integer pid, String unique, String ptitle, String pauthor, String pdata);

    paper findByPid(Integer pid);

    paper getPaper(String pid);

    Integer updatePaper( Integer pid,String ptitle, String pdata);
}
