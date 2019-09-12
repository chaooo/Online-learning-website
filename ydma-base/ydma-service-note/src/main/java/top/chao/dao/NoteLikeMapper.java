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
import top.chao.entity.NoteLike;

public interface NoteLikeMapper {
    /**
     * the database table note_like
     */
    @Delete({
        "delete from note_like",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 根据用户ID和笔记ID取消点赞
     * @param user_id
     * @param note_id
     * @return
     */
    @Delete({
        "delete from note_like",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "and note_id = #{note_id,jdbcType=INTEGER}"
    })
    int deleteByUserIdAndNoteId(Integer user_id, Integer note_id);

    /**
     * the database table note_like
     */
    @Insert({
        "insert into note_like (user_id, note_id, ",
        "like_time)",
        "values (#{user_id,jdbcType=INTEGER}, #{note_id,jdbcType=INTEGER}, ",
        "#{like_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(NoteLike record);

    /**
     * the database table note_like
     */
    @InsertProvider(type=NoteLikeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(NoteLike record);

    /**
     * the database table note_like
     */
    @Select({
        "select",
        "Id, user_id, note_id, like_time",
        "from note_like",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="note_id", property="note_id", jdbcType=JdbcType.INTEGER),
        @Result(column="like_time", property="like_time", jdbcType=JdbcType.TIMESTAMP)
    })
    NoteLike selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "Id, user_id, note_id, like_time",
        "from note_like",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "and note_id = #{note_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="note_id", property="note_id", jdbcType=JdbcType.INTEGER),
        @Result(column="like_time", property="like_time", jdbcType=JdbcType.TIMESTAMP)
    })
    NoteLike selectByUserIdAndNoteId(Integer user_id, Integer note_id);

    /**
     * the database table note_like
     */
    @UpdateProvider(type=NoteLikeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoteLike record);

    /**
     * the database table note_like
     */
    @Update({
        "update note_like",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "note_id = #{note_id,jdbcType=INTEGER},",
          "like_time = #{like_time,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(NoteLike record);
}