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
import top.chao.entity.LoginHistory;

public interface LoginHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Delete({
        "delete from login_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Insert({
        "insert into login_history (user_id, login_time, ",
        "city, ip)",
        "values (#{user_id,jdbcType=INTEGER}, #{login_time,jdbcType=TIMESTAMP}, ",
        "#{city,jdbcType=VARCHAR}, #{ip,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(LoginHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @InsertProvider(type=LoginHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(LoginHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Select({
        "select",
        "id, user_id, login_time, city, ip",
        "from login_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="login_time", property="login_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    LoginHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @UpdateProvider(type=LoginHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoginHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_history
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @Update({
        "update login_history",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "login_time = #{login_time,jdbcType=TIMESTAMP},",
          "city = #{city,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LoginHistory record);
}