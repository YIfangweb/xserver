package com.x.xserver.mapper;

import com.x.xserver.pojo.teacher;
import com.x.xserver.pojo.xclass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.x.xserver.pojo.student;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
    @Insert("insert into x_students(sid, sname, spassword, sclassname, sunique) values (#{sid},#{sname},#{spassword},#{sclassname},#{sunique})")
    Integer onStudentSignIn(Integer sid, String sname, String spassword, String sclassname, String sunique);

    /**
     * 教师注册接口
     * @return Integer
     */
    @Insert("insert into x_teacher(tid, tname, tpassword, tunique)  values (#{tid},#{tname},#{tpassword},#{tunique})")
    Integer onTeacherSignIn(Integer tid, String tname, String tpassword, String tunique);

    /**
     * 学生信息修改接口
     * @return Integer
     */
    @Update("update x_students set  spassword = #{spassword} where sid = #{sid}")
    Integer updateStudent(Integer sid,  String spassword);

    /**
     * 获取全部班级
     * @return list
     */
    @Select("select * from x_class")
    List<xclass> getAllClass();
}
