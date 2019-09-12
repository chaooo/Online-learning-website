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
import top.chao.entity.PaperQuestion;

public interface PaperQuestionMapper {
    /**
     * the database table paper_question
     */
    @Delete({
        "delete from paper_question",
        "where paper_id = #{paper_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paper_id);

    /**
     * the database table paper_question
     */
    @Insert({
        "insert into paper_question (paper_id, question_id, ",
        "question_score)",
        "values (#{paper_id,jdbcType=INTEGER}, #{question_id,jdbcType=INTEGER}, ",
        "#{question_score,jdbcType=INTEGER})"
    })
    int insert(PaperQuestion record);

    /**
     * the database table paper_question
     */
    @InsertProvider(type=PaperQuestionSqlProvider.class, method="insertSelective")
    int insertSelective(PaperQuestion record);

    /**
     * the database table paper_question
     */
    @Select({
        "select",
        "paper_id, question_id, question_score",
        "from paper_question",
        "where paper_id = #{paper_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="paper_id", property="paper_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="question_id", property="question_id", jdbcType=JdbcType.INTEGER),
        @Result(column="question_score", property="question_score", jdbcType=JdbcType.INTEGER)
    })
    PaperQuestion selectByPrimaryKey(Integer paper_id);

    /**
     * the database table paper_question
     */
    @UpdateProvider(type=PaperQuestionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperQuestion record);

    /**
     * the database table paper_question
     */
    @Update({
        "update paper_question",
        "set question_id = #{question_id,jdbcType=INTEGER},",
          "question_score = #{question_score,jdbcType=INTEGER}",
        "where paper_id = #{paper_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperQuestion record);
}