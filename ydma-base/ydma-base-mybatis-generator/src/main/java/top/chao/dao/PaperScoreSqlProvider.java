package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.PaperScore;

public class PaperScoreSqlProvider {

    /**
     * the database table paper_score
     */
    public String insertSelective(PaperScore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper_score");
        
        if (record.getTotal_score() != null) {
            sql.VALUES("total_score", "#{total_score,jdbcType=INTEGER}");
        }
        
        if (record.getMy_score() != null) {
            sql.VALUES("my_score", "#{my_score,jdbcType=INTEGER}");
        }
        
        if (record.getStart_time() != null) {
            sql.VALUES("start_time", "#{start_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnd_time() != null) {
            sql.VALUES("end_time", "#{end_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaper_id() != null) {
            sql.VALUES("paper_id", "#{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table paper_score
     */
    public String updateByPrimaryKeySelective(PaperScore record) {
        SQL sql = new SQL();
        sql.UPDATE("paper_score");
        
        if (record.getTotal_score() != null) {
            sql.SET("total_score = #{total_score,jdbcType=INTEGER}");
        }
        
        if (record.getMy_score() != null) {
            sql.SET("my_score = #{my_score,jdbcType=INTEGER}");
        }
        
        if (record.getStart_time() != null) {
            sql.SET("start_time = #{start_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnd_time() != null) {
            sql.SET("end_time = #{end_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPaper_id() != null) {
            sql.SET("paper_id = #{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}