package top.chao.dao;

import org.apache.ibatis.jdbc.SQL;
import top.chao.entity.PaperKnowledge;

public class PaperKnowledgeSqlProvider {

    /**
     * the database table paper_knowledge
     */
    public String insertSelective(PaperKnowledge record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("paper_knowledge");
        
        if (record.getPaper_id() != null) {
            sql.VALUES("paper_id", "#{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledge_id() != null) {
            sql.VALUES("knowledge_id", "#{knowledge_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_num() != null) {
            sql.VALUES("question_num", "#{question_num,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * the database table paper_knowledge
     */
    public String updateByPrimaryKeySelective(PaperKnowledge record) {
        SQL sql = new SQL();
        sql.UPDATE("paper_knowledge");
        
        if (record.getPaper_id() != null) {
            sql.SET("paper_id = #{paper_id,jdbcType=INTEGER}");
        }
        
        if (record.getKnowledge_id() != null) {
            sql.SET("knowledge_id = #{knowledge_id,jdbcType=INTEGER}");
        }
        
        if (record.getQuestion_num() != null) {
            sql.SET("question_num = #{question_num,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}