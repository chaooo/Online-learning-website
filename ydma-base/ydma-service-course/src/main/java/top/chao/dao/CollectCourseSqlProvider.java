package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.CollectCourse;

public class CollectCourseSqlProvider {

    /**
     * table： collect_course
     */
    public String insertSelective(CollectCourse record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("collect_course");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getCourse_id() != null) {
            sql.VALUES("course_id", "#{course_id,jdbcType=INTEGER}");
        }
        
        if (record.getCollect_time() != null) {
            sql.VALUES("collect_time", "#{collect_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * table： collect_course
     */
    public String updateByPrimaryKeySelective(CollectCourse record) {
        SQL sql = new SQL();
        sql.UPDATE("collect_course");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getCourse_id() != null) {
            sql.SET("course_id = #{course_id,jdbcType=INTEGER}");
        }
        
        if (record.getCollect_time() != null) {
            sql.SET("collect_time = #{collect_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}