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
import top.chao.entity.Answer;

public interface AnswerMapper {
    /**
     * the database table answer
     */
    @Delete({
        "delete from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table answer
     */
    @Insert({
        "insert into answer (context, publish_time, ",
        "issue_id, user_id)",
        "values (#{context,jdbcType=VARCHAR}, #{publish_time,jdbcType=TIMESTAMP}, ",
        "#{issue_id,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Answer record);

    /**
     * the database table answer
     */
    @InsertProvider(type=AnswerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Answer record);

    /**
     * the database table answer
     */
    @Select({
        "select",
        "id, context, publish_time, issue_id, user_id",
        "from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="issue_id", property="issue_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER)
    })
    Answer selectByPrimaryKey(Integer id);
    
    /**
     * the database table answer
     */
    @UpdateProvider(type=AnswerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Answer record);

    /**
     * the database table answer
     */
    @Update({
        "update answer",
        "set context = #{context,jdbcType=VARCHAR},",
          "publish_time = #{publish_time,jdbcType=TIMESTAMP},",
          "issue_id = #{issue_id,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Answer record);
    
}