package com.x.xserver.mapper;

import com.x.xserver.pojo.teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.x.xserver.pojo.student;

@Mapper
public interface systemMapper {

    /**
     * 根据学生账号查询
     * @param  sid
     * @return student
     */
    @Select("select * from x_students where sid = #{sid}")
    student findBySid(Integer sid);

    /**
     * 根据教师账号查询
     * @param  tid
     * @return teacher
     */
    @Select("select * from x_teacher where tid = #{tid}")
    teacher findByTid(Integer tid);

    /**
     * 根据教师唯一识别码查询
     * @param  tunique
     * @return teacher
     */
    @Select("select * from x_teacher where tunique = #{tunique}")
    teacher findByTunique(String tunique);

    /**
     * 根据学生唯一识别码查询
     * @param  sunique
     * @return student
     */
    @Select("select * from x_students where sunique = #{sunique}")
    student findBySunique(String sunique);

    /**
     * 学生登录接口
     * @param  sid
     * @param  spassword
     * @return students
     */
    @Select("select * from x_students where sid = #{sid} and spassword = #{spassword}")
    student sloginByidBypassword(Integer sid, String spassword);

    /**
     * 教师登录接口
     * @param  tid
     * @param  tpassword
     * @return teacher
     */
    @Select("select * from x_teacher where tid = #{tid} and tpassword = #{tpassword}")
    teacher tloginByidBypassword(Integer tid, String tpassword);

    /**
     * 获取学生标识码接口
     * @return student
     */
    @Select("select * from x_students where sunique = #{sunique}")
    student checkSunique(String sunique);

    /**
     * 获取教师标识码接口
     * @return teacher
     */
    @Select("select * from x_teacher where tunique = #{tunique}")
    teacher checkTunique(String tunique);

    /**
     * 学生注册接口
     * @return Integer
     */
    @Insert("insert into x_students(sid, sname, spassword, sclass, syear, sunique) values (#{sid},#{sname},#{spassword},#{sclass},#{syear},#{sunique})")
    Integer onStudentSignIn(Integer sid, String sname, String spassword, String sclass, Integer syear, String sunique);

    /**
     * 教师注册接口
     * @return Integer
     */
    @Insert("insert into x_teacher(tid, tname, tpassword, tunique)  values (#{tid},#{tname},#{tpassword},#{tunique})")
    Integer onTeacherSignIn(Integer tid, String tname, String tpassword, String tunique);

}
