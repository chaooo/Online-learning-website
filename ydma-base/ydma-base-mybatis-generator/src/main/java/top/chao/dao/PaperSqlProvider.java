package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Paper;

public class PaperSqlProvider {

    /**
     * the database table paper
     */
    public String insertSelective(Paper record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper");
        
        if (record.getPaper_id() != null) {
            sql.VALUES("paper_id", "#{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getType_id() != null) {
            sql.VALUES("type_id", "#{type_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getSubject_id() != null) {
            sql.VALUES("subject_id", "#{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getLimit_time() != null) {
            sql.VALUES("limit_time", "#{limit_time,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBegintime() != null) {
            sql.VALUES("begintime", "#{begintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            sql.VALUES("endtime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_total() != null) {
            sql.VALUES("question_total", "#{question_total,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * the database table paper
     */
    public String updateByPrimaryKeySelective(Paper record) {
        SQL sql = new SQL();
        sql.UPDATE("paper");
        
        if (record.getType_id() != null) {
            sql.SET("type_id = #{type_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        if (record.getSubject_id() != null) {
            sql.SET("subject_id = #{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getLimit_time() != null) {
            sql.SET("limit_time = #{limit_time,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBegintime() != null) {
            sql.SET("begintime = #{begintime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            sql.SET("endtime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_total() != null) {
            sql.SET("question_total = #{question_total,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("paper_id = #{paper_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}