package top.chao.entity;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable{
    /**
     * the database column course.id
     */
    private Integer id;

    /**
     * the database column course.name
     */
    private String name;

    /**
     * the database column course.intro
     */
    private String intro;

    /**
     * the database column course.learn_count
     */
    private Integer learn_count;

    /**
     * the database column course.difficulty
     */
    private String difficulty;

    /**
     * the database column course.score
     */
    private Integer score;

    /**
     * the database column course.image
     */
    private String image;

    /**
     * the database column course.publish_time
     */
    private Date publish_time;

    /**
     * the database column course.price
     */
    private Integer price;

    /**
     * the database column course.subject_id
     */
    private Integer subject_id;

    /**
     * the database column course.direction_id
     */
    private Integer direction_id;

    /**
     * the database column course.learn_time
     */
    private Integer learn_time;

    /**
     * the database column course.id
     * @return the value of course.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column course.id
     * @param id the value for course.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column course.name
     * @return the value of course.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column course.name
     * @param name the value for course.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * the database column course.intro
     * @return the value of course.intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * the database column course.intro
     * @param intro the value for course.intro
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * the database column course.learn_count
     * @return the value of course.learn_count
     */
    public Integer getLearn_count() {
        return learn_count;
    }

    /**
     * the database column course.learn_count
     * @param learn_count the value for course.learn_count
     */
    public void setLearn_count(Integer learn_count) {
        this.learn_count = learn_count;
    }

    /**
     * the database column course.difficulty
     * @return the value of course.difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * the database column course.difficulty
     * @param difficulty the value for course.difficulty
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    /**
     * the database column course.score
     * @return the value of course.score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * the database column course.score
     * @param score the value for course.score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * the database column course.image
     * @return the value of course.image
     */
    public String getImage() {
        return image;
    }

    /**
     * the database column course.image
     * @param image the value for course.image
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * the database column course.publish_time
     * @return the value of course.publish_time
     */
    public Date getPublish_time() {
        return publish_time;
    }

    /**
     * the database column course.publish_time
     * @param publish_time the value for course.publish_time
     */
    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    /**
     * the database column course.price
     * @return the value of course.price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * the database column course.price
     * @param price the value for course.price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * the database column course.subject_id
     * @return the value of course.subject_id
     */
    public Integer getSubject_id() {
        return subject_id;
    }

    /**
     * the database column course.subject_id
     * @param subject_id the value for course.subject_id
     */
    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    /**
     * the database column course.direction_id
     * @return the value of course.direction_id
     */
    public Integer getDirection_id() {
        return direction_id;
    }

    /**
     * the database column course.direction_id
     * @param direction_id the value for course.direction_id
     */
    public void setDirection_id(Integer direction_id) {
        this.direction_id = direction_id;
    }

    /**
     * the database column course.learn_time
     * @return the value of course.learn_time
     */
    public Integer getLearn_time() {
        return learn_time;
    }

    /**
     * the database column course.learn_time
     * @param learn_time the value for course.learn_time
     */
    public void setLearn_time(Integer learn_time) {
        this.learn_time = learn_time;
    }
}