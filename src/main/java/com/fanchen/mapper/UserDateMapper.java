package com.fanchen.mapper;

import com.fanchen.pojo.Book;
import com.fanchen.pojo.UserDate;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface UserDateMapper {
    int insert(UserDate userDate);
    List<Book> getId(int id);
    UserDate select(UserDate userDate);
}
