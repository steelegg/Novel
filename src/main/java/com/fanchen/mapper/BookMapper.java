package com.fanchen.mapper;

import com.fanchen.pojo.Book;

/**
 * Created by Administrator on 2017/8/29.
 * Book映射类
 */
public interface BookMapper {
    int insert(Book book);
    void update(Book book);
    void update_introduction(Book book);
}
