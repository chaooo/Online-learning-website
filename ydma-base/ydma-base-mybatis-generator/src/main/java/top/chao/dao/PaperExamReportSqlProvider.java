package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.PaperExamReport;

public class PaperExamReportSqlProvider {

    /**
     * the database table paper_exam_report
     */
    public String insertSelective(PaperExamReport record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper_exam_report");
        
        if (record.getReport_id() != null) {
            sql.VALUES("report_id", "#{report_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getPaper_id() != null) {
            sql.VALUES("paper_id", "#{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getError_num() != null) {
            sql.VALUES("error_num", "#{error_num,jdbcType=INTEGER}");
        }
        
        if (record.getRight_num() != null) {
            sql.VALUES("right_num", "#{right_num,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=DOUBLE}");
        }
        
        if (record.getSubmit_time() != null) {
            sql.VALUES("submit_time", "#{submit_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table paper_exam_report
     */
    public String updateByPrimaryKeySelective(PaperExamReport record) {
        SQL sql = new SQL();
        sql.UPDATE("paper_exam_report");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getPaper_id() != null) {
            sql.SET("paper_id = #{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getError_num() != null) {
            sql.SET("error_num = #{error_num,jdbcType=INTEGER}");
        }
        
        if (record.getRight_num() != null) {
            sql.SET("right_num = #{right_num,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=DOUBLE}");
        }
        
        if (record.getSubmit_time() != null) {
            sql.SET("submit_time = #{submit_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("report_id = #{report_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}