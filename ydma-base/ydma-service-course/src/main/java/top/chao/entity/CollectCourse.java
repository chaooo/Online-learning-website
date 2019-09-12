package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CollectCourse {
    /**
     * the database column collect_course.Id
     */
    private Integer id;

    /**
     * the database column collect_course.user_id
     */
    private Integer user_id;

    /**
     * the database column collect_course.course_id
     */
    private Integer course_id;

    /**
     * the database column collect_course.collect_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date collect_time;
    
    //课程详情
    private Course course;

    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
     * the database column collect_course.Id
     * @return the value of collect_course.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column collect_course.Id
     * @param id the value for collect_course.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column collect_course.user_id
     * @return the value of collect_course.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column collect_course.user_id
     * @param user_id the value for collect_course.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column collect_course.course_id
     * @return the value of collect_course.course_id
     */
    public Integer getCourse_id() {
        return course_id;
    }

    /**
     * the database column collect_course.course_id
     * @param course_id the value for collect_course.course_id
     */
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    /**
     * the database column collect_course.collect_time
     * @return the value of collect_course.collect_time
     */
    public Date getCollect_time() {
        return collect_time;
    }

    /**
     * the database column collect_course.collect_time
     * @param collect_time the value for collect_course.collect_time
     */
    public void setCollect_time(Date collect_time) {
        this.collect_time = collect_time;
    }
}