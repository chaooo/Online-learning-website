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
import top.chao.entity.QuestionOptions;

public interface QuestionOptionsMapper {
    /**
     * the database table question_options
     */
    @Delete({
        "delete from question_options",
        "where option_id = #{option_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer option_id);

    /**
     * the database table question_options
     */
    @Insert({
        "insert into question_options (option_id, question_id, ",
        "option_name)",
        "values (#{option_id,jdbcType=INTEGER}, #{question_id,jdbcType=INTEGER}, ",
        "#{option_name,jdbcType=VARCHAR})"
    })
    int insert(QuestionOptions record);

    /**
     * the database table question_options
     */
    @InsertProvider(type=QuestionOptionsSqlProvider.class, method="insertSelective")
    int insertSelective(QuestionOptions record);

    /**
     * the database table question_options
     */
    @Select({
        "select",
        "option_id, question_id, option_name",
        "from question_options",
        "where option_id = #{option_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="option_id", property="option_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="question_id", property="question_id", jdbcType=JdbcType.INTEGER),
        @Result(column="option_name", property="option_name", jdbcType=JdbcType.VARCHAR)
    })
    QuestionOptions selectByPrimaryKey(Integer option_id);

    /**
     * the database table question_options
     */
    @UpdateProvider(type=QuestionOptionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionOptions record);

    /**
     * the database table question_options
     */
    @Update({
        "update question_options",
        "set question_id = #{question_id,jdbcType=INTEGER},",
          "option_name = #{option_name,jdbcType=VARCHAR}",
        "where option_id = #{option_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionOptions record);
}