package com.fanchen.pojo;

/**
 * Created by Administrator on 2017/10/18.
 * 书类
 */
public class Book {
    private int id;
    private String book_name;
    private String author;
    private String introduction; //简介
    private String last_update_time;
    private String cover;
    private String type;
    private String end_chapter;
    private int status;
    private int click; //点击
    private int chapter_number;
    private int collection; //收藏
    private int recommended; //推荐
    private int level;
    private int start_id;
    private int end_id;
    private long create_at;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                ", last_update_time='" + last_update_time + '\'' +
                ", cover='" + cover + '\'' +
                ", type='" + type + '\'' +
                ", end_chapter='" + end_chapter + '\'' +
                ", status=" + status +
                ", click=" + click +
                ", chapter_number=" + chapter_number +
                ", collection=" + collection +
                ", recommended=" + recommended +
                ", level=" + level +
                ", start_id=" + start_id +
                ", end_id=" + end_id +
                ", create_at=" + create_at +
                '}';
    }

    public void setEnd_chapter(String end_chapter) {
        this.end_chapter = end_chapter;
    }

    public String getEnd_chapter() {
        return end_chapter;
    }

    public void setStart_id(int start_id) {
        this.start_id = start_id;
    }

    public void setEnd_id(int end_id) {
        this.end_id = end_id;
    }

    public int getStart_id() {
        return start_id;
    }

    public int getEnd_id() {
        return end_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setLast_update_time(String last_update_time) {
        this.last_update_time = last_update_time;
    }


    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public void setChapter_number(int chapter_number) {
        this.chapter_number = chapter_number;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getLast_update_time() {
        return last_update_time;
    }

    public String getCover() {
        return cover;
    }

    public int getStatus() {
        return status;
    }

    public int getClick() {
        return click;
    }

    public int getChapter_number() {
        return chapter_number;
    }

    public int getCollection() {
        return collection;
    }

    public int getRecommended() {
        return recommended;
    }

    public int getLevel() {
        return level;
    }

    public long getCreate_at() {
        return create_at;
    }
}
