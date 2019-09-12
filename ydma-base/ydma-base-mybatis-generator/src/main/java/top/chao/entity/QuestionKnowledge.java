package top.chao.entity;

public class QuestionKnowledge {
    /**
     * the database column question_knowledge.Id
     */
    private Integer id;

    /**
     * the database column question_knowledge.question_id
     */
    private Integer question_id;

    /**
     * the database column question_knowledge.knowledge_id
     */
    private Integer knowledge_id;

    /**
     * the database column question_knowledge.Id
     * @return the value of question_knowledge.Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column question_knowledge.Id
     * @param id the value for question_knowledge.Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column question_knowledge.question_id
     * @return the value of question_knowledge.question_id
     */
    public Integer getQuestion_id() {
        return question_id;
    }

    /**
     * the database column question_knowledge.question_id
     * @param question_id the value for question_knowledge.question_id
     */
    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    /**
     * the database column question_knowledge.knowledge_id
     * @return the value of question_knowledge.knowledge_id
     */
    public Integer getKnowledge_id() {
        return knowledge_id;
    }

    /**
     * the database column question_knowledge.knowledge_id
     * @param knowledge_id the value for question_knowledge.knowledge_id
     */
    public void setKnowledge_id(Integer knowledge_id) {
        this.knowledge_id = knowledge_id;
    }
}