package com.fanchen.pojo;

/**
 * Created by Administrator on 2017/10/19.
 * 章节表
 */
public class Chapter {
    private int id;    //章节id
    private int book_id; //书id
    private int status;  //章节状态"是否收费"
    private int update_time; //更新时间
    private long create_at;   //创建时间
    private String chapter_name; //章节名称
    private String content; //内容

    @Override
    public String toString() {
        return "chapter{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", status=" + status +
                ", update_time=" + update_time +
                ", create_at=" + create_at +
                ", chapter_name='" + chapter_name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getStatus() {
        return status;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public long getCreate_at() {
        return create_at;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public String getContent() {
        return content;
    }
}
