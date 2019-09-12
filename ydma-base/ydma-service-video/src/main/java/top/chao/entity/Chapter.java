package top.chao.entity;

import java.util.List;

public class Chapter {
    /**
     * the database column chapter.id
     */
    private Integer id;

    /**
     * the database column chapter.name
     */
    private String name;

    /**
     * the database column chapter.course_id
     */
    private Integer course_id;
    
    //章节下的视频videos
    private List<Video> videos;

    /**
     * the database column chapter.id
     * @return the value of chapter.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column chapter.id
     * @param id the value for chapter.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column chapter.name
     * @return the value of chapter.name
     */
    public String getName() {
        return name;
    }

    /**
     * the database column chapter.name
     * @param name the value for chapter.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * the database column chapter.course_id
     * @return the value of chapter.course_id
     */
    public Integer getCourse_id() {
        return course_id;
    }

    /**
     * the database column chapter.course_id
     * @param course_id the value for chapter.course_id
     */
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}