package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.LoginHistory;

public class LoginHistorySqlProvider {

    /**
     * the database table login_history
     */
    public String insertSelective(LoginHistory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("login_history");
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getLogin_time() != null) {
            sql.VALUES("login_time", "#{login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.VALUES("ip", "#{ip,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table login_history
     */
    public String updateByPrimaryKeySelective(LoginHistory record) {
        SQL sql = new SQL();
        sql.UPDATE("login_history");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getLogin_time() != null) {
            sql.SET("login_time = #{login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.SET("ip = #{ip,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}