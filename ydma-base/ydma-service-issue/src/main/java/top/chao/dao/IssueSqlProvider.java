package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Issue;

public class IssueSqlProvider {

    /**
     * the database table issue
     */
    public String insertSelective(Issue record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("issue");
        
        if (record.getHeadline() != null) {
            sql.VALUES("headline", "#{headline,jdbcType=VARCHAR}");
        }
        
        if (record.getIssue_context() != null) {
            sql.VALUES("issue_context", "#{issue_context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.VALUES("publish_time", "#{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAnswer_count() != null) {
            sql.VALUES("answer_count", "#{answer_count,jdbcType=INTEGER}");
        }
        
        if (record.getBrowse_count() != null) {
            sql.VALUES("browse_count", "#{browse_count,jdbcType=INTEGER}");
        }
        
        if (record.getVideo_id() != null) {
            sql.VALUES("video_id", "#{video_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getRight_answer_id() != null) {
            sql.VALUES("right_answer_id", "#{right_answer_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table issue
     */
    public String updateByPrimaryKeySelective(Issue record) {
        SQL sql = new SQL();
        sql.UPDATE("issue");
        
        if (record.getHeadline() != null) {
            sql.SET("headline = #{headline,jdbcType=VARCHAR}");
        }
        
        if (record.getIssue_context() != null) {
            sql.SET("issue_context = #{issue_context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.SET("publish_time = #{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAnswer_count() != null) {
            sql.SET("answer_count = #{answer_count,jdbcType=INTEGER}");
        }
        
        if (record.getBrowse_count() != null) {
            sql.SET("browse_count = #{browse_count,jdbcType=INTEGER}");
        }
        
        if (record.getVideo_id() != null) {
            sql.SET("video_id = #{video_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getRight_answer_id() != null) {
            sql.SET("right_answer_id = #{right_answer_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}