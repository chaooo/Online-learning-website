package top.chao.entity;

import java.util.Date;

public class Answer {
    /**
     * the database column answer.id
     */
    private Integer id;

    /**
     * the database column answer.context
     */
    private String context;

    /**
     * the database column answer.publish_time
     */
    private Date publish_time;

    /**
     * the database column answer.issue_id
     */
    private Integer issue_id;

    /**
     * the database column answer.user_id
     */
    private Integer user_id;

    /**
     * the database column answer.id
     * @return the value of answer.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column answer.id
     * @param id the value for answer.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column answer.context
     * @return the value of answer.context
     */
    public String getContext() {
        return context;
    }

    /**
     * the database column answer.context
     * @param context the value for answer.context
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * the database column answer.publish_time
     * @return the value of answer.publish_time
     */
    public Date getPublish_time() {
        return publish_time;
    }

    /**
     * the database column answer.publish_time
     * @param publish_time the value for answer.publish_time
     */
    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    /**
     * the database column answer.issue_id
     * @return the value of answer.issue_id
     */
    public Integer getIssue_id() {
        return issue_id;
    }

    /**
     * the database column answer.issue_id
     * @param issue_id the value for answer.issue_id
     */
    public void setIssue_id(Integer issue_id) {
        this.issue_id = issue_id;
    }

    /**
     * the database column answer.user_id
     * @return the value of answer.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column answer.user_id
     * @param user_id the value for answer.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}