package top.chao.entity;

import java.util.Date;

public class LoginHistory {
    /**
     * the database column login_history.id
     */
    private Integer id;

    /**
     * the database column login_history.user_id
     */
    private Integer user_id;

    /**
     * the database column login_history.login_time
     */
    private Date login_time;

    /**
     * the database column login_history.city
     */
    private String city;

    /**
     * the database column login_history.ip
     */
    private String ip;

    /**
     * the database column login_history.id
     * @return the value of login_history.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column login_history.id
     * @param id the value for login_history.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column login_history.user_id
     * @return the value of login_history.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column login_history.user_id
     * @param user_id the value for login_history.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column login_history.login_time
     * @return the value of login_history.login_time
     */
    public Date getLogin_time() {
        return login_time;
    }

    /**
     * the database column login_history.login_time
     * @param login_time the value for login_history.login_time
     */
    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    /**
     * the database column login_history.city
     * @return the value of login_history.city
     */
    public String getCity() {
        return city;
    }

    /**
     * the database column login_history.city
     * @param city the value for login_history.city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * the database column login_history.ip
     * @return the value of login_history.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * the database column login_history.ip
     * @param ip the value for login_history.ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}