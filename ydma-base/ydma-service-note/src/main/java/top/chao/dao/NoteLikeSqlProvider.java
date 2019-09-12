package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.NoteLike;

public class NoteLikeSqlProvider {

    /**
     * the database table note_like
     */
    public String insertSelective(NoteLike record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("note_like");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getNote_id() != null) {
            sql.VALUES("note_id", "#{note_id,jdbcType=INTEGER}");
        }
        
        if (record.getLike_time() != null) {
            sql.VALUES("like_time", "#{like_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * the database table note_like
     */
    public String updateByPrimaryKeySelective(NoteLike record) {
        SQL sql = new SQL();
        sql.UPDATE("note_like");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getNote_id() != null) {
            sql.SET("note_id = #{note_id,jdbcType=INTEGER}");
        }
        
        if (record.getLike_time() != null) {
            sql.SET("like_time = #{like_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}