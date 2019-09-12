package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Note;

public class NoteSqlProvider {

    /**
     * the database table note
     */
    public String insertSelective(Note record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("note");
        
        if (record.getPublish_time() != null) {
            sql.VALUES("publish_time", "#{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLike_count() != null) {
            sql.VALUES("like_count", "#{like_count,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getVideo_id() != null) {
            sql.VALUES("video_id", "#{video_id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getContext() != null) {
            sql.VALUES("context", "#{context,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table note
     */
    public String updateByPrimaryKeySelective(Note record) {
        SQL sql = new SQL();
        sql.UPDATE("note");
        
        if (record.getPublish_time() != null) {
            sql.SET("publish_time = #{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLike_count() != null) {
            sql.SET("like_count = #{like_count,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getVideo_id() != null) {
            sql.SET("video_id = #{video_id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getContext() != null) {
            sql.SET("context = #{context,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}