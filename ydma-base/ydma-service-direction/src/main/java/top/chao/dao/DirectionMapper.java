package top.chao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.Direction;

public interface DirectionMapper {
    /**
     * the database table direction
     */
    @Delete({
        "delete from direction",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table direction
     */
    @Insert({
        "insert into direction (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Direction record);

    /**
     * the database table direction
     */
    @InsertProvider(type=DirectionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Direction record);

    /**
     * the database table direction
     */
    @Select({
        "select",
        "id, name",
        "from direction",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Direction selectByPrimaryKey(Integer id);

    
    /**
     * 查找所有方向列表
     * @return
     */
    @Select({
        "select",
        "id, name",
        "from direction"
    })
   
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(property="subjects",javaType=List.class,column="id",
        	many=@Many(select="top.chao.dao.SubjectMapper.selectByDirectionId"))
    })
    List<Direction> selectAll();
    
    /**
     * the database table direction
     */
    @UpdateProvider(type=DirectionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Direction record);

    /**
     * the database table direction
     */
    @Update({
        "update direction",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Direction record);
}