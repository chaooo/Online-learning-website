package top.chao.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import top.chao.entity.User;

public interface UserMapper {

	/**
	 * 通过主键ID 删除user表中一条数据
	 * @param id
	 * @return
	 */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过User对象 插入一条数据到user表 @param record
     * @return
     */
    @Insert({
        "insert into user (name, password, ",
        "nick_name, position, ",
        "sex, location, signature, ",
        "image, regtime, ",
        "salt)",
        "values (#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{nick_name,jdbcType=VARCHAR}, #{position,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, #{signature,jdbcType=VARCHAR}, ",
        "#{image,jdbcType=VARCHAR}, #{regtime,jdbcType=TIMESTAMP}, ",
        "#{salt,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    /**
     * 通过User对象 插入一条数据(含缺省值)到user表 @param record
     * @return
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(User record);

    /**
     * 通过主键ID 查找user表中一条数据 @param id
     * @return
     */
    @Select({
        "select",
        "id, name, password, nick_name, position, sex, location, signature, image, regtime, ",
        "salt",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="userMap", value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nick_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="regtime", property="regtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    /**
     * 通过name 查找user表中一条数据 @param name
     * @return
     */
    @Select({
        "select",
        "id, name, password, nick_name, position, sex, location, signature, image, regtime, salt",
        "from user",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    @ResultMap("userMap")
    User selectByName(String name);

    /**
     * 通过主键ID 更新一条数据(含缺省值)到user表 @param record
     * @return
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * 通过主键ID 更新一条数据到user表 @param record
     * @return
     */
    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nick_name = #{nick_name,jdbcType=VARCHAR},",
          "position = #{position,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "signature = #{signature,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "regtime = #{regtime,jdbcType=TIMESTAMP},",
          "salt = #{salt,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}