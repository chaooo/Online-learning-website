package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.QuestionOptions;

public class QuestionOptionsSqlProvider {

    /**
     * the database table question_options
     */
    public String insertSelective(QuestionOptions record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_options");
        
        if (record.getOption_id() != null) {
            sql.VALUES("option_id", "#{option_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_id() != null) {
            sql.VALUES("question_id", "#{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getOption_name() != null) {
            sql.VALUES("option_name", "#{option_name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table question_options
     */
    public String updateByPrimaryKeySelective(QuestionOptions record) {
        SQL sql = new SQL();
        sql.UPDATE("question_options");
        
        if (record.getQuestion_id() != null) {
            sql.SET("question_id = #{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getOption_name() != null) {
            sql.SET("option_name = #{option_name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("option_id = #{option_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}