package top.chao.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import top.chao.entity.PaperExamRecord;

public interface PaperExamRecordMapper {
    /**
     * the database table paper_exam_record
     */
    @Delete({
        "delete from paper_exam_record",
        "where record_id = #{record_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer record_id);

    /**
     * the database table paper_exam_record
     */
    @Insert({
        "insert into paper_exam_record (record_id, user_id, ",
        "paper_id, question_id, ",
        "answer, create_time)",
        "values (#{record_id,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{paper_id,jdbcType=INTEGER}, #{question_id,jdbcType=INTEGER}, ",
        "#{answer,jdbcType=VARCHAR}, #{create_time,jdbcType=TIMESTAMP})"
    })
    int insert(PaperExamRecord record);

    /**
     * the database table paper_exam_record
     */
    @InsertProvider(type=PaperExamRecordSqlProvider.class, method="insertSelective")
    int insertSelective(PaperExamRecord record);

    /**
     * the database table paper_exam_record
     */
    @Select({
        "select",
        "record_id, user_id, paper_id, question_id, answer, create_time",
        "from paper_exam_record",
        "where record_id = #{record_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="record_id", property="record_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="paper_id", property="paper_id", jdbcType=JdbcType.INTEGER),
        @Result(column="question_id", property="question_id", jdbcType=JdbcType.INTEGER),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP)
    })
    PaperExamRecord selectByPrimaryKey(Integer record_id);

    /**
     * the database table paper_exam_record
     */
    @UpdateProvider(type=PaperExamRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperExamRecord record);

    /**
     * the database table paper_exam_record
     */
    @Update({
        "update paper_exam_record",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "paper_id = #{paper_id,jdbcType=INTEGER},",
          "question_id = #{question_id,jdbcType=INTEGER},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "create_time = #{create_time,jdbcType=TIMESTAMP}",
        "where record_id = #{record_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperExamRecord record);
}