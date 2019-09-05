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
import top.chao.entity.CollectNote;

public interface CollectNoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Delete({
        "delete from collect_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Insert({
        "insert into collect_note (user_id, note_id, ",
        "collect_time)",
        "values (#{user_id,jdbcType=INTEGER}, #{note_id,jdbcType=INTEGER}, ",
        "#{collect_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CollectNote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @InsertProvider(type=CollectNoteSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CollectNote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Select({
        "select",
        "id, user_id, note_id, collect_time",
        "from collect_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="note_id", property="note_id", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collect_time", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectNote selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @UpdateProvider(type=CollectNoteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectNote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Update({
        "update collect_note",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "note_id = #{note_id,jdbcType=INTEGER},",
          "collect_time = #{collect_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CollectNote record);
}