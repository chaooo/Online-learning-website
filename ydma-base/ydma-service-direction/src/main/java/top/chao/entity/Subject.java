package top.chao.entity;

public class Subject {
    /**
     * the database column subject.id
     */
    private Integer id;

    /**
     * the database column subject.name
     */
    private String name;

    /**
     * the database column subject.direction_id
     */
    private Integer direction_id;

    /**
     * the database column subject.id
     * @return the value of subject.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column subject.id
     * @param id the value for subject.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column subject.name
     * @return the value of subject.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column subject.name
     * @param name the value for subject.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * the database column subject.direction_id
     * @return the value of subject.direction_id
     */
    public Integer getDirection_id() {
        return direction_id;
    }

    /**
     * the database column subject.direction_id
     * @param direction_id the value for subject.direction_id
     */
    public void setDirection_id(Integer direction_id) {
        this.direction_id = direction_id;
    }
}