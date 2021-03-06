package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.QuestionKnowledge;

public class QuestionKnowledgeSqlProvider {

    /**
     * the database table question_knowledge
     */
    public String insertSelective(QuestionKnowledge record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question_knowledge");
        
        if (record.getQuestion_id() != null) {
            sql.VALUES("question_id", "#{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledge_id() != null) {
            sql.VALUES("knowledge_id", "#{knowledge_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table question_knowledge
     */
    public String updateByPrimaryKeySelective(QuestionKnowledge record) {
        SQL sql = new SQL();
        sql.UPDATE("question_knowledge");
        
        if (record.getQuestion_id() != null) {
            sql.SET("question_id = #{question_id,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledge_id() != null) {
            sql.SET("knowledge_id = #{knowledge_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}