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
import top.chao.entity.QuestionType;

public interface QuestionTypeMapper {
    /**
     * the database table question_type
     */
    @Delete({
        "delete from question_type",
        "where type_id = #{type_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer type_id);

    /**
     * the database table question_type
     */
    @Insert({
        "insert into question_type (type_id, type_name)",
        "values (#{type_id,jdbcType=INTEGER}, #{type_name,jdbcType=VARCHAR})"
    })
    int insert(QuestionType record);

    /**
     * the database table question_type
     */
    @InsertProvider(type=QuestionTypeSqlProvider.class, method="insertSelective")
    int insertSelective(QuestionType record);

    /**
     * the database table question_type
     */
    @Select({
        "select",
        "type_id, type_name",
        "from question_type",
        "where type_id = #{type_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="type_id", property="type_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="type_name", jdbcType=JdbcType.VARCHAR)
    })
    QuestionType selectByPrimaryKey(Integer type_id);

    /**
     * the database table question_type
     */
    @UpdateProvider(type=QuestionTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionType record);

    /**
     * the database table question_type
     */
    @Update({
        "update question_type",
        "set type_name = #{type_name,jdbcType=VARCHAR}",
        "where type_id = #{type_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionType record);
}