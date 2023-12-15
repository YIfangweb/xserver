package com.x.xserver.mapper;

import com.x.xserver.pojo.teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.x.xserver.pojo.student;

@Mapper
public interface systemMapper {

    /**
     * 根据学生ID查询
     * @param  sid
     * @return students
     */
    @Select("select * from x_students where sid = #{sid}")
    public student findById(Integer sid);

    /**
     * 学生登录接口
     * @param  sid
     * @param  spassword
     * @return students
     */
    @Select("select * from x_students where sid = #{sid} and spassword = #{spassword}")
    public student sloginByidBypassword(Integer sid,String spassword);

    /**
     * 教师登录接口
     * @param  tid
     * @param  tpassword
     * @return teacher
     */
    @Select("select * from x_teacher where tid = #{tid} and tpassword = #{tpassword}")
    public teacher tloginByidBypassword(Integer tid, String tpassword);
}
