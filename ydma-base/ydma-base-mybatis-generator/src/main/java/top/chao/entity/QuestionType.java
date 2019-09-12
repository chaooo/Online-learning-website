package top.chao.entity;

public class QuestionType {
    /**
     * the database column question_type.type_id
     */
    private Integer type_id;

    /**
     * the database column question_type.type_name
     */
    private String type_name;

    /**
     * the database column question_type.type_id
     * @return the value of question_type.type_id
     */
    public Integer getType_id() {
        return type_id;
    }

    /**
     * the database column question_type.type_id
     * @param type_id the value for question_type.type_id
     */
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    /**
     * the database column question_type.type_name
     * @return the value of question_type.type_name
     */
    public String getType_name() {
        return type_name;
    }

    /**
     * the database column question_type.type_name
     * @param type_name the value for question_type.type_name
     */
    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }
}