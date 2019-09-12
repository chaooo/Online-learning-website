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
import top.chao.entity.Knowledge;

public interface KnowledgeMapper {
    /**
     * the database table knowledge
     */
    @Delete({
        "delete from knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table knowledge
     */
    @Insert({
        "insert into knowledge (name, subject_id, ",
        "chapter_id)",
        "values (#{name,jdbcType=VARCHAR}, #{subject_id,jdbcType=INTEGER}, ",
        "#{chapter_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Knowledge record);

    /**
     * the database table knowledge
     */
    @InsertProvider(type=KnowledgeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Knowledge record);

    /**
     * the database table knowledge
     */
    @Select({
        "select",
        "Id, name, subject_id, chapter_id",
        "from knowledge",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_id", property="subject_id", jdbcType=JdbcType.INTEGER),
        @Result(column="chapter_id", property="chapter_id", jdbcType=JdbcType.INTEGER)
    })
    Knowledge selectByPrimaryKey(Integer id);

    /**
     * the database table knowledge
     */
    @UpdateProvider(type=KnowledgeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Knowledge record);

    /**
     * the database table knowledge
     */
    @Update({
        "update knowledge",
        "set name = #{name,jdbcType=VARCHAR},",
          "subject_id = #{subject_id,jdbcType=INTEGER},",
          "chapter_id = #{chapter_id,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Knowledge record);
}