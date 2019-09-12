package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.PaperQuestion;

public class PaperQuestionSqlProvider {

    /**
     * the database table paper_question
     */
    public String insertSelective(PaperQuestion record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper_question");
        
        if (record.getPaper_id() != null) {
            sql.VALUES("paper_id", "#{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_id() != null) {
            sql.VALUES("question_id", "#{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_score() != null) {
            sql.VALUES("question_score", "#{question_score,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table paper_question
     */
    public String updateByPrimaryKeySelective(PaperQuestion record) {
        SQL sql = new SQL();
        sql.UPDATE("paper_question");
        
        if (record.getQuestion_id() != null) {
            sql.SET("question_id = #{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_score() != null) {
            sql.SET("question_score = #{question_score,jdbcType=INTEGER}");
        }
        
        sql.WHERE("paper_id = #{paper_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}