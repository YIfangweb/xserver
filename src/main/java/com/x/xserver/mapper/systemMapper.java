package com.x.xserver.mapper;

import com.x.xserver.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 获取全部论文
     * @return list
     */
    @Select("select * from x_paper where `unique` = #{unique}")
    List<paper> getPaperList(String unique);

    /**
     * 插入论文
     * @return Integer
     */
    @Insert("insert into x_paper(pid, `unique`, ptitle, pauthor, pdata) values(#{pid},#{unique},#{ptitle},#{pauthor},#{pdata})")
    Integer addPaper(Integer pid, String unique, String ptitle, String pauthor, String pdata);

    /**
     * 根据论文id查询论文
     * @return paper
     */
    @Select("select * from x_paper where pid = #{pid}")
    paper findByPid(String pid);

    /**
     * 根据论文id更新论文标题和论文数据
     * @return Integer
     */
    @Update("update x_paper set ptitle = #{ptitle}, pdata = #{pdata} where pid = #{pid}")
    Integer updatePaper( Integer pid,String ptitle, String pdata);

    @Select("select * from x_paper where `unique` = #{sunique} and ptitle like concat('%',#{searchData},'%')")
    List<paper> getPaperListBySearch (String sunique, String searchData);

    @Update("delete from x_paper where pid = #{pid} and `unique` = #{unique}")
    Integer deletePaper(Integer pid, String unique);

    /**
     * 老师修改接口
     * @return Integer
     */
    @Update("update x_teacher set  tpassword = #{tpassword} where tid = #{tid}")
    Integer updateteacher(Integer tid,  String tpassword);

    /**
     * 获取全部题目
     * @return list
     */
    @Select("select * from x_topic where `topauthor` = #{topauthor}")
    List<topic> getTopicList(String topauthor);

    /**
     * 根据topid查询题目
     * @return topic
     */
    @Select("select * from x_topic where topid = #{topid}")
    topic findByTopid(Integer topid);

    /**
     * 插入新课题
     * @return Integer
     */
    @Insert("insert into x_topic(topid,toptitle,topauthor,topdescript) values(#{topid},#{title},#{topauthor},#{description})")
    Integer addTopic(Integer topid, String title,String topauthor, String description);

    @Select("select * from x_topic where topid = #{topid}")
    topic findBytopid(Integer topid);

    @Update("update x_topic set toptitle = #{title}, topdescript = #{description} where topid = #{topid}")
    Integer updateTopic(Integer topid, String title, String description);

    @Update("delete from x_topic where topid = #{topid} and topauthor = #{topauthor}")
    Integer deleteTopic(Integer topid, String topauthor);

    @Select("select * from x_topic where toptitle like concat('%',#{searchData},'%')")
    List<topic> getTopicListBySearch(String searchData);
}
