package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Note {
    /**
     * the database column note.id
     */
    private Integer id;

    /**
     * the database column note.publish_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publish_time;

    /**
     * the database column note.like_count
     */
    private Integer like_count;

    /**
     * the database column note.user_id
     */
    private Integer user_id;

    /**
     * the database column note.video_id
     */
    private Integer video_id;

    /**
     * the database column note.title
     */
    private String title;

    /**
     * the database column note.context
     */
    private String context;

    /**
     * the database column note.id
     * @return the value of note.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column note.id
     * @param id the value for note.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column note.publish_time
     * @return the value of note.publish_time
     */
    public Date getPublish_time() {
        return publish_time;
    }

    /**
     * the database column note.publish_time
     * @param publish_time the value for note.publish_time
     */
    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    /**
     * the database column note.like_count
     * @return the value of note.like_count
     */
    public Integer getLike_count() {
        return like_count;
    }

    /**
     * the database column note.like_count
     * @param like_count the value for note.like_count
     */
    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    /**
     * the database column note.user_id
     * @return the value of note.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column note.user_id
     * @param user_id the value for note.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column note.video_id
     * @return the value of note.video_id
     */
    public Integer getVideo_id() {
        return video_id;
    }

    /**
     * the database column note.video_id
     * @param video_id the value for note.video_id
     */
    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    /**
     * the database column note.title
     * @return the value of note.title
     */
    public String getTitle() {
        return title;
    }

    /**
     * the database column note.title
     * @param title the value for note.title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * the database column note.context
     * @return the value of note.context
     */
    public String getContext() {
        return context;
    }

    /**
     * the database column note.context
     * @param context the value for note.context
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}