package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Evaluate;

public class EvaluateSqlProvider {

    /**
     * the database table evaluate
     */
    public String insertSelective(Evaluate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("evaluate");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.VALUES("publish_time", "#{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideo_id() != null) {
            sql.VALUES("video_id", "#{video_id,jdbcType=INTEGER}");
        }
        
        if (record.getLike_count() != null) {
            sql.VALUES("like_count", "#{like_count,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table evaluate
     */
    public String updateByPrimaryKeySelective(Evaluate record) {
        SQL sql = new SQL();
        sql.UPDATE("evaluate");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            sql.SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.SET("publish_time = #{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideo_id() != null) {
            sql.SET("video_id = #{video_id,jdbcType=INTEGER}");
        }
        
        if (record.getLike_count() != null) {
            sql.SET("like_count = #{like_count,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}