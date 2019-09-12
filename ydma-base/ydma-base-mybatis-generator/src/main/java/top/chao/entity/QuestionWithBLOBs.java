package top.chao.entity;

public class QuestionWithBLOBs extends Question {
    /**
     * the database column question.body
     */
    private String body;

    /**
     * the database column question.analysis
     */
    private String analysis;

    /**
     * the database column question.body
     * @return the value of question.body
     */
    public String getBody() {
        return body;
    }

    /**
     * the database column question.body
     * @param body the value for question.body
     */
    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    /**
     * the database column question.analysis
     * @return the value of question.analysis
     */
    public String getAnalysis() {
        return analysis;
    }

    /**
     * the database column question.analysis
     * @param analysis the value for question.analysis
     */
    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }
}