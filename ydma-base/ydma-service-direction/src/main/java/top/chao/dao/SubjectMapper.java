package top.chao.dao;

import java.util.List;

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
import top.chao.entity.Subject;

public interface SubjectMapper {
    /**
     * the database table subject
     */
    @Delete({
        "delete from subject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table subject
     */
    @Insert({
        "insert into subject (name, direction_id)",
        "values (#{name,jdbcType=VARCHAR}, #{direction_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Subject record);

    /**
     * the database table subject
     */
    @InsertProvider(type=SubjectSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Subject record);

    /**
     * the database table subject
     */
    @Select({
        "select",
        "id, name, direction_id",
        "from subject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction_id", property="direction_id", jdbcType=JdbcType.INTEGER)
    })
    Subject selectByPrimaryKey(Integer id);

    /** 
     * * 根据direction_id方向Id查找科目集合
     * @param direction_id
     * @return
     */
    @Select({
        "select",
        "id, name, direction_id",
        "from subject",
        "where direction_id = #{direction_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction_id", property="direction_id", jdbcType=JdbcType.INTEGER)
    })
    List<Subject> selectByDirectionId(Integer direction_id);
    
    
    /**
     * the database table subject
     */
    @UpdateProvider(type=SubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Subject record);

    /**
     * the database table subject
     */
    @Update({
        "update subject",
        "set name = #{name,jdbcType=VARCHAR},",
          "direction_id = #{direction_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}