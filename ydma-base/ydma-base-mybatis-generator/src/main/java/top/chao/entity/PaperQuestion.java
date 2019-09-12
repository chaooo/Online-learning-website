package top.chao.entity;

public class PaperQuestion {
    /**
     * the database column paper_question.paper_id
     */
    private Integer paper_id;

    /**
     * the database column paper_question.question_id
     */
    private Integer question_id;

    /**
     * the database column paper_question.question_score
     */
    private Integer question_score;

    /**
     * the database column paper_question.paper_id
     * @return the value of paper_question.paper_id
     */
    public Integer getPaper_id() {
        return paper_id;
    }

    /**
     * the database column paper_question.paper_id
     * @param paper_id the value for paper_question.paper_id
     */
    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    /**
     * the database column paper_question.question_id
     * @return the value of paper_question.question_id
     */
    public Integer getQuestion_id() {
        return question_id;
    }

    /**
     * the database column paper_question.question_id
     * @param question_id the value for paper_question.question_id
     */
    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    /**
     * the database column paper_question.question_score
     * @return the value of paper_question.question_score
     */
    public Integer getQuestion_score() {
        return question_score;
    }

    /**
     * the database column paper_question.question_score
     * @param question_score the value for paper_question.question_score
     */
    public void setQuestion_score(Integer question_score) {
        this.question_score = question_score;
    }
}