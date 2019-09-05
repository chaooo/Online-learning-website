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
import top.chao.entity.PaperKnowledge;

public interface PaperKnowledgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_knowledge
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Delete({
        "delete from paper_knowledge",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_knowledge
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Insert({
        "insert into paper_knowledge (paper_id, knowledge_id, ",
        "question_num)",
        "values (#{paper_id,jdbcType=INTEGER}, #{knowledge_id,jdbcType=INTEGER}, ",
        "#{question_num,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PaperKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_knowledge
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @InsertProvider(type=PaperKnowledgeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PaperKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_knowledge
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Select({
        "select",
        "id, paper_id, knowledge_id, question_num",
        "from paper_knowledge",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="paper_id", property="paper_id", jdbcType=JdbcType.INTEGER),
        @Result(column="knowledge_id", property="knowledge_id", jdbcType=JdbcType.INTEGER),
        @Result(column="question_num", property="question_num", jdbcType=JdbcType.INTEGER)
    })
    PaperKnowledge selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_knowledge
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @UpdateProvider(type=PaperKnowledgeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_knowledge
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Update({
        "update paper_knowledge",
        "set paper_id = #{paper_id,jdbcType=INTEGER},",
          "knowledge_id = #{knowledge_id,jdbcType=INTEGER},",
          "question_num = #{question_num,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperKnowledge record);
}