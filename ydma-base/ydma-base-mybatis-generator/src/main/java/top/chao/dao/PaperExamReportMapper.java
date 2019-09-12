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
import top.chao.entity.PaperExamReport;

public interface PaperExamReportMapper {
    /**
     * the database table paper_exam_report
     */
    @Delete({
        "delete from paper_exam_report",
        "where report_id = #{report_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer report_id);

    /**
     * the database table paper_exam_report
     */
    @Insert({
        "insert into paper_exam_report (report_id, user_id, ",
        "paper_id, error_num, ",
        "right_num, score, ",
        "submit_time, create_time, ",
        "content)",
        "values (#{report_id,jdbcType=INTEGER}, #{user_id,jdbcType=INTEGER}, ",
        "#{paper_id,jdbcType=INTEGER}, #{error_num,jdbcType=INTEGER}, ",
        "#{right_num,jdbcType=INTEGER}, #{score,jdbcType=DOUBLE}, ",
        "#{submit_time,jdbcType=TIMESTAMP}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(PaperExamReport record);

    /**
     * the database table paper_exam_report
     */
    @InsertProvider(type=PaperExamReportSqlProvider.class, method="insertSelective")
    int insertSelective(PaperExamReport record);

    /**
     * the database table paper_exam_report
     */
    @Select({
        "select",
        "report_id, user_id, paper_id, error_num, right_num, score, submit_time, create_time, ",
        "content",
        "from paper_exam_report",
        "where report_id = #{report_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="report_id", property="report_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.INTEGER),
        @Result(column="paper_id", property="paper_id", jdbcType=JdbcType.INTEGER),
        @Result(column="error_num", property="error_num", jdbcType=JdbcType.INTEGER),
        @Result(column="right_num", property="right_num", jdbcType=JdbcType.INTEGER),
        @Result(column="score", property="score", jdbcType=JdbcType.DOUBLE),
        @Result(column="submit_time", property="submit_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    PaperExamReport selectByPrimaryKey(Integer report_id);

    /**
     * the database table paper_exam_report
     */
    @UpdateProvider(type=PaperExamReportSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperExamReport record);

    /**
     * the database table paper_exam_report
     */
    @Update({
        "update paper_exam_report",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "paper_id = #{paper_id,jdbcType=INTEGER},",
          "error_num = #{error_num,jdbcType=INTEGER},",
          "right_num = #{right_num,jdbcType=INTEGER},",
          "score = #{score,jdbcType=DOUBLE},",
          "submit_time = #{submit_time,jdbcType=TIMESTAMP},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where report_id = #{report_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(PaperExamReport record);

    /**
     * the database table paper_exam_report
     */
    @Update({
        "update paper_exam_report",
        "set user_id = #{user_id,jdbcType=INTEGER},",
          "paper_id = #{paper_id,jdbcType=INTEGER},",
          "error_num = #{error_num,jdbcType=INTEGER},",
          "right_num = #{right_num,jdbcType=INTEGER},",
          "score = #{score,jdbcType=DOUBLE},",
          "submit_time = #{submit_time,jdbcType=TIMESTAMP},",
          "create_time = #{create_time,jdbcType=TIMESTAMP}",
        "where report_id = #{report_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperExamReport record);
}