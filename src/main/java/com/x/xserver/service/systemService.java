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

    List<paper> getPaperListBySearch (String sunique, String searchData);

    Integer deletePaper(Integer pid, String unique);

    Integer updateteacher(Integer tid,  String tpassword);

    List<topic> getTopicList(String topauthor);

    topic findByTopid(Integer topid);

    Integer addTopic(Integer topid, String title,String topauthor, String description);

    topic findBytopid(Integer topid);

    Integer updateTopic(Integer topid, String title, String description);

    Integer deleteTopic(Integer topid, String topauthor);

    List<topic> getTopicListBySearch(String searchData);

    List<xclass> findByUnique(String unique);

    Integer updateStudentBySunique(Integer id, String sname, String sclassname, String sunique);

    List<student> getStudentBySclassname(String sclassname);

    Integer updatePaperScore(Integer pid, Integer pgrade, String pteacher);

    List<paper> getPaperByUnique (String unique);

    List<topic> getAllTopic();
}
