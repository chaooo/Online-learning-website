package top.chao.entity;

import java.util.Date;

public class NoteLike {
    /**
     * the database column note_like.Id
     */
    private Integer id;

    /**
     * the database column note_like.user_id
     */
    private Integer user_id;

    /**
     * the database column note_like.note_id
     */
    private Integer note_id;

    /**
     * the database column note_like.like_time
     */
    private Date like_time;

    /**
     * the database column note_like.Id
     * @return the value of note_like.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column note_like.Id
     * @param id the value for note_like.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column note_like.user_id
     * @return the value of note_like.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column note_like.user_id
     * @param user_id the value for note_like.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column note_like.note_id
     * @return the value of note_like.note_id
     */
    public Integer getNote_id() {
        return note_id;
    }

    /**
     * the database column note_like.note_id
     * @param note_id the value for note_like.note_id
     */
    public void setNote_id(Integer note_id) {
        this.note_id = note_id;
    }

    /**
     * the database column note_like.like_time
     * @return the value of note_like.like_time
     */
    public Date getLike_time() {
        return like_time;
    }

    /**
     * the database column note_like.like_time
     * @param like_time the value for note_like.like_time
     */
    public void setLike_time(Date like_time) {
        this.like_time = like_time;
    }
}