package com.x.xserver.controller;

import com.x.xserver.pojo.*;
import com.x.xserver.service.systemService;
import com.x.xserver.unitl.systemUnitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class systemController {

    @Autowired
    private systemService systemService;

    @PostMapping("/slogin")
    public loginMsg sloginByidBypassword(@RequestParam("sid") Integer sid, @RequestParam("spassword") String spassword){
        student student =  systemService.sloginByidBypassword(sid,spassword);
        if(student!=null){
            loginMsg loginMsg = new loginMsg(
                    student,"success"
            );
            return loginMsg;
        }else {
            return null;
        }
    }

    @PostMapping("/tlogin")
    public loginMsg tloginByidBypassword(@RequestParam("tid") Integer tid, @RequestParam("tpassword") String tpassword){
        teacher teacher =  systemService.tloginByidBypassword(tid,tpassword);
        if(teacher!=null){
            return new loginMsg(
                    teacher,"success"
            );
        }else {
            return null;
        }

    }

    @PostMapping("/onsSignIn")
    @Transactional
    public signInMsg onStudentSignIn(@RequestParam("sname")String sname,
                                     @RequestParam("spassword")String spassword,
                                     @RequestParam("sclassname")String sclassname) {
        systemUnitl systemUnitl = new systemUnitl();
        Integer sid;
        Integer sunique;
        student bySid;
        do {
            sid = systemUnitl.getSid();
            bySid = systemService.findBySid(sid);
        } while (bySid != null);
        do {
            sunique = systemUnitl.getSunique();
            bySid = systemService.findBySunique(String.valueOf(sunique));
        } while (bySid != null);
        systemService.onStudentSignIn(sid, sname, spassword, sclassname, "s" + sunique);
        if(systemService.findBySid(sid)!=null){
            return new signInMsg(systemService.findBySid(sid),"success");
        }else {
            return new signInMsg(null,"error");
        }
    }

    @PostMapping("/ontSignIn")
    @Transactional
    public signInMsg onTeacherSignIn(@RequestParam("tname")String tname,
                                     @RequestParam("tpassword")String tpassword) {
        systemUnitl systemUnitl = new systemUnitl();
        Integer tid;
        Integer tunique;
        teacher byTid;
        do {
            tid = systemUnitl.getTid();
            byTid = systemService.findByTid(tid);
        } while (byTid != null);
        do {
            tunique = systemUnitl.getTunique();
            byTid = systemService.findByTunique(String.valueOf(tunique));
        } while (byTid != null);
        systemService.onTeacherSignIn(tid,tname,tpassword, "t" + tunique);
        if(systemService.findByTid(tid)!=null){
            return new signInMsg(systemService.findByTid(tid),"success");
        }else {
            return new signInMsg(null,"error");
        }
    }

    @PostMapping("/updateStudent")
    @Transactional
    public Integer updateStudent(@RequestParam("sid")Integer sid,
                                 @RequestParam("spassword")String spassword) {
        return systemService.updateStudent(sid,spassword);
    }

    @GetMapping("/getClassName")
    public List<xclass> getClassName() {
        return systemService.getAllClass();
    }

    @GetMapping("/getPaperList")
    public List<paper> getPaperList(@RequestParam("unique")String unique) {
        return systemService.getPaperList(unique);
    }

    @PostMapping("/submitPaper")
    @Transactional
    public Integer insertPaper(@RequestParam("sunique")String sunique,
                              @RequestParam("ptitle")String ptitle,
                              @RequestParam("pdata") String pdata) {
        systemUnitl systemUnitl = new systemUnitl();
        Integer pid;
        paper byPid;
        do {
            pid = systemUnitl.getPid();
            byPid = systemService.findByPid(pid);
        } while (byPid != null);
        student student = systemService.findBySunique(sunique);
        return systemService.addPaper(pid,student.sunique,ptitle,student.sname,pdata);
    }

    @PostMapping("/submitPaperBt")
    @Transactional
    public Integer insertPaperBt(@RequestParam("tunique")String tunique,
                               @RequestParam("ptitle")String ptitle,
                               @RequestParam("pdata") String pdata) {
        systemUnitl systemUnitl = new systemUnitl();
        Integer pid;
        paper byPid;
        do {
            pid = systemUnitl.getPid();
            byPid = systemService.findByPid(pid);
        } while (byPid != null);
        teacher teacher = systemService.findByTunique(tunique);
        return systemService.addPaper(pid,teacher.tunique,ptitle,teacher.tname,pdata);
    }

    @PostMapping ("/getPaper")
    public paper  getPaper(@RequestParam("pid")String pid){
        return systemService.getPaper(pid);
    }

    @PostMapping("/updatePaper")
    @Transactional
    public Integer updatePaper(@RequestParam("pid")String pid,
                               @RequestParam("ptitle")String ptitle,
                               @RequestParam("pdata")String pdata){
        return systemService.updatePaper(Integer.parseInt(pid),ptitle,pdata);
    }

    @PostMapping("/searchPaper")
    @Transactional
    public List<paper> searchPaper(@RequestParam("unique")String sunique,
                                  @RequestParam("searchData")String searchData){
        return systemService.getPaperListBySearch(sunique,searchData);
    }

    @PostMapping("/deletePaper")
    @Transactional
    public Integer deletePaper(@RequestParam("pid")String pid,@RequestParam("sunique")String sunique){
        return systemService.deletePaper(Integer.parseInt(pid),sunique);
    }

    @PostMapping("/updateteacher")
    @Transactional
    public Integer updateteacher(@RequestParam("tid")Integer tid,
                                 @RequestParam("tpassword")String tpassword) {
        return systemService.updateteacher(tid,tpassword);
    }

    @PostMapping("/deletePaperBt")
    @Transactional
    public Integer deletePaperBt(@RequestParam("pid")String pid,@RequestParam("unique")String tunique){
        return systemService.deletePaper(Integer.parseInt(pid),tunique);
    }

    @PostMapping("/getTopic")
    public List<topic> getTopicByunique(@RequestParam("unique")String unique){
        String teacher = systemService.findByTunique(unique).tname;
        return systemService.getTopicList(teacher);
    }

    @PostMapping("/addTopic")
    @Transactional
    public Integer addTopic(@RequestParam("unique")String tunique,
                           @RequestParam("title")String title,
                           @RequestParam("description")String description){
        systemUnitl systemUnitl = new systemUnitl();
        Integer topid;
        topic bytopid;
        do {
            topid = systemUnitl.getTopid();
            bytopid = systemService.findByTopid(topid);
        } while (bytopid != null);
        teacher teacher = systemService.findByTunique(tunique);
        return systemService.addTopic(topid,title,teacher.tname,description);
    }

    @PostMapping("/gettopid")
    public topic gettopid(@RequestParam("topid")String topid){
        return systemService.findBytopid(Integer.valueOf(topid));
    }

    @PostMapping("/updateTopic")
    @Transactional
    public Integer updateTopic(@RequestParam("topid")String topid,
                              @RequestParam("title")String title,
                              @RequestParam("description")String description){
        return systemService.updateTopic(Integer.valueOf(topid),title,description);
    }

    @PostMapping("/deleteTopic")
    @Transactional
    public Integer deleteTopic(@RequestParam("topid")String topid,@RequestParam("unique")String unique){
        return systemService.deleteTopic(Integer.valueOf(topid),systemService.findByTunique(unique).tname);
    }

    @PostMapping("/searchTopic")
    public List<topic> searchTopic(@RequestParam("searchData")String searchData){
        return systemService.getTopicListBySearch(searchData);
    }

    @PostMapping("/getClasses")
    public List<xclass> getClasses(@RequestParam("unique")String unique){
        return systemService.findByUnique(unique);
    }

    @PostMapping("/updateStudentbyT")
    @Transactional
    public Integer updateStudentbyT(@RequestParam("id")Integer id,
                                    @RequestParam("name")String name,
                                    @RequestParam("classname")String classname,
                                    @RequestParam("sunique")String sunique) {
        return systemService.updateStudentBySunique(id,name,classname,sunique);
    }

    @PostMapping("/getStudentbyC")
    public List<student> getStudentbyC(@RequestParam("classname")String sclassname){
        return systemService.getStudentBySclassname(sclassname);
    }

    @PostMapping("/updatePaperbyT")
    @Transactional
    public Integer updatePaperScore(@RequestParam("id")Integer id,
                                   @RequestParam("grade")Integer grade,
                                   @RequestParam("unique")String unique){
        return systemService.updatePaperScore(id,grade,systemService.findByTunique(unique).tname);
    }

    @PostMapping("/getPaperbyT")
    public List<paper> getPaperbyT(@RequestParam("classname") String classname){
        List<student> studentList = systemService.getStudentBySclassname(classname);
        if (studentList.isEmpty()){
            return null;
        }else {
            List<paper> paperList = new ArrayList<>();
            List<paper> paperListS = new ArrayList<>();
            for (student value : studentList) {
                paperListS = systemService.getPaperByUnique(value.sunique);
                paperList.addAll(paperListS);
            }
            return paperList;
        }
    }
    @GetMapping("/getTopicList")
    public List<topic> getTopicList(){
        return systemService.getAllTopic();
    }
}
