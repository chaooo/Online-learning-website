package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Direction;

public class DirectionSqlProvider {

    /**
     * the database table direction
     */
    public String insertSelective(Direction record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("direction");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table direction
     */
    public String updateByPrimaryKeySelective(Direction record) {
        SQL sql = new SQL();
        sql.UPDATE("direction");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}