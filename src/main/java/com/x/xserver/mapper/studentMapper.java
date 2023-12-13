package com.x.xserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.x.xserver.pojo.student;

@Mapper
public interface studentMapper {

    /**
     * 根据学生ID查询
     * @param  sid
     * @return students
     */
    @Select("select * from x_students where sid = #{sid}")
    public student findById(Integer sid);

    /**
     * 登录接口
     * @param  sid
     * @param  spassword
     * @return students
     */
    @Select("select * from x_students where sid = #{sid}")
    public student loginByidBypassword(Integer sid,String spassword);
}
