package top.chao.entity;

import java.util.List;

public class Direction {
    private Integer id;
    private String name;
    //存储相关联的subject信息
    private List<Subject> subjects;


    public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}