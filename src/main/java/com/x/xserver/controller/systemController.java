package com.x.xserver.controller;

import com.x.xserver.pojo.*;
import com.x.xserver.service.systemService;
import com.x.xserver.unitl.systemUnitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
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
}
