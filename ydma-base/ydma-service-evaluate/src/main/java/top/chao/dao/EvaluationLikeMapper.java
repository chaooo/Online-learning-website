package top.chao.dao;

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
import top.chao.entity.EvaluationLike;

public interface EvaluationLikeMapper {
    /**
     * the database table evaluation_like
     */
    @Delete({
        "delete from evaluation_like",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table evaluation_like
     */
    @Insert({
        "insert into evaluation_like (evaluation_id, user_id, ",
        "like_time)",
        "values (#{evaluation_id,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{like_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(EvaluationLike record);

    /**
     * the database table evaluation_like
     */
    @InsertProvider(type=EvaluationLikeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(EvaluationLike record);

    /**
     * the database table evaluation_like
     */
    @Select({
        "select",
        "Id, evaluation_id, user_id, like_time",
        "from evaluation_like",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="evaluation_id", property="evaluation_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="like_time", property="like_time", jdbcType=JdbcType.TIMESTAMP)
    })
    EvaluationLike selectByPrimaryKey(Integer id);
    
    /**
     * 根据评论id查找点赞记录
     * @param id
     * @return
     */
    @Select({
        "select",
        "Id, evaluation_id, user_id, like_time",
        "from evaluation_like",
        "where evaluation_id = #{evaluation_id,jdbcType=INTEGER} limit 0,1"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="evaluation_id", property="evaluation_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="like_time", property="like_time", jdbcType=JdbcType.TIMESTAMP)
    })
    EvaluationLike selectByEvaluationId(Integer id);
    
    
    /**
     * the database table evaluation_like
     */
    @UpdateProvider(type=EvaluationLikeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EvaluationLike record);

    /**
     * the database table evaluation_like
     */
    @Update({
        "update evaluation_like",
        "set evaluation_id = #{evaluation_id,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER},",
          "like_time = #{like_time,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EvaluationLike record);
}