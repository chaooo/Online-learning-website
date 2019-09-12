package top.chao.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.Paper;

public interface PaperMapper {
    /**
     * the database table paper
     */
    @Delete({
        "delete from paper",
        "where paper_id = #{paper_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paper_id);

    /**
     * the database table paper
     */
    @Insert({
        "insert into paper (paper_id, type_id, ",
        "user_id, subject_id, ",
        "score, limit_time, ",
        "createtime, begintime, ",
        "endtime, status, ",
        "question_total, name)",
        "values (#{paper_id,jdbcType=INTEGER}, #{type_id,jdbcType=INTEGER}, ",
        "#{user_id,jdbcType=INTEGER}, #{subject_id,jdbcType=INTEGER}, ",
        "#{score,jdbcType=INTEGER}, #{limit_time,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{begintime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{question_total,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Paper record);

    /**
     * the database table paper
     */
    @InsertProvider(type=PaperSqlProvider.class, method="insertSelective")
    int insertSelective(Paper record);

    /**
     * the database table paper
     */
    @Select({
        "select",
        "paper_id, type_id, user_id, subject_id, score, limit_time, createtime, begintime, ",
        "endtime, status, question_total, name",
        "from paper",
        "where paper_id = #{paper_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="paper_id", property="paper_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_id", property="type_id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subject_id", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_time", property="limit_time", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="begintime", property="begintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endtime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="question_total", property="question_total", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Paper selectByPrimaryKey(Integer paper_id);

    /**
     * the database table paper
     */
    @UpdateProvider(type=PaperSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Paper record);

    /**
     * the database table paper
     */
    @Update({
        "update paper",
        "set type_id = #{type_id,jdbcType=INTEGER},",
          "user_id = #{user_id,jdbcType=INTEGER},",
          "subject_id = #{subject_id,jdbcType=INTEGER},",
          "score = #{score,jdbcType=INTEGER},",
          "limit_time = #{limit_time,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "begintime = #{begintime,jdbcType=TIMESTAMP},",
          "endtime = #{endtime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "question_total = #{question_total,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR}",
        "where paper_id = #{paper_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Paper record);
}