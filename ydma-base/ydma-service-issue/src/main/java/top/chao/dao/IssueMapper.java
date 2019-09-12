package top.chao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.Issue;
import top.chao.entity.Answer;

public interface IssueMapper {
    /**
     * the database table issue
     */
    @Delete({
        "delete from issue",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table issue
     */
    @Insert({
        "insert into issue (headline, issue_context, ",
        "publish_time, answer_count, ",
        "browse_count, video_id, ",
        "user_id, right_answer_id)",
        "values (#{headline,jdbcType=VARCHAR}, #{issue_context,jdbcType=VARCHAR}, ",
        "#{publish_time,jdbcType=TIMESTAMP}, #{answer_count,jdbcType=INTEGER}, ",
        "#{browse_count,jdbcType=INTEGER}, #{video_id,jdbcType=INTEGER}, ",
        "#{user_id,jdbcType=INTEGER}, #{right_answer_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Issue record);

    /**
     * the database table issue
     */
    @InsertProvider(type=IssueSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Issue record);

    /**
     * the database table issue
     */
    @Select({
        "select",
        "id, headline, issue_context, publish_time, answer_count, browse_count, video_id, ",
        "user_id, right_answer_id",
        "from issue",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="headline", property="headline", jdbcType=JdbcType.VARCHAR),
        @Result(column="issue_context", property="issue_context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="answer_count", property="answer_count", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_count", property="browse_count", jdbcType=JdbcType.INTEGER),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="right_answer_id", property="right_answer_id", jdbcType=JdbcType.INTEGER)
    })
    Issue selectByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "user_id",
        "from issue",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER)
    })
    int selectUserIdByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "id, headline, issue_context, publish_time, answer_count, browse_count, video_id, ",
        "user_id, right_answer_id",
        "from issue",
        "where video_id = #{video_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="headline", property="headline", jdbcType=JdbcType.VARCHAR),
        @Result(column="issue_context", property="issue_context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="answer_count", property="answer_count", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_count", property="browse_count", jdbcType=JdbcType.INTEGER),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="right_answer_id", property="right_answer_id", jdbcType=JdbcType.INTEGER),
        @Result(property = "answer",javaType = Answer.class,column = "right_answer_id",
        one=@One(select="top.chao.dao.AnswerMapper.selectByPrimaryKey"))
    })
    List<Issue> selectAll(Integer video_id);

    /**
     * the database table issue
     */
    @UpdateProvider(type=IssueSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Issue record);

    /**
     * the database table issue
     */
    @Update({
        "update issue",
        "set headline = #{headline,jdbcType=VARCHAR},",
          "issue_context = #{issue_context,jdbcType=VARCHAR},",
          "publish_time = #{publish_time,jdbcType=TIMESTAMP},",
          "answer_count = #{answer_count,jdbcType=INTEGER},",
          "browse_count = #{browse_count,jdbcType=INTEGER},",
          "video_id = #{video_id,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER},",
          "right_answer_id = #{right_answer_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Issue record);
    
    @Update({
        "update issue",
        "set answer_count = coalesce(answer_count,0) + 1",
//        "set answer_count = answer_count + 1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByIssue_id(Integer id);
}