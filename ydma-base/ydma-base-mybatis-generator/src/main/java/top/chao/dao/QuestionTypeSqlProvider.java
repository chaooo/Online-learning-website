package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.QuestionType;

public class QuestionTypeSqlProvider {

    /**
     * the database table question_type
     */
    public String insertSelective(QuestionType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_type");
        
        if (record.getType_id() != null) {
            sql.VALUES("type_id", "#{type_id,jdbcType=INTEGER}");
        }
        
        if (record.getType_name() != null) {
            sql.VALUES("type_name", "#{type_name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table question_type
     */
    public String updateByPrimaryKeySelective(QuestionType record) {
        SQL sql = new SQL();
        sql.UPDATE("question_type");
        
        if (record.getType_name() != null) {
            sql.SET("type_name = #{type_name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("type_id = #{type_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}