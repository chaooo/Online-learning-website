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
import top.chao.entity.Question;
import top.chao.entity.QuestionWithBLOBs;

public interface QuestionMapper {
    /**
     * the database table question
     */
    @Delete({
        "delete from question",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table question
     */
    @Insert({
        "insert into question (author, add_date, ",
        "degree, answer, ",
        "type_id, knowledge_id, ",
        "subject_id, chapter_id, ",
        "body, analysis)",
        "values (#{author,jdbcType=INTEGER}, #{add_date,jdbcType=TIMESTAMP}, ",
        "#{degree,jdbcType=INTEGER}, #{answer,jdbcType=VARCHAR}, ",
        "#{type_id,jdbcType=INTEGER}, #{knowledge_id,jdbcType=INTEGER}, ",
        "#{subject_id,jdbcType=INTEGER}, #{chapter_id,jdbcType=INTEGER}, ",
        "#{body,jdbcType=LONGVARCHAR}, #{analysis,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(QuestionWithBLOBs record);

    /**
     * the database table question
     */
    @InsertProvider(type=QuestionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(QuestionWithBLOBs record);

    /**
     * the database table question
     */
    @Select({
        "select",
        "id, author, add_date, degree, answer, type_id, knowledge_id, subject_id, chapter_id, ",
        "body, analysis",
        "from question",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="author", property="author", jdbcType=JdbcType.INTEGER),
        @Result(column="add_date", property="add_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="degree", property="degree", jdbcType=JdbcType.INTEGER),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="type_id", jdbcType=JdbcType.INTEGER),
        @Result(column="knowledge_id", property="knowledge_id", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subject_id", jdbcType=JdbcType.INTEGER),
        @Result(column="chapter_id", property="chapter_id", jdbcType=JdbcType.INTEGER),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR)
    })
    QuestionWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * the database table question
     */
    @UpdateProvider(type=QuestionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionWithBLOBs record);

    /**
     * the database table question
     */
    @Update({
        "update question",
        "set author = #{author,jdbcType=INTEGER},",
          "add_date = #{add_date,jdbcType=TIMESTAMP},",
          "degree = #{degree,jdbcType=INTEGER},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "type_id = #{type_id,jdbcType=INTEGER},",
          "knowledge_id = #{knowledge_id,jdbcType=INTEGER},",
          "subject_id = #{subject_id,jdbcType=INTEGER},",
          "chapter_id = #{chapter_id,jdbcType=INTEGER},",
          "body = #{body,jdbcType=LONGVARCHAR},",
          "analysis = #{analysis,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(QuestionWithBLOBs record);

    /**
     * the database table question
     */
    @Update({
        "update question",
        "set author = #{author,jdbcType=INTEGER},",
          "add_date = #{add_date,jdbcType=TIMESTAMP},",
          "degree = #{degree,jdbcType=INTEGER},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "type_id = #{type_id,jdbcType=INTEGER},",
          "knowledge_id = #{knowledge_id,jdbcType=INTEGER},",
          "subject_id = #{subject_id,jdbcType=INTEGER},",
          "chapter_id = #{chapter_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Question record);
}