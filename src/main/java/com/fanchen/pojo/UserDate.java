package com.fanchen.pojo;

/**
 * Created by Administrator on 2017/10/29.
 *
 */
public class UserDate {

    private int id;
    private int uid;
    private int book_id;
    private int page_id;

    @Override
    public String toString() {
        return "UserDate{" +
                "id=" + id +
                ", uid=" + uid +
                ", book_id=" + book_id +
                ", page_id=" + page_id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public int getId() {

        return id;
    }

    public int getUid() {
        return uid;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getPage_id() {
        return page_id;
    }
}
