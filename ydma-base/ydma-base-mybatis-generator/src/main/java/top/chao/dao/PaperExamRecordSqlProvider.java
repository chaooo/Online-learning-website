package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.PaperExamRecord;

public class PaperExamRecordSqlProvider {

    /**
     * the database table paper_exam_record
     */
    public String insertSelective(PaperExamRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper_exam_record");
        
        if (record.getRecord_id() != null) {
            sql.VALUES("record_id", "#{record_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getPaper_id() != null) {
            sql.VALUES("paper_id", "#{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_id() != null) {
            sql.VALUES("question_id", "#{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getAnswer() != null) {
            sql.VALUES("answer", "#{answer,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * the database table paper_exam_record
     */
    public String updateByPrimaryKeySelective(PaperExamRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("paper_exam_record");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getPaper_id() != null) {
            sql.SET("paper_id = #{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_id() != null) {
            sql.SET("question_id = #{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getAnswer() != null) {
            sql.SET("answer = #{answer,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("record_id = #{record_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}