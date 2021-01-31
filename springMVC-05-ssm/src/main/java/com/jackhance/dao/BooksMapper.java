package com.jackhance.dao;

import com.jackhance.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BooksMapper {
    /**
     * 增加一个Book
     */
    int addBook(Books book);

    /**
     * 根据id删除一个Book
     */
    int deleteBookById(int id);

    /**
     * 更新Book
     */
    int updateBook(Books books);

    /**
     * 根据id查询,返回一个Book
     */
    Books queryBookById(@Param("bookID") int id);

    /**
     * 查询全部Book,返回list集合
     */
    List<Books> queryAllBook();
}
