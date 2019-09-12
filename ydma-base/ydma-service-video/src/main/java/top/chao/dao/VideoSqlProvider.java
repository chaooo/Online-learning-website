package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.Video;

public class VideoSqlProvider {

    /**
     * the database table video
     */
    public String insertSelective(Video record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("video");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getChapter_id() != null) {
            sql.VALUES("chapter_id", "#{chapter_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table video
     */
    public String updateByPrimaryKeySelective(Video record) {
        SQL sql = new SQL();
        sql.UPDATE("video");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getChapter_id() != null) {
            sql.SET("chapter_id = #{chapter_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}