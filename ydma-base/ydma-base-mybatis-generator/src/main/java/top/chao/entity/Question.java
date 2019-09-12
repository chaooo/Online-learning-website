package top.chao.entity;

import java.util.Date;

public class Question {
    /**
     * the database column question.id
     */
    private Integer id;

    /**
     * the database column question.author
     */
    private Integer author;

    /**
     * the database column question.add_date
     */
    private Date add_date;

    /**
     * the database column question.degree
     */
    private Integer degree;

    /**
     * the database column question.answer
     */
    private String answer;

    /**
     * the database column question.type_id
     */
    private Integer type_id;

    /**
     * the database column question.knowledge_id
     */
    private Integer knowledge_id;

    /**
     * the database column question.subject_id
     */
    private Integer subject_id;

    /**
     * the database column question.chapter_id
     */
    private Integer chapter_id;

    /**
     * the database column question.id
     * @return the value of question.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column question.id
     * @param id the value for question.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column question.author
     * @return the value of question.author
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     * the database column question.author
     * @param author the value for question.author
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     * the database column question.add_date
     * @return the value of question.add_date
     */
    public Date getAdd_date() {
        return add_date;
    }

    /**
     * the database column question.add_date
     * @param add_date the value for question.add_date
     */
    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    /**
     * the database column question.degree
     * @return the value of question.degree
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * the database column question.degree
     * @param degree the value for question.degree
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    /**
     * the database column question.answer
     * @return the value of question.answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * the database column question.answer
     * @param answer the value for question.answer
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * the database column question.type_id
     * @return the value of question.type_id
     */
    public Integer getType_id() {
        return type_id;
    }

    /**
     * the database column question.type_id
     * @param type_id the value for question.type_id
     */
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    /**
     * the database column question.knowledge_id
     * @return the value of question.knowledge_id
     */
    public Integer getKnowledge_id() {
        return knowledge_id;
    }

    /**
     * the database column question.knowledge_id
     * @param knowledge_id the value for question.knowledge_id
     */
    public void setKnowledge_id(Integer knowledge_id) {
        this.knowledge_id = knowledge_id;
    }

    /**
     * the database column question.subject_id
     * @return the value of question.subject_id
     */
    public Integer getSubject_id() {
        return subject_id;
    }

    /**
     * the database column question.subject_id
     * @param subject_id the value for question.subject_id
     */
    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    /**
     * the database column question.chapter_id
     * @return the value of question.chapter_id
     */
    public Integer getChapter_id() {
        return chapter_id;
    }

    /**
     * the database column question.chapter_id
     * @param chapter_id the value for question.chapter_id
     */
    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }
}