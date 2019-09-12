package top.chao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.Evaluate;

public interface EvaluateMapper {
    /**
     * the database table evaluate
     */
    @Delete({
        "delete from evaluate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table evaluate
     */
    @Insert({
        "insert into evaluate (user_id, context, ",
        "publish_time, video_id, ",
        "like_count)",
        "values (#{user_id,jdbcType=INTEGER}, #{context,jdbcType=VARCHAR}, ",
        "#{publish_time,jdbcType=TIMESTAMP}, #{video_id,jdbcType=INTEGER}, ",
        "#{like_count,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Evaluate record);

    /**
     * the database table evaluate
     */
    @InsertProvider(type=EvaluateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Evaluate record);

    /**
     * the database table evaluate
     */
    @Select({
        "select",
        "id, user_id, context, publish_time, video_id, like_count",
        "from evaluate",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="evaluateMap", value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="like_count", jdbcType=JdbcType.INTEGER)
    })
    Evaluate selectByPrimaryKey(Integer id);
    
    /**
     * 根据 视频ID 查询评价列表
     * @param video_id
     * @return
     */
    @Select({
        "select",
        "id, user_id, context, publish_time, video_id, like_count",
        "from evaluate",
        "where video_id = #{video_id,jdbcType=INTEGER}"
    })
    @ResultMap("evaluateMap")
    List<Evaluate> selectByVideoId(Integer video_id);
    
    /**
     * 根据 课程ID 查询评价列表
     * @param video_id
     * @return
     */
    @Select({
        "select",
        "id, user_id, context, publish_time, video_id, like_count",
        "from evaluate",
        "where video_id in (",
        "select id from video where chapter_id in (",
        "select id from chapter",
        "where course_id = #{course_id,jdbcType=INTEGER}))"
    })
    @ResultMap("evaluateMap")
    List<Evaluate> selectByCourseId(Integer course_id);
    
    /**
     * the database table evaluate
     */
    @UpdateProvider(type=EvaluateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Evaluate record);

    /**
     * the database table evaluate
     */
    @Update({
        "update evaluate",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "context = #{context,jdbcType=VARCHAR},",
          "publish_time = #{publish_time,jdbcType=TIMESTAMP},",
          "video_id = #{video_id,jdbcType=INTEGER},",
          "like_count = #{like_count,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Evaluate record);
    
    /**
     * 根据id 增加1点赞数
     */
    @Update({
        "update evaluate",
        "set like_count = like_count+1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int addLikeCountById(int id);
    
    /**
     * 根据id 减1点赞数
     */
    @Update({
        "update evaluate",
        "set like_count = like_count-1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int minusLikeCountById(int id);
    
    
}