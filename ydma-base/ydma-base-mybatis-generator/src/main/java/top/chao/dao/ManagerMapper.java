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
import top.chao.entity.Manager;

public interface ManagerMapper {
    /**
     * the database table manager
     */
    @Delete({
        "delete from manager",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * the database table manager
     */
    @Insert({
        "insert into manager (username, password, ",
        "nickname, email, ",
        "phone, realname, ",
        "last_login_time, regist_time, ",
        "sex)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
        "#{last_login_time,jdbcType=TIMESTAMP}, #{regist_time,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Manager record);

    /**
     * the database table manager
     */
    @InsertProvider(type=ManagerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Manager record);

    /**
     * the database table manager
     */
    @Select({
        "select",
        "Id, username, password, nickname, email, phone, realname, last_login_time, regist_time, ",
        "sex",
        "from manager",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_login_time", property="last_login_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="regist_time", property="regist_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR)
    })
    Manager selectByPrimaryKey(Integer id);

    /**
     * the database table manager
     */
    @UpdateProvider(type=ManagerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Manager record);

    /**
     * the database table manager
     */
    @Update({
        "update manager",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "last_login_time = #{last_login_time,jdbcType=TIMESTAMP},",
          "regist_time = #{regist_time,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Manager record);
}