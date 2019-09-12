package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Course;

public class CourseSqlProvider {

    /**
     * the database table course
     */
    public String insertSelective(Course record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("course");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getLearn_count() != null) {
            sql.VALUES("learn_count", "#{learn_count,jdbcType=INTEGER}");
        }
        
        if (record.getDifficulty() != null) {
            sql.VALUES("difficulty", "#{difficulty,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.VALUES("publish_time", "#{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getSubject_id() != null) {
            sql.VALUES("subject_id", "#{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getDirection_id() != null) {
            sql.VALUES("direction_id", "#{direction_id,jdbcType=INTEGER}");
        }
        
        if (record.getLearn_time() != null) {
            sql.VALUES("learn_time", "#{learn_time,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table course
     */
    public String updateByPrimaryKeySelective(Course record) {
        SQL sql = new SQL();
        sql.UPDATE("course");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            sql.SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getLearn_count() != null) {
            sql.SET("learn_count = #{learn_count,jdbcType=INTEGER}");
        }
        
        if (record.getDifficulty() != null) {
            sql.SET("difficulty = #{difficulty,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getPublish_time() != null) {
            sql.SET("publish_time = #{publish_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getSubject_id() != null) {
            sql.SET("subject_id = #{subject_id,jdbcType=INTEGER}");
        }
        
        if (record.getDirection_id() != null) {
            sql.SET("direction_id = #{direction_id,jdbcType=INTEGER}");
        }
        
        if (record.getLearn_time() != null) {
            sql.SET("learn_time = #{learn_time,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}