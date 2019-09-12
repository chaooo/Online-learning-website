package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EvaluationLike {
    /**
     * the database column evaluation_like.Id
     */
    private Integer id;

    /**
     * the database column evaluation_like.evaluation_id
     */
    private Integer evaluation_id;

    /**
     * the database column evaluation_like.user_id
     */
    private Integer user_id;

    /**
     * the database column evaluation_like.like_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date like_time;

    /**
     * the database column evaluation_like.Id
     * @return the value of evaluation_like.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column evaluation_like.Id
     * @param id the value for evaluation_like.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column evaluation_like.evaluation_id
     * @return the value of evaluation_like.evaluation_id
     */
    public Integer getEvaluation_id() {
        return evaluation_id;
    }

    /**
     * the database column evaluation_like.evaluation_id
     * @param evaluation_id the value for evaluation_like.evaluation_id
     */
    public void setEvaluation_id(Integer evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    /**
     * the database column evaluation_like.user_id
     * @return the value of evaluation_like.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column evaluation_like.user_id
     * @param user_id the value for evaluation_like.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column evaluation_like.like_time
     * @return the value of evaluation_like.like_time
     */
    public Date getLike_time() {
        return like_time;
    }

    /**
     * the database column evaluation_like.like_time
     * @param like_time the value for evaluation_like.like_time
     */
    public void setLike_time(Date like_time) {
        this.like_time = like_time;
    }
}