package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.BrowsingHistory;

public class BrowsingHistorySqlProvider {

    /**
     * the database table browsing_history
     */
    public String insertSelective(BrowsingHistory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("browsing_history");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getCourse_id() != null) {
            sql.VALUES("course_id", "#{course_id,jdbcType=INTEGER}");
        }
        
        if (record.getBrowse_time() != null) {
            sql.VALUES("browse_time", "#{browse_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideo_id() != null) {
            sql.VALUES("video_id", "#{video_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table browsing_history
     */
    public String updateByPrimaryKeySelective(BrowsingHistory record) {
        SQL sql = new SQL();
        sql.UPDATE("browsing_history");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getCourse_id() != null) {
            sql.SET("course_id = #{course_id,jdbcType=INTEGER}");
        }
        
        if (record.getBrowse_time() != null) {
            sql.SET("browse_time = #{browse_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideo_id() != null) {
            sql.SET("video_id = #{video_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}