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
import top.chao.entity.Note;

public interface NoteMapper {
    /**
     * the database table note
     */
    @Delete({
        "delete from note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table note
     */
    @Insert({
        "insert into note (publish_time, like_count, ",
        "user_id, video_id, ",
        "title, context)",
        "values (#{publish_time,jdbcType=TIMESTAMP}, #{like_count,jdbcType=INTEGER}, ",
        "#{user_id,jdbcType=INTEGER}, #{video_id,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{context,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Note record);

    /**
     * the database table note
     */
    @InsertProvider(type=NoteSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Note record);

    /**
     * the database table note
     */
    @Select({
        "select",
        "id, publish_time, like_count, user_id, video_id, title, context",
        "from note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="like_count", property="like_count", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="context", property="context", jdbcType=JdbcType.LONGVARCHAR)
    })
    Note selectByPrimaryKey(Integer id);
    
    /**
     * 根据视频id查询笔记
     * @param id
     * @return
     */
    @Select({
        "select",
        "id, publish_time, like_count, user_id, video_id, title, context",
        "from note",
        "where video_id = #{video_id,jdbcType=INTEGER}",
        "order by publish_time desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="like_count", property="like_count", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="context", property="context", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Note> selectByVideoId(Integer video_id);

    @Select({
        "select",
        "id, publish_time, like_count, user_id, video_id, title, context",
        "from note",
        "where video_id in (", 
        "select id from video where chapter_id in (", 
        "select id from chapter where course_id = #{course_id,jdbcType=INTEGER}))",
        "order by publish_time desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="like_count", property="like_count", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="context", property="context", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Note> selectByCourseId(Integer course_id);
    /**
     * the database table note
     */
    @UpdateProvider(type=NoteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Note record);

    /**
     * the database table note
     */
    @Update({
        "update note",
        "set publish_time = #{publish_time,jdbcType=TIMESTAMP},",
          "like_count = #{like_count,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER},",
          "video_id = #{video_id,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "context = #{context,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Note record);
    
    /**
     * 笔记点赞数加1
     * @param note_id
     * @return
     */
    @Update({
        "update note",
        "set like_count = like_count + 1",
        "where id = #{note_id,jdbcType=INTEGER}"
    })
    int addLikeCountById(Integer note_id);
    
    /**
     * 笔记点赞数减1
     * @param note_id
     * @return
     */
    @Update({
        "update note",
        "set like_count = like_count - 1",
        "where id = #{note_id,jdbcType=INTEGER}"
    })
    int cutLikeCountById(Integer note_id);

    /**
     * the database table note
     */
    @Update({
        "update note",
        "set publish_time = #{publish_time,jdbcType=TIMESTAMP},",
          "like_count = #{like_count,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER},",
          "video_id = #{video_id,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Note record);
}