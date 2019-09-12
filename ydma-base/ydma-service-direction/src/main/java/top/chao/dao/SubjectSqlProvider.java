package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Subject;

public class SubjectSqlProvider {

    /**
     * the database table subject
     */
    public String insertSelective(Subject record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("subject");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDirection_id() != null) {
            sql.VALUES("direction_id", "#{direction_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table subject
     */
    public String updateByPrimaryKeySelective(Subject record) {
        SQL sql = new SQL();
        sql.UPDATE("subject");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDirection_id() != null) {
            sql.SET("direction_id = #{direction_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}