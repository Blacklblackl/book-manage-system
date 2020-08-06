package com.luojs.bookmanagesystem.book.dao;

import com.luojs.bookmanagesystem.book.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO {

    List<Book> getPageList(@Param("bookId") String bookId,
                           @Param("bookName") String bookName,
                           @Param("authorName") String authorName,
                           @Param("status") Integer status);

    int insert(Book book);

    int update(Book book);

    int delete(Integer id);

    Book selectByBookId(String bookId);

    Book selectById(Integer id);


}
