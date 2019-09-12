package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    /**
     * the database column user.id
     */
    private Integer id;

    /**
     * the database column user.name
     */
    private String name;

    /**
     * the database column user.password
     */
    @JsonIgnore
    private String password;

    /**
     * the database column user.nick_name
     */
    private String nick_name;

    /**
     * the database column user.position
     */
    private String position;

    /**
     * the database column user.sex
     */
    private String sex;

    /**
     * the database column user.location
     */
    private String location;

    /**
     * the database column user.signature
     */
    private String signature;

    /**
     * the database column user.image
     */
    private String image;

    /**
     * the database column user.regtime
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date regtime;

    /**
     * the database column user.salt
     */
    @JsonIgnore
    private String salt;

    /**
     * the database column user.id @return the value of user.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column user.id @param id the value for user.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column user.name @return the value of user.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column user.name @param name the value for user.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * the database column user.password @return the value of user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * the database column user.password @param password the value for user.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * the database column user.nick_name @return the value of user.nick_name
     */
    public String getNick_name() {
        return nick_name;
    }

    /**
     * the database column user.nick_name @param nick_name the value for user.nick_name
     */
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    /**
     * the database column user.position @return the value of user.position
     */
    public String getPosition() {
        return position;
    }

    /**
     * the database column user.position @param position the value for user.position
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * the database column user.sex @return the value of user.sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * the database column user.sex @param sex the value for user.sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * the database column user.location @return the value of user.location
     */
    public String getLocation() {
        return location;
    }

    /**
     * the database column user.location @param location the value for user.location
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * the database column user.signature @return the value of user.signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * the database column user.signature @param signature the value for user.signature
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * the database column user.image @return the value of user.image
     */
    public String getImage() {
        return image;
    }

    /**
     * the database column user.image @param image the value for user.image
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * the database column user.regtime @return the value of user.regtime
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * the database column user.regtime @param regtime the value for user.regtime
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    /**
     * the database column user.salt @return the value of user.salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * the database column user.salt @param salt the value for user.salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}