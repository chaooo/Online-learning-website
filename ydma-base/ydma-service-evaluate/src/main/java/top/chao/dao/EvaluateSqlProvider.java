package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Evaluate;

public class EvaluateSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String insertSelective(Evaluate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("evaluate");
        
        if (record.getUse_id() != null) {
            sql.VALUES("use_id", "#{use_id,jdbcType=INTEGER}");
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
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String updateByPrimaryKeySelective(Evaluate record) {
        SQL sql = new SQL();
        sql.UPDATE("evaluate");
        
        if (record.getUse_id() != null) {
            sql.SET("use_id = #{use_id,jdbcType=INTEGER}");
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