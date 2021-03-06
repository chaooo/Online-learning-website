package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Answer;

public class AnswerSqlProvider {

    /**
     * the database table answer
     */
    public String insertSelective(Answer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("answer");
        
        if (record.getContext() != null) {
            sql.VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.VALUES("publish_time", "#{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssue_id() != null) {
            sql.VALUES("issue_id", "#{issue_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table answer
     */
    public String updateByPrimaryKeySelective(Answer record) {
        SQL sql = new SQL();
        sql.UPDATE("answer");
        
        if (record.getContext() != null) {
            sql.SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.SET("publish_time = #{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssue_id() != null) {
            sql.SET("issue_id = #{issue_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}