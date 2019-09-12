package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.User;

public class UserSqlProvider {

    /**
     * the database table user
     */
    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            sql.VALUES("nick_name", "#{nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPosition() != null) {
            sql.VALUES("position", "#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.VALUES("location", "#{location,jdbcType=VARCHAR}");
        }
        
        if (record.getSignature() != null) {
            sql.VALUES("signature", "#{signature,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getRegtime() != null) {
            sql.VALUES("regtime", "#{regtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSalt() != null) {
            sql.VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table user
     */
    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            sql.SET("nick_name = #{nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPosition() != null) {
            sql.SET("position = #{position,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("location = #{location,jdbcType=VARCHAR}");
        }
        
        if (record.getSignature() != null) {
            sql.SET("signature = #{signature,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getRegtime() != null) {
            sql.SET("regtime = #{regtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}