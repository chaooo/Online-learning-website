package top.chao.entity;

import java.util.Date;

public class PaperExamRecord {
    /**
     * the database column paper_exam_record.record_id
     */
    private Integer record_id;

    /**
     * the database column paper_exam_record.user_id
     */
    private Integer user_id;

    /**
     * the database column paper_exam_record.paper_id
     */
    private Integer paper_id;

    /**
     * the database column paper_exam_record.question_id
     */
    private Integer question_id;

    /**
     * the database column paper_exam_record.answer
     */
    private String answer;

    /**
     * the database column paper_exam_record.create_time
     */
    private Date create_time;

    /**
     * the database column paper_exam_record.record_id
     * @return the value of paper_exam_record.record_id
     */
    public Integer getRecord_id() {
        return record_id;
    }

    /**
     * the database column paper_exam_record.record_id
     * @param record_id the value for paper_exam_record.record_id
     */
    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    /**
     * the database column paper_exam_record.user_id
     * @return the value of paper_exam_record.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column paper_exam_record.user_id
     * @param user_id the value for paper_exam_record.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column paper_exam_record.paper_id
     * @return the value of paper_exam_record.paper_id
     */
    public Integer getPaper_id() {
        return paper_id;
    }

    /**
     * the database column paper_exam_record.paper_id
     * @param paper_id the value for paper_exam_record.paper_id
     */
    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    /**
     * the database column paper_exam_record.question_id
     * @return the value of paper_exam_record.question_id
     */
    public Integer getQuestion_id() {
        return question_id;
    }

    /**
     * the database column paper_exam_record.question_id
     * @param question_id the value for paper_exam_record.question_id
     */
    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    /**
     * the database column paper_exam_record.answer
     * @return the value of paper_exam_record.answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * the database column paper_exam_record.answer
     * @param answer the value for paper_exam_record.answer
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * the database column paper_exam_record.create_time
     * @return the value of paper_exam_record.create_time
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * the database column paper_exam_record.create_time
     * @param create_time the value for paper_exam_record.create_time
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}