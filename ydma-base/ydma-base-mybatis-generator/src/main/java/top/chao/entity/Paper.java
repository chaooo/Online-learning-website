package top.chao.entity;

import java.util.Date;

public class Paper {
    /**
     * the database column paper.paper_id
     */
    private Integer paper_id;

    /**
     * the database column paper.type_id
     */
    private Integer type_id;

    /**
     * the database column paper.user_id
     */
    private Integer user_id;

    /**
     * the database column paper.subject_id
     */
    private Integer subject_id;

    /**
     * the database column paper.score
     */
    private Integer score;

    /**
     * the database column paper.limit_time
     */
    private Integer limit_time;

    /**
     * the database column paper.createtime
     */
    private Date createtime;

    /**
     * the database column paper.begintime
     */
    private Date begintime;

    /**
     * the database column paper.endtime
     */
    private Date endtime;

    /**
     * the database column paper.status
     */
    private Integer status;

    /**
     * the database column paper.question_total
     */
    private Integer question_total;

    /**
     * the database column paper.name
     */
    private String name;

    /**
     * the database column paper.paper_id
     * @return the value of paper.paper_id
     */
    public Integer getPaper_id() {
        return paper_id;
    }

    /**
     * the database column paper.paper_id
     * @param paper_id the value for paper.paper_id
     */
    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    /**
     * the database column paper.type_id
     * @return the value of paper.type_id
     */
    public Integer getType_id() {
        return type_id;
    }

    /**
     * the database column paper.type_id
     * @param type_id the value for paper.type_id
     */
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    /**
     * the database column paper.user_id
     * @return the value of paper.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column paper.user_id
     * @param user_id the value for paper.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column paper.subject_id
     * @return the value of paper.subject_id
     */
    public Integer getSubject_id() {
        return subject_id;
    }

    /**
     * the database column paper.subject_id
     * @param subject_id the value for paper.subject_id
     */
    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    /**
     * the database column paper.score
     * @return the value of paper.score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * the database column paper.score
     * @param score the value for paper.score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * the database column paper.limit_time
     * @return the value of paper.limit_time
     */
    public Integer getLimit_time() {
        return limit_time;
    }

    /**
     * the database column paper.limit_time
     * @param limit_time the value for paper.limit_time
     */
    public void setLimit_time(Integer limit_time) {
        this.limit_time = limit_time;
    }

    /**
     * the database column paper.createtime
     * @return the value of paper.createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * the database column paper.createtime
     * @param createtime the value for paper.createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * the database column paper.begintime
     * @return the value of paper.begintime
     */
    public Date getBegintime() {
        return begintime;
    }

    /**
     * the database column paper.begintime
     * @param begintime the value for paper.begintime
     */
    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    /**
     * the database column paper.endtime
     * @return the value of paper.endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * the database column paper.endtime
     * @param endtime the value for paper.endtime
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * the database column paper.status
     * @return the value of paper.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * the database column paper.status
     * @param status the value for paper.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * the database column paper.question_total
     * @return the value of paper.question_total
     */
    public Integer getQuestion_total() {
        return question_total;
    }

    /**
     * the database column paper.question_total
     * @param question_total the value for paper.question_total
     */
    public void setQuestion_total(Integer question_total) {
        this.question_total = question_total;
    }

    /**
     * the database column paper.name
     * @return the value of paper.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column paper.name
     * @param name the value for paper.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}