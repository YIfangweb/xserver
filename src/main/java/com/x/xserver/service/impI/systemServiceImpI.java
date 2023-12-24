package com.x.xserver.service.impI;

import com.x.xserver.mapper.systemMapper;
import com.x.xserver.pojo.*;
import com.x.xserver.service.systemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public Integer onStudentSignIn(Integer sid, String sname, String spassword, String sclassname, String sunique) {
        return systemMapper.onStudentSignIn(sid,sname,spassword,sclassname,sunique);
    }

    @Override
    public Integer onTeacherSignIn(Integer tid, String tname, String tpassword, String tunique) {
        return systemMapper.onTeacherSignIn(tid,tname,tpassword,tunique);
    }

    @Override
    public Integer updateStudent(Integer sid, String spassword) {
        return systemMapper.updateStudent(sid,spassword);
    }

    @Override
    public List<xclass> getAllClass() {
        return systemMapper.getAllClass();
    }

    @Override
    public List<paper> getPaperList(String unique) {
        return systemMapper.getPaperList(unique);
    }

    @Override
    public Integer addPaper(Integer pid, String unique, String ptitle, String pauthor, String pdata) {
        return systemMapper.addPaper(pid,unique,ptitle,pauthor,pdata);
    }

    @Override
    public paper findByPid(Integer pid) {
        return systemMapper.findByPid(String.valueOf(pid));
    }

    @Override
    public paper getPaper(String pid) {
        return systemMapper.findByPid(pid);
    }

    @Override
    public Integer updatePaper(Integer pid, String ptitle, String pdata) {
        return systemMapper.updatePaper(pid,ptitle,pdata);
    }

    @Override
    public List<paper> getPaperListBySearch(String sunique, String searchData) {
        return systemMapper.getPaperListBySearch(sunique,searchData);
    }

    @Override
    public Integer deletePaper(Integer pid, String unique) {
        return systemMapper.deletePaper(pid,unique);
    }

    @Override
    public Integer updateteacher(Integer tid, String tpassword) {
        return systemMapper.updateteacher(tid,tpassword);
    }

    @Override
    public List<topic> getTopicList(String topauthor) {
        return systemMapper.getTopicList(topauthor);
    }

    @Override
    public topic findByTopid(Integer topid) {
        return systemMapper.findByTopid(topid);
    }

    @Override
    public Integer addTopic(Integer topid, String title, String topauthor, String description) {
        return systemMapper.addTopic(topid,title,topauthor,description);
    }

    @Override
    public topic findBytopid(Integer topid) {
        return systemMapper.findByTopid(topid);
    }

    @Override
    public Integer updateTopic(Integer topid, String title, String description) {
        return systemMapper.updateTopic(topid,title,description);
    }

    @Override
    public Integer deleteTopic(Integer topid, String topauthor) {
        return systemMapper.deleteTopic(topid,topauthor);
    }

    @Override
    public List<topic> getTopicListBySearch(String searchData) {
        return systemMapper.getTopicListBySearch(searchData);
    }


}
