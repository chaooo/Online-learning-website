package top.chao.entity;

public class PaperKnowledge {
    /**
     * the database column paper_knowledge.id
     */
    private Integer id;

    /**
     * the database column paper_knowledge.paper_id
     */
    private Integer paper_id;

    /**
     * the database column paper_knowledge.knowledge_id
     */
    private Integer knowledge_id;

    /**
     * the database column paper_knowledge.question_num
     */
    private Integer question_num;

    /**
     * the database column paper_knowledge.id
     * @return the value of paper_knowledge.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column paper_knowledge.id
     * @param id the value for paper_knowledge.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column paper_knowledge.paper_id
     * @return the value of paper_knowledge.paper_id
     */
    public Integer getPaper_id() {
        return paper_id;
    }

    /**
     * the database column paper_knowledge.paper_id
     * @param paper_id the value for paper_knowledge.paper_id
     */
    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    /**
     * the database column paper_knowledge.knowledge_id
     * @return the value of paper_knowledge.knowledge_id
     */
    public Integer getKnowledge_id() {
        return knowledge_id;
    }

    /**
     * the database column paper_knowledge.knowledge_id
     * @param knowledge_id the value for paper_knowledge.knowledge_id
     */
    public void setKnowledge_id(Integer knowledge_id) {
        this.knowledge_id = knowledge_id;
    }

    /**
     * the database column paper_knowledge.question_num
     * @return the value of paper_knowledge.question_num
     */
    public Integer getQuestion_num() {
        return question_num;
    }

    /**
     * the database column paper_knowledge.question_num
     * @param question_num the value for paper_knowledge.question_num
     */
    public void setQuestion_num(Integer question_num) {
        this.question_num = question_num;
    }
}