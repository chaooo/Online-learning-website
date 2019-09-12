package top.chao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.CollectCourse;
import top.chao.entity.Course;

public interface CollectCourseMapper {
    /**
     * table： collect_course
     */
    @Delete({
        "delete from collect_course",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * table： collect_course
     */
    @Insert({
        "insert into collect_course (user_id, course_id, ",
        "collect_time)",
        "values (#{user_id,jdbcType=INTEGER}, #{course_id,jdbcType=INTEGER}, ",
        "#{collect_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CollectCourse record);

    /**
     * table： collect_course
     */
    @InsertProvider(type=CollectCourseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CollectCourse record);

    /**
     * table： collect_course
     */
    @Select({
        "select",
        "Id, user_id, course_id, collect_time",
        "from collect_course",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collect_time", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectCourse selectByPrimaryKey(Integer id);
    
    /**
     * 根据用户ID和课程Id查询收藏
     * @param id
     * @return
     */
    @Select({
        "select",
        "Id, user_id, course_id, collect_time",
        "from collect_course",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "and course_id =  #{course_id,jdbcType=INTEGER} limit 0,1"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collect_time", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectCourse selectByUserIdAndCourseId(Integer user_id, Integer course_id);
    
    /**
     * 根据用户ID查询收藏列表
     * @param id
     * @return
     */
    @Select({
        "select",
        "Id, user_id, course_id, collect_time",
        "from collect_course",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collect_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(property="course",javaType=Course.class,column="course_id",
    	one=@One(select="top.chao.dao.CourseMapper.selectByPrimaryKey"))
    })
    List<CollectCourse> selectByUserId(Integer user_id);
    
    
    /**
     * table： collect_course
     */
    @UpdateProvider(type=CollectCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectCourse record);

    /**
     * table： collect_course
     */
    @Update({
        "update collect_course",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "course_id = #{course_id,jdbcType=INTEGER},",
          "collect_time = #{collect_time,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CollectCourse record);
}