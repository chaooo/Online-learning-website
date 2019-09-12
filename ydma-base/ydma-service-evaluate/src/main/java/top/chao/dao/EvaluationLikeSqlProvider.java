package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.EvaluationLike;

public class EvaluationLikeSqlProvider {

    /**
     * the database table evaluation_like
     */
    public String insertSelective(EvaluationLike record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("evaluation_like");
        
        if (record.getEvaluation_id() != null) {
            sql.VALUES("evaluation_id", "#{evaluation_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getLike_time() != null) {
            sql.VALUES("like_time", "#{like_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * the database table evaluation_like
     */
    public String updateByPrimaryKeySelective(EvaluationLike record) {
        SQL sql = new SQL();
        sql.UPDATE("evaluation_like");
        
        if (record.getEvaluation_id() != null) {
            sql.SET("evaluation_id = #{evaluation_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getLike_time() != null) {
            sql.SET("like_time = #{like_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}