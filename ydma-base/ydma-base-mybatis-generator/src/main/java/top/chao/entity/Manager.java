package top.chao.entity;

import java.util.Date;

public class Manager {
    /**
     * the database column manager.Id
     */
    private Integer id;

    /**
     * the database column manager.username
     */
    private String username;

    /**
     * the database column manager.password
     */
    private String password;

    /**
     * the database column manager.nickname
     */
    private String nickname;

    /**
     * the database column manager.email
     */
    private String email;

    /**
     * the database column manager.phone
     */
    private String phone;

    /**
     * the database column manager.realname
     */
    private String realname;

    /**
     * the database column manager.last_login_time
     */
    private Date last_login_time;

    /**
     * the database column manager.regist_time
     */
    private String regist_time;

    /**
     * the database column manager.sex
     */
    private String sex;

    /**
     * the database column manager.Id
     * @return the value of manager.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column manager.Id
     * @param id the value for manager.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column manager.username
     * @return the value of manager.username
     */
    public String getUsername() {
        return username;
    }

    /**
     * the database column manager.username
     * @param username the value for manager.username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * the database column manager.password
     * @return the value of manager.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * the database column manager.password
     * @param password the value for manager.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * the database column manager.nickname
     * @return the value of manager.nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * the database column manager.nickname
     * @param nickname the value for manager.nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * the database column manager.email
     * @return the value of manager.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * the database column manager.email
     * @param email the value for manager.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * the database column manager.phone
     * @return the value of manager.phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * the database column manager.phone
     * @param phone the value for manager.phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * the database column manager.realname
     * @return the value of manager.realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * the database column manager.realname
     * @param realname the value for manager.realname
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * the database column manager.last_login_time
     * @return the value of manager.last_login_time
     */
    public Date getLast_login_time() {
        return last_login_time;
    }

    /**
     * the database column manager.last_login_time
     * @param last_login_time the value for manager.last_login_time
     */
    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    /**
     * the database column manager.regist_time
     * @return the value of manager.regist_time
     */
    public String getRegist_time() {
        return regist_time;
    }

    /**
     * the database column manager.regist_time
     * @param regist_time the value for manager.regist_time
     */
    public void setRegist_time(String regist_time) {
        this.regist_time = regist_time == null ? null : regist_time.trim();
    }

    /**
     * the database column manager.sex
     * @return the value of manager.sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * the database column manager.sex
     * @param sex the value for manager.sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}