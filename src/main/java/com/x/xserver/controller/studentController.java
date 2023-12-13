package com.x.xserver.controller;

import com.x.xserver.pojo.student;
import com.x.xserver.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {

    @Autowired
    private studentService studentService;

    @RequestMapping("/findById")
    public student findById(Integer sid){
        return studentService.findById(sid);
    }

    @RequestMapping("/login")
    public Boolean loginByidBypassword(@RequestParam("sid") Integer sid,@RequestParam("spassword") String spassword){
        student student =  studentService.loginByidBypassword(sid,spassword);
        System.out.println(student);
        return true;
    }
}
