package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.CollectNote;

public class CollectNoteSqlProvider {

    /**
     * the database table collect_note
     */
    public String insertSelective(CollectNote record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("collect_note");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getNote_id() != null) {
            sql.VALUES("note_id", "#{note_id,jdbcType=INTEGER}");
        }
        
        if (record.getCollect_time() != null) {
            sql.VALUES("collect_time", "#{collect_time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * the database table collect_note
     */
    public String updateByPrimaryKeySelective(CollectNote record) {
        SQL sql = new SQL();
        sql.UPDATE("collect_note");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getNote_id() != null) {
            sql.SET("note_id = #{note_id,jdbcType=INTEGER}");
        }
        
        if (record.getCollect_time() != null) {
            sql.SET("collect_time = #{collect_time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}