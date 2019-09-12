package top.chao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.Video;

public interface VideoMapper {
    /**
     * the database table video
     */
    @Delete({
        "delete from video",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table video
     */
    @Insert({
        "insert into video (name, url, ",
        "chapter_id)",
        "values (#{name,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{chapter_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Video record);

    /**
     * the database table video
     */
    @InsertProvider(type=VideoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Video record);

    /**
     * the database table video
     */
    @Select({
        "select",
        "id, name, url, chapter_id",
        "from video",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="chapter_id", property="chapter_id", jdbcType=JdbcType.INTEGER)
    })
    Video selectByPrimaryKey(Integer id);
    
    /**
     * 根据章节Id查询视频列表
     * @param chapter_id
     * @return
     */
    @Select({
        "select",
        "id, name, url, chapter_id",
        "from video",
        "where chapter_id = #{chapter_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="chapter_id", property="chapter_id", jdbcType=JdbcType.INTEGER)
    })
    List<Video> selectByChapterId(Integer chapter_id);

    /**
     * the database table video
     */
    @UpdateProvider(type=VideoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Video record);

    /**
     * the database table video
     */
    @Update({
        "update video",
        "set name = #{name,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "chapter_id = #{chapter_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Video record);
}