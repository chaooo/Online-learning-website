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
import top.chao.entity.PaperScore;

public interface PaperScoreMapper {
    /**
     * the database table paper_score
     */
    @Delete({
        "delete from paper_score",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table paper_score
     */
    @Insert({
        "insert into paper_score (total_score, my_score, ",
        "start_time, end_time, ",
        "paper_id, user_id)",
        "values (#{total_score,jdbcType=INTEGER}, #{my_score,jdbcType=INTEGER}, ",
        "#{start_time,jdbcType=TIMESTAMP}, #{end_time,jdbcType=TIMESTAMP}, ",
        "#{paper_id,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PaperScore record);

    /**
     * the database table paper_score
     */
    @InsertProvider(type=PaperScoreSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PaperScore record);

    /**
     * the database table paper_score
     */
    @Select({
        "select",
        "Id, total_score, my_score, start_time, end_time, paper_id, user_id",
        "from paper_score",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="total_score", property="total_score", jdbcType=JdbcType.INTEGER),
        @Result(column="my_score", property="my_score", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="start_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="end_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="paper_id", property="paper_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER)
    })
    PaperScore selectByPrimaryKey(Integer id);

    /**
     * the database table paper_score
     */
    @UpdateProvider(type=PaperScoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperScore record);

    /**
     * the database table paper_score
     */
    @Update({
        "update paper_score",
        "set total_score = #{total_score,jdbcType=INTEGER},",
          "my_score = #{my_score,jdbcType=INTEGER},",
          "start_time = #{start_time,jdbcType=TIMESTAMP},",
          "end_time = #{end_time,jdbcType=TIMESTAMP},",
          "paper_id = #{paper_id,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperScore record);
}