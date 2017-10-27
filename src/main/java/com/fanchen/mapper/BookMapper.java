package com.fanchen.mapper;

import com.fanchen.pojo.Book;
import com.fanchen.pojo.RankingType;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 * Book映射类
 */
public interface BookMapper {
    int insert(Book book);
    void update(Book book);
    List<Book> search(Book book);
    Book selectId(int id);
    Book getEnd(int id);
    int sum(RankingType rankingType);
    List<Book> getAll(RankingType rankingType);
}
