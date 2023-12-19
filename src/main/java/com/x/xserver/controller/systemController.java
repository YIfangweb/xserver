package com.x.xserver.controller;

import com.x.xserver.pojo.*;
import com.x.xserver.service.systemService;
import com.x.xserver.unitl.systemUnitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public List<paper> getPaperList() {
        return systemService.getPaperList();
    }
}
