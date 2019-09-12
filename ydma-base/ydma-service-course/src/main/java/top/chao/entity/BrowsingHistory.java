package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BrowsingHistory {
    /**
     * the database column browsing_history.id
     */
    private Integer id;

    /**
     * the database column browsing_history.user_id
     */
    private Integer user_id;

    /**
     * the database column browsing_history.course_id
     */
    private Integer course_id;

    /**
     * the database column browsing_history.browse_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date browse_time;

    /**
     * the database column browsing_history.video_id
     */
    private Integer video_id;
    
    private Course course;

    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
     * the database column browsing_history.id
     * @return the value of browsing_history.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column browsing_history.id
     * @param id the value for browsing_history.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column browsing_history.user_id
     * @return the value of browsing_history.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column browsing_history.user_id
     * @param user_id the value for browsing_history.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column browsing_history.course_id
     * @return the value of browsing_history.course_id
     */
    public Integer getCourse_id() {
        return course_id;
    }

    /**
     * the database column browsing_history.course_id
     * @param course_id the value for browsing_history.course_id
     */
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    /**
     * the database column browsing_history.browse_time
     * @return the value of browsing_history.browse_time
     */
    public Date getBrowse_time() {
        return browse_time;
    }

    /**
     * the database column browsing_history.browse_time
     * @param browse_time the value for browsing_history.browse_time
     */
    public void setBrowse_time(Date browse_time) {
        this.browse_time = browse_time;
    }

    /**
     * the database column browsing_history.video_id
     * @return the value of browsing_history.video_id
     */
    public Integer getVideo_id() {
        return video_id;
    }

    /**
     * the database column browsing_history.video_id
     * @param video_id the value for browsing_history.video_id
     */
    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }
}