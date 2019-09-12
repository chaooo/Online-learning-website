package top.chao.entity;

import java.util.Date;

public class PaperExamReport {
    /**
     * the database column paper_exam_report.report_id
     */
    private Integer report_id;

    /**
     * the database column paper_exam_report.user_id
     */
    private Integer user_id;

    /**
     * the database column paper_exam_report.paper_id
     */
    private Integer paper_id;

    /**
     * the database column paper_exam_report.error_num
     */
    private Integer error_num;

    /**
     * the database column paper_exam_report.right_num
     */
    private Integer right_num;

    /**
     * the database column paper_exam_report.score
     */
    private Double score;

    /**
     * the database column paper_exam_report.submit_time
     */
    private Date submit_time;

    /**
     * the database column paper_exam_report.create_time
     */
    private Date create_time;

    /**
     * the database column paper_exam_report.content
     */
    private String content;

    /**
     * the database column paper_exam_report.report_id
     * @return the value of paper_exam_report.report_id
     */
    public Integer getReport_id() {
        return report_id;
    }

    /**
     * the database column paper_exam_report.report_id
     * @param report_id the value for paper_exam_report.report_id
     */
    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    /**
     * the database column paper_exam_report.user_id
     * @return the value of paper_exam_report.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column paper_exam_report.user_id
     * @param user_id the value for paper_exam_report.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column paper_exam_report.paper_id
     * @return the value of paper_exam_report.paper_id
     */
    public Integer getPaper_id() {
        return paper_id;
    }

    /**
     * the database column paper_exam_report.paper_id
     * @param paper_id the value for paper_exam_report.paper_id
     */
    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    /**
     * the database column paper_exam_report.error_num
     * @return the value of paper_exam_report.error_num
     */
    public Integer getError_num() {
        return error_num;
    }

    /**
     * the database column paper_exam_report.error_num
     * @param error_num the value for paper_exam_report.error_num
     */
    public void setError_num(Integer error_num) {
        this.error_num = error_num;
    }

    /**
     * the database column paper_exam_report.right_num
     * @return the value of paper_exam_report.right_num
     */
    public Integer getRight_num() {
        return right_num;
    }

    /**
     * the database column paper_exam_report.right_num
     * @param right_num the value for paper_exam_report.right_num
     */
    public void setRight_num(Integer right_num) {
        this.right_num = right_num;
    }

    /**
     * the database column paper_exam_report.score
     * @return the value of paper_exam_report.score
     */
    public Double getScore() {
        return score;
    }

    /**
     * the database column paper_exam_report.score
     * @param score the value for paper_exam_report.score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * the database column paper_exam_report.submit_time
     * @return the value of paper_exam_report.submit_time
     */
    public Date getSubmit_time() {
        return submit_time;
    }

    /**
     * the database column paper_exam_report.submit_time
     * @param submit_time the value for paper_exam_report.submit_time
     */
    public void setSubmit_time(Date submit_time) {
        this.submit_time = submit_time;
    }

    /**
     * the database column paper_exam_report.create_time
     * @return the value of paper_exam_report.create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * the database column paper_exam_report.create_time
     * @param create_time the value for paper_exam_report.create_time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * the database column paper_exam_report.content
     * @return the value of paper_exam_report.content
     */
    public String getContent() {
        return content;
    }

    /**
     * the database column paper_exam_report.content
     * @param content the value for paper_exam_report.content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}