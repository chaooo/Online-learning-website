package top.chao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CollectNote {
    /**
     * the database column collect_note.id
     */
    private Integer id;

    /**
     * the database column collect_note.user_id
     */
    private Integer user_id;

    /**
     * the database column collect_note.note_id
     */
    private Integer note_id;

    /**
     * the database column collect_note.collect_time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date collect_time;
    
    //收藏夹笔记
    private Note note;

    public Note getNotes() {
		return note;
	}

	public void setNotes(Note note) {
		this.note = note;
	}

	/**
     * the database column collect_note.id
     * @return the value of collect_note.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * the database column collect_note.id
     * @param id the value for collect_note.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * the database column collect_note.user_id
     * @return the value of collect_note.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * the database column collect_note.user_id
     * @param user_id the value for collect_note.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * the database column collect_note.note_id
     * @return the value of collect_note.note_id
     */
    public Integer getNote_id() {
        return note_id;
    }

    /**
     * the database column collect_note.note_id
     * @param note_id the value for collect_note.note_id
     */
    public void setNote_id(Integer note_id) {
        this.note_id = note_id;
    }

    /**
     * the database column collect_note.collect_time
     * @return the value of collect_note.collect_time
     */
    public Date getCollect_time() {
        return collect_time;
    }

    /**
     * the database column collect_note.collect_time
     * @param collect_time the value for collect_note.collect_time
     */
    public void setCollect_time(Date collect_time) {
        this.collect_time = collect_time;
    }
}