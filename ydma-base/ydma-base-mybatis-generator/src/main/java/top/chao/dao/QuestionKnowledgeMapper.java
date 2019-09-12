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
import top.chao.entity.QuestionKnowledge;

public interface QuestionKnowledgeMapper {
    /**
     * the database table question_knowledge
     */
    @Delete({
        "delete from question_knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table question_knowledge
     */
    @Insert({
        "insert into question_knowledge (question_id, knowledge_id)",
        "values (#{question_id,jdbcType=INTEGER}, #{knowledge_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(QuestionKnowledge record);

    /**
     * the database table question_knowledge
     */
    @InsertProvider(type=QuestionKnowledgeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(QuestionKnowledge record);

    /**
     * the database table question_knowledge
     */
    @Select({
        "select",
        "Id, question_id, knowledge_id",
        "from question_knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="question_id", property="question_id", jdbcType=JdbcType.INTEGER),
        @Result(column="knowledge_id", property="knowledge_id", jdbcType=JdbcType.INTEGER)
    })
    QuestionKnowledge selectByPrimaryKey(Integer id);

    /**
     * the database table question_knowledge
     */
    @UpdateProvider(type=QuestionKnowledgeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QuestionKnowledge record);

    /**
     * the database table question_knowledge
     */
    @Update({
        "update question_knowledge",
        "set question_id = #{question_id,jdbcType=INTEGER},",
          "knowledge_id = #{knowledge_id,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionKnowledge record);
}