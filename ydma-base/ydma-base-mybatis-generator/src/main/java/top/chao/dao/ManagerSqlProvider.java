package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Manager;

public class ManagerSqlProvider {

    /**
     * the database table manager
     */
    public String insertSelective(Manager record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("manager");
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getRealname() != null) {
            sql.VALUES("realname", "#{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_login_time() != null) {
            sql.VALUES("last_login_time", "#{last_login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegist_time() != null) {
            sql.VALUES("regist_time", "#{regist_time,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table manager
     */
    public String updateByPrimaryKeySelective(Manager record) {
        SQL sql = new SQL();
        sql.UPDATE("manager");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getRealname() != null) {
            sql.SET("realname = #{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_login_time() != null) {
            sql.SET("last_login_time = #{last_login_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRegist_time() != null) {
            sql.SET("regist_time = #{regist_time,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}