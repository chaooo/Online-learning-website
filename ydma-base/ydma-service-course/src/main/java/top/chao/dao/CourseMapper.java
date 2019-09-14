package top.chao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.Course;

public interface CourseMapper {
    /**
     * 通过ID删除课程
     * @param id
     * @return
     */
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加课程
     * @param record
     * @return
     */
    @Insert({
        "insert into course (name, intro, ",
        "learn_count, difficulty, ",
        "score, image, publish_time, ",
        "price, subject_id, ",
        "direction_id, learn_time)",
        "values (#{name,jdbcType=VARCHAR}, #{intro,jdbcType=VARCHAR}, ",
        "#{learn_count,jdbcType=INTEGER}, #{difficulty,jdbcType=VARCHAR}, ",
        "#{score,jdbcType=INTEGER}, #{image,jdbcType=VARCHAR}, #{publish_time,jdbcType=TIMESTAMP}, ",
        "#{price,jdbcType=INTEGER}, #{subject_id,jdbcType=INTEGER}, ",
        "#{direction_id,jdbcType=INTEGER}, #{learn_time,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Course record);

    /**
     * 添加课程 缺省值（动态SQL）
     * @param record
     * @return
     */
    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Course record);

    /**
     * 通过ID 查找课程
     * @param id
     * @return
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="courseMap", value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learn_count", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publish_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subject_id", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="direction_id", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learn_time", jdbcType=JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(Integer id);

    /**
     *  根据科目ID查询课程列表（course表  ）
     * @param subject_id
     * @return
     */
    @SelectProvider(type=CourseSqlProvider.class, method="selectBySubjectId")
    List<Course> selectBySubjectId(String type, Integer subject_id);
    
    /**
     *  根据科目ID查询课程列表（course表  ）根据评分排序
     * @param subject_id
     * @return
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where subject_id = #{subject_id,jdbcType=INTEGER}",
        "order by score desc"
    })
    @ResultMap("courseMap")
    List<Course> selectBySubjectIdAndScore(Integer subject_id);
    
    /**
     * 根据方向ID 查询课程列表（course表  ）
     * @param direction_id
     * @return
     */
    @SelectProvider(type=CourseSqlProvider.class, method="selectByDirectionId")
    List<Course> selectByDirectionId(String type, Integer direction_id);
    
    /**
     * 免费好课查询
     * @return
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where price = 0",
        "order by score desc"
    })
    @ResultMap("courseMap")
    List<Course> selectByPriceFree();
    
    /**
     *  好课推荐查询
     * @return
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "order by learn_count desc,score desc"
    })
    @ResultMap("courseMap")
    List<Course> selectByRecommend();
    
    /**
     *  最新课程
     * @return
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where price = 0",
        "order by publish_time desc"
    })
    @ResultMap("courseMap")
    List<Course> selectByLatest();
    
    /**
     *  课程模糊查询
     * @return
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where name like CONCAT('%',#{keyword,jdbcType=VARCHAR},'%')"
    })
    @ResultMap("courseMap")
    List<Course> selectByKeyword(String keyword);
    
    /**
     * 更新课程（动态SQL）
     * @param record
     * @return
     */
    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    /**
     * 更新课程
     * @param record
     * @return
     */
    @Update({
        "update course",
        "set name = #{name,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "learn_count = #{learn_count,jdbcType=INTEGER},",
          "difficulty = #{difficulty,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "publish_time = #{publish_time,jdbcType=TIMESTAMP},",
          "price = #{price,jdbcType=INTEGER},",
          "subject_id = #{subject_id,jdbcType=INTEGER},",
          "direction_id = #{direction_id,jdbcType=INTEGER},",
          "learn_time = #{learn_time,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
    
}