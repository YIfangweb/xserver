package com.x.xserver.controller;

import com.x.xserver.pojo.student;
import com.x.xserver.pojo.studentloginMsg;
import com.x.xserver.pojo.teacher;
import com.x.xserver.pojo.teacherloginMsg;
import com.x.xserver.service.systemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class systemController {

    @Autowired
    private systemService systemService;

    @RequestMapping("/api/findById")
    public student findById(Integer sid){
        return systemService.findById(sid);
    }

    @RequestMapping("/api/slogin")
    public studentloginMsg sloginByidBypassword(@RequestParam("sid") Integer sid, @RequestParam("spassword") String spassword){
        student student =  systemService.sloginByidBypassword(sid,spassword);
        if(student!=null){
            studentloginMsg studentloginMsg = new studentloginMsg(
                    student.sid,student.sname,student.spassword,
                    student.sclass,student.syear,2,student.sunique,"success"
            );
            return studentloginMsg;
        }else {
            return null;
        }
    }

    @RequestMapping("/api/tlogin")
    public teacherloginMsg tloginByidBypassword(@RequestParam("tid") Integer tid, @RequestParam("tpassword") String tpassword){
        teacher teacher =  systemService.tloginByidBypassword(tid,tpassword);
        if(teacher!=null){
            return new teacherloginMsg(
                    teacher.tid,teacher.tname,teacher.tpassword,
                    teacher.tunique,1,"success"
            );
        }else {
            return null;
        }

    }
}
