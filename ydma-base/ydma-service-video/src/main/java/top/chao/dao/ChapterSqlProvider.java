package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Chapter;

public class ChapterSqlProvider {

    /**
     * the database table chapter
     */
    public String insertSelective(Chapter record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("chapter");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCourse_id() != null) {
            sql.VALUES("course_id", "#{course_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table chapter
     */
    public String updateByPrimaryKeySelective(Chapter record) {
        SQL sql = new SQL();
        sql.UPDATE("chapter");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCourse_id() != null) {
            sql.SET("course_id = #{course_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}