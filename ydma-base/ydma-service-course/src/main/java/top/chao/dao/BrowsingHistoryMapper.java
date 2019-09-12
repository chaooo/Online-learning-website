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
import top.chao.entity.BrowsingHistory;
import top.chao.entity.Course;

public interface BrowsingHistoryMapper {
    /**
     * the database table browsing_history
     */
    @Delete({
        "delete from browsing_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table browsing_history
     */
    @Insert({
        "insert into browsing_history (user_id, course_id, ",
        "browse_time, video_id)",
        "values (#{user_id,jdbcType=INTEGER}, #{course_id,jdbcType=INTEGER}, ",
        "#{browse_time,jdbcType=TIMESTAMP}, #{video_id,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(BrowsingHistory record);

    /**
     * the database table browsing_history
     */
    @InsertProvider(type=BrowsingHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(BrowsingHistory record);

    /**
     * the database table browsing_history
     */
    @Select({
        "select",
        "id, user_id, course_id, browse_time, video_id",
        "from browsing_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_time", property="browse_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER)
    })
    BrowsingHistory selectByPrimaryKey(Integer id);
    
    
    /**
     * 最近学习
     */
    @Select({
        "select",
        "id, user_id, course_id, browse_time, video_id",
        "from browsing_history",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="course_id", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_time", property="browse_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="video_id", jdbcType=JdbcType.INTEGER),
        @Result(property="course",javaType=Course.class,column="course_id",
    	one=@One(select="top.chao.dao.CourseMapper.selectByPrimaryKey"))
    })
    List<BrowsingHistory> selectByUserId(Integer user_id);

    /**
     * the database table browsing_history
     */
    @UpdateProvider(type=BrowsingHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BrowsingHistory record);

    /**
     * the database table browsing_history
     */
    @Update({
        "update browsing_history",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "course_id = #{course_id,jdbcType=INTEGER},",
          "browse_time = #{browse_time,jdbcType=TIMESTAMP},",
          "video_id = #{video_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BrowsingHistory record);
}