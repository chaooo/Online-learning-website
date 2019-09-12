package top.chao.entity;

public class QuestionOptions {
    /**
     * the database column question_options.option_id
     */
    private Integer option_id;

    /**
     * the database column question_options.question_id
     */
    private Integer question_id;

    /**
     * the database column question_options.option_name
     */
    private String option_name;

    /**
     * the database column question_options.option_id
     * @return the value of question_options.option_id
     */
    public Integer getOption_id() {
        return option_id;
    }

    /**
     * the database column question_options.option_id
     * @param option_id the value for question_options.option_id
     */
    public void setOption_id(Integer option_id) {
        this.option_id = option_id;
    }

    /**
     * the database column question_options.question_id
     * @return the value of question_options.question_id
     */
    public Integer getQuestion_id() {
        return question_id;
    }

    /**
     * the database column question_options.question_id
     * @param question_id the value for question_options.question_id
     */
    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    /**
     * the database column question_options.option_name
     * @return the value of question_options.option_name
     */
    public String getOption_name() {
        return option_name;
    }

    /**
     * the database column question_options.option_name
     * @param option_name the value for question_options.option_name
     */
    public void setOption_name(String option_name) {
        this.option_name = option_name == null ? null : option_name.trim();
    }
}