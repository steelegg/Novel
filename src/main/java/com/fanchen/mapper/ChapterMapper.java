package com.fanchen.mapper;

import com.fanchen.pojo.Book;
import com.fanchen.pojo.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 * chapter映射表
 */

public interface ChapterMapper {
    void insert(Chapter chapter);
    //获取目录
    List<Chapter> getChapters(int book_id);
    //获取正文
    Chapter getChapter(int id);

}
