package top.chao.entity;

public class Knowledge {
    /**
     * the database column knowledge.Id
     */
    private Integer id;

    /**
     * the database column knowledge.name
     */
    private String name;

    /**
     * the database column knowledge.subject_id
     */
    private Integer subject_id;

    /**
     * the database column knowledge.chapter_id
     */
    private Integer chapter_id;

    /**
     * the database column knowledge.Id
     * @return the value of knowledge.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column knowledge.Id
     * @param id the value for knowledge.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column knowledge.name
     * @return the value of knowledge.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column knowledge.name
     * @param name the value for knowledge.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * the database column knowledge.subject_id
     * @return the value of knowledge.subject_id
     */
    public Integer getSubject_id() {
        return subject_id;
    }

    /**
     * the database column knowledge.subject_id
     * @param subject_id the value for knowledge.subject_id
     */
    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    /**
     * the database column knowledge.chapter_id
     * @return the value of knowledge.chapter_id
     */
    public Integer getChapter_id() {
        return chapter_id;
    }

    /**
     * the database column knowledge.chapter_id
     * @param chapter_id the value for knowledge.chapter_id
     */
    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }
}