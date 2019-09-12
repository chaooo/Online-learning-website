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
import top.chao.entity.Chapter;

public interface ChapterMapper {
    /**
     * the database table chapter
     */
    @Delete({
        "delete from chapter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table chapter
     */
    @Insert({
        "insert into chapter (name, course_id)",
        "values (#{name,jdbcType=VARCHAR}, #{course_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Chapter record);

    /**
     * the database table chapter
     */
    @InsertProvider(type=ChapterSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Chapter record);

    /**
     * the database table chapter
     */
    @Select({
        "select",
        "id, name, course_id",
        "from chapter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER)
    })
    Chapter selectByPrimaryKey(Integer id);
    
    /**
     * 根据课程Id查询章节列表
     * @param course_id
     * @return
     */
    @Select({
        "select",
        "id, name, course_id",
        "from chapter",
        "where course_id = #{course_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER),
        @Result(property="videos", javaType=List.class, column="id", many=@Many(select="top.chao.dao.VideoMapper.selectByChapterId"))
    })
    List<Chapter> selectByCourseId(Integer course_id);
    
    /**
     * the database table chapter
     */
    @UpdateProvider(type=ChapterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Chapter record);

    /**
     * the database table chapter
     */
    @Update({
        "update chapter",
        "set name = #{name,jdbcType=VARCHAR},",
          "course_id = #{course_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Chapter record);
}