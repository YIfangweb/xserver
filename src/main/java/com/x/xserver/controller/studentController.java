package com.x.xserver.controller;

import com.x.xserver.pojo.student;
import com.x.xserver.pojo.studentloginMsg;
import com.x.xserver.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class studentController {

    @Autowired
    private studentService studentService;

    @RequestMapping("/api/findById")
    public student findById(Integer sid){
        return studentService.findById(sid);
    }

    @RequestMapping("/api/slogin")
    public studentloginMsg loginByidBypassword(@RequestParam("sid") Integer sid, @RequestParam("spassword") String spassword){
        student student =  studentService.loginByidBypassword(sid,spassword);
        if(student!=null){
            studentloginMsg studentloginMsg = new studentloginMsg(
                    student.sid,student.sname,student.spassword,
                    student.sclass,student.syear,2,"success"
            );
            return studentloginMsg;
        }
        return null;
    }
}
