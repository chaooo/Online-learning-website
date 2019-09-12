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
import top.chao.entity.CollectNote;
import top.chao.entity.Note;

public interface CollectNoteMapper {
    /**
     * the database table collect_note
     */
    @Delete({
        "delete from collect_note",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 根据用户ID和笔记ID取消收藏
     * @param user_id
     * @param note_id
     * @return
     */
    @Delete({
        "delete from collect_note",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "and note_id = #{note_id,jdbcType=INTEGER}"
    })
    int deleteByUserIdAndNoteId(Integer user_id,Integer note_id);

    /**
     * the database table collect_note
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
     * the database table collect_note
     */
    @InsertProvider(type=CollectNoteSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CollectNote record);

    /**
     * the database table collect_note
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
     * 根据用户id和笔记id查询笔记收藏记录
     * @param user_id
     * @param note_id
     * @return
     */
    @Select({
        "select",
        "id, user_id, note_id, collect_time",
        "from collect_note",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "and note_id = #{note_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="note_id", property="note_id", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collect_time", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectNote selectByUserIdAndNoteId(Integer user_id, Integer note_id);

    /**
     * 根据用户id 查询笔记收藏记录
     * @param user_id
     * @return
     */
    @Select({
        "select",
        "id, user_id, note_id, collect_time",
        "from collect_note",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="note_id", property="note_id", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collect_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(property="note",javaType=Note.class,column="note_id",
    	one=@One(select="top.chao.dao.NoteMapper.selectByPrimaryKey"))
    })
    List<CollectNote> selectByUserId(Integer user_id);
    
    /**
     * the database table collect_note
     */
    @UpdateProvider(type=CollectNoteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectNote record);

    /**
     * the database table collect_note
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