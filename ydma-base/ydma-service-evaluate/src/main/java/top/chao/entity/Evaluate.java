package top.chao.entity;

import java.util.Date;

public class Evaluate {
    /**
     * the database column evaluate.id
     */
    private Integer id;

    /**
     * the database column evaluate.user_id
     */
    private Integer user_id;

    /**
     * the database column evaluate.context
     */
    private String context;

    /**
     * the database column evaluate.publish_time
     */
    private Date publish_time;

    /**
     * the database column evaluate.video_id
     */
    private Integer video_id;

    /**
     * the database column evaluate.like_count
     */
    private Integer like_count;

    /**
     * the database column evaluate.id
     * @return the value of evaluate.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column evaluate.id
     * @param id the value for evaluate.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column evaluate.user_id
     * @return the value of evaluate.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column evaluate.user_id
     * @param user_id the value for evaluate.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column evaluate.context
     * @return the value of evaluate.context
     */
    public String getContext() {
        return context;
    }

    /**
     * the database column evaluate.context
     * @param context the value for evaluate.context
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * the database column evaluate.publish_time
     * @return the value of evaluate.publish_time
     */
    public Date getPublish_time() {
        return publish_time;
    }

    /**
     * the database column evaluate.publish_time
     * @param publish_time the value for evaluate.publish_time
     */
    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    /**
     * the database column evaluate.video_id
     * @return the value of evaluate.video_id
     */
    public Integer getVideo_id() {
        return video_id;
    }

    /**
     * the database column evaluate.video_id
     * @param video_id the value for evaluate.video_id
     */
    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    /**
     * the database column evaluate.like_count
     * @return the value of evaluate.like_count
     */
    public Integer getLike_count() {
        return like_count;
    }

    /**
     * the database column evaluate.like_count
     * @param like_count the value for evaluate.like_count
     */
    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }
}