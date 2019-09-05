package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @JsonIgnore
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nick_name
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String nick_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.position
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sex
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.location
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.signature
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String signature;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.image
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.regtime
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date regtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.salt
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    private String salt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nick_name
     *
     * @return the value of user.nick_name
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getNick_name() {
        return nick_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nick_name
     *
     * @param nick_name the value for user.nick_name
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.position
     *
     * @return the value of user.position
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.position
     *
     * @param position the value for user.position
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sex
     *
     * @return the value of user.sex
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sex
     *
     * @param sex the value for user.sex
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.location
     *
     * @return the value of user.location
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.location
     *
     * @param location the value for user.location
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.signature
     *
     * @return the value of user.signature
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getSignature() {
        return signature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.signature
     *
     * @param signature the value for user.signature
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.image
     *
     * @return the value of user.image
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.image
     *
     * @param image the value for user.image
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.regtime
     *
     * @return the value of user.regtime
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.regtime
     *
     * @param regtime the value for user.regtime
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.salt
     *
     * @return the value of user.salt
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    @JsonIgnore
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.salt
     *
     * @param salt the value for user.salt
     *
     * @mbg.generated Mon Sep 02 21:19:46 CST 2019
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}