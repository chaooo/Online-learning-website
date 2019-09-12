package top.chao.entity;

import java.util.List;

public class Video {
    /**
     * the database column video.id
     */
    private Integer id;

    /**
     * the database column video.name
     */
    private String name;

    /**
     * the database column video.url
     */
    private String url;

    /**
     * the database column video.chapter_id
     */
    private Integer chapter_id;
    
    // 评论
    private List<?> evaluates;
    
    // 问答
    private List<?> issues;
    
    // 笔记
    private List<?> notes;
    
    
    

    /**
     * the database column video.id
     * @return the value of video.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column video.id
     * @param id the value for video.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column video.name
     * @return the value of video.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column video.name
     * @param name the value for video.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * the database column video.url
     * @return the value of video.url
     */
    public String getUrl() {
        return url;
    }

    /**
     * the database column video.url
     * @param url the value for video.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * the database column video.chapter_id
     * @return the value of video.chapter_id
     */
    public Integer getChapter_id() {
        return chapter_id;
    }

    /**
     * the database column video.chapter_id
     * @param chapter_id the value for video.chapter_id
     */
    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }

	public List<?> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<?> evaluates) {
		this.evaluates = evaluates;
	}

	public List<?> getIssues() {
		return issues;
	}

	public void setIssues(List<?> issues) {
		this.issues = issues;
	}

	public List<?> getNotes() {
		return notes;
	}

	public void setNotes(List<?> notes) {
		this.notes = notes;
	}
}