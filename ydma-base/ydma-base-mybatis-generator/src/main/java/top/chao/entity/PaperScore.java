package top.chao.entity;

import java.util.Date;

public class PaperScore {
    /**
     * the database column paper_score.Id
     */
    private Integer id;

    /**
     * the database column paper_score.total_score
     */
    private Integer total_score;

    /**
     * the database column paper_score.my_score
     */
    private Integer my_score;

    /**
     * the database column paper_score.start_time
     */
    private Date start_time;

    /**
     * the database column paper_score.end_time
     */
    private Date end_time;

    /**
     * the database column paper_score.paper_id
     */
    private Integer paper_id;

    /**
     * the database column paper_score.user_id
     */
    private Integer user_id;

    /**
     * the database column paper_score.Id
     * @return the value of paper_score.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column paper_score.Id
     * @param id the value for paper_score.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column paper_score.total_score
     * @return the value of paper_score.total_score
     */
    public Integer getTotal_score() {
        return total_score;
    }

    /**
     * the database column paper_score.total_score
     * @param total_score the value for paper_score.total_score
     */
    public void setTotal_score(Integer total_score) {
        this.total_score = total_score;
    }

    /**
     * the database column paper_score.my_score
     * @return the value of paper_score.my_score
     */
    public Integer getMy_score() {
        return my_score;
    }

    /**
     * the database column paper_score.my_score
     * @param my_score the value for paper_score.my_score
     */
    public void setMy_score(Integer my_score) {
        this.my_score = my_score;
    }

    /**
     * the database column paper_score.start_time
     * @return the value of paper_score.start_time
     */
    public Date getStart_time() {
        return start_time;
    }

    /**
     * the database column paper_score.start_time
     * @param start_time the value for paper_score.start_time
     */
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    /**
     * the database column paper_score.end_time
     * @return the value of paper_score.end_time
     */
    public Date getEnd_time() {
        return end_time;
    }

    /**
     * the database column paper_score.end_time
     * @param end_time the value for paper_score.end_time
     */
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    /**
     * the database column paper_score.paper_id
     * @return the value of paper_score.paper_id
     */
    public Integer getPaper_id() {
        return paper_id;
    }

    /**
     * the database column paper_score.paper_id
     * @param paper_id the value for paper_score.paper_id
     */
    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    /**
     * the database column paper_score.user_id
     * @return the value of paper_score.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column paper_score.user_id
     * @param user_id the value for paper_score.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}