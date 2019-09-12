package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Knowledge;

public class KnowledgeSqlProvider {

    /**
     * the database table knowledge
     */
    public String insertSelective(Knowledge record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("knowledge");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject_id() != null) {
            sql.VALUES("subject_id", "#{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getChapter_id() != null) {
            sql.VALUES("chapter_id", "#{chapter_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table knowledge
     */
    public String updateByPrimaryKeySelective(Knowledge record) {
        SQL sql = new SQL();
        sql.UPDATE("knowledge");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject_id() != null) {
            sql.SET("subject_id = #{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getChapter_id() != null) {
            sql.SET("chapter_id = #{chapter_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}