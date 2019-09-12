package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.QuestionWithBLOBs;

public class QuestionSqlProvider {

    /**
     * the database table question
     */
    public String insertSelective(QuestionWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question");
        
        if (record.getAuthor() != null) {
            sql.VALUES("author", "#{author,jdbcType=INTEGER}");
        }
        
        if (record.getAdd_date() != null) {
            sql.VALUES("add_date", "#{add_date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDegree() != null) {
            sql.VALUES("degree", "#{degree,jdbcType=INTEGER}");
        }
        
        if (record.getAnswer() != null) {
            sql.VALUES("answer", "#{answer,jdbcType=VARCHAR}");
        }
        
        if (record.getType_id() != null) {
            sql.VALUES("type_id", "#{type_id,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledge_id() != null) {
            sql.VALUES("knowledge_id", "#{knowledge_id,jdbcType=INTEGER}");
        }
        
        if (record.getSubject_id() != null) {
            sql.VALUES("subject_id", "#{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getChapter_id() != null) {
            sql.VALUES("chapter_id", "#{chapter_id,jdbcType=INTEGER}");
        }
        
        if (record.getBody() != null) {
            sql.VALUES("body", "#{body,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getAnalysis() != null) {
            sql.VALUES("analysis", "#{analysis,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table question
     */
    public String updateByPrimaryKeySelective(QuestionWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("question");
        
        if (record.getAuthor() != null) {
            sql.SET("author = #{author,jdbcType=INTEGER}");
        }
        
        if (record.getAdd_date() != null) {
            sql.SET("add_date = #{add_date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDegree() != null) {
            sql.SET("degree = #{degree,jdbcType=INTEGER}");
        }
        
        if (record.getAnswer() != null) {
            sql.SET("answer = #{answer,jdbcType=VARCHAR}");
        }
        
        if (record.getType_id() != null) {
            sql.SET("type_id = #{type_id,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledge_id() != null) {
            sql.SET("knowledge_id = #{knowledge_id,jdbcType=INTEGER}");
        }
        
        if (record.getSubject_id() != null) {
            sql.SET("subject_id = #{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getChapter_id() != null) {
            sql.SET("chapter_id = #{chapter_id,jdbcType=INTEGER}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{body,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getAnalysis() != null) {
            sql.SET("analysis = #{analysis,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}