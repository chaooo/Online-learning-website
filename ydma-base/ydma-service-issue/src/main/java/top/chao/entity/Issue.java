package top.chao.entity;

import java.util.Date;

public class Issue {
    /**
     * the database column issue.id
     */
    private Integer id;

    /**
     * the database column issue.headline
     */
    private String headline;

    /**
     * the database column issue.issue_context
     */
    private String issue_context;

    /**
     * the database column issue.publish_time
     */
    private Date publish_time;

    /**
     * the database column issue.answer_count
     */
    private Integer answer_count;

    /**
     * the database column issue.browse_count
     */
    private Integer browse_count;

    /**
     * the database column issue.video_id
     */
    private Integer video_id;

    /**
     * the database column issue.user_id
     */
    private Integer user_id;

    /**
     * the database column issue.right_answer_id
     */
    private Integer right_answer_id;
    
    //用于存储正确答案信息
    private Answer answer;
    
    public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	/**
     * the database column issue.id
     * @return the value of issue.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column issue.id
     * @param id the value for issue.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column issue.headline
     * @return the value of issue.headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * the database column issue.headline
     * @param headline the value for issue.headline
     */
    public void setHeadline(String headline) {
        this.headline = headline == null ? null : headline.trim();
    }

    /**
     * the database column issue.issue_context
     * @return the value of issue.issue_context
     */
    public String getIssue_context() {
        return issue_context;
    }

    /**
     * the database column issue.issue_context
     * @param issue_context the value for issue.issue_context
     */
    public void setIssue_context(String issue_context) {
        this.issue_context = issue_context == null ? null : issue_context.trim();
    }

    /**
     * the database column issue.publish_time
     * @return the value of issue.publish_time
     */
    public Date getPublish_time() {
        return publish_time;
    }

    /**
     * the database column issue.publish_time
     * @param publish_time the value for issue.publish_time
     */
    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    /**
     * the database column issue.answer_count
     * @return the value of issue.answer_count
     */
    public Integer getAnswer_count() {
        return answer_count;
    }

    /**
     * the database column issue.answer_count
     * @param answer_count the value for issue.answer_count
     */
    public void setAnswer_count(Integer answer_count) {
        this.answer_count = answer_count;
    }

    /**
     * the database column issue.browse_count
     * @return the value of issue.browse_count
     */
    public Integer getBrowse_count() {
        return browse_count;
    }

    /**
     * the database column issue.browse_count
     * @param browse_count the value for issue.browse_count
     */
    public void setBrowse_count(Integer browse_count) {
        this.browse_count = browse_count;
    }

    /**
     * the database column issue.video_id
     * @return the value of issue.video_id
     */
    public Integer getVideo_id() {
        return video_id;
    }

    /**
     * the database column issue.video_id
     * @param video_id the value for issue.video_id
     */
    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    /**
     * the database column issue.user_id
     * @return the value of issue.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column issue.user_id
     * @param user_id the value for issue.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column issue.right_answer_id
     * @return the value of issue.right_answer_id
     */
    public Integer getRight_answer_id() {
        return right_answer_id;
    }

    /**
     * the database column issue.right_answer_id
     * @param right_answer_id the value for issue.right_answer_id
     */
    public void setRight_answer_id(Integer right_answer_id) {
        this.right_answer_id = right_answer_id;
    }
}