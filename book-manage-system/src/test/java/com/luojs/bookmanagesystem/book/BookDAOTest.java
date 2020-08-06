package com.luojs.bookmanagesystem.book;

import com.luojs.bookmanagesystem.BookManageSystemApplication;
import com.luojs.bookmanagesystem.book.dao.BookDAO;
import com.luojs.bookmanagesystem.book.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * BookDAO单元测试类
 * @author: luojs
 * @since: 2020/08/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookManageSystemApplication.class)
public class BookDAOTest {

    @Autowired
    private BookDAO bookDAO;

    @Test
    public void getPageListTest(){
        String bookId = "0002";
        String bookName = "软件";
        String authorName = "温";
        Integer status = 1;

        List<Book> bookList = bookDAO.getPageList(bookId,bookName,authorName,status);
        Assert.assertEquals(bookList.size(),1);
    }

    @Test
    public void selectByBookIdTest(){
        String bookId = "0000";
        Book book = bookDAO.selectByBookId(bookId);
        Assert.assertNull(book);
    }

    @Test
    public void selectByIdTest(){
        Integer id = 1;
        Book book = bookDAO.selectById(id);
        Assert.assertEquals(book.getBookName(),"软件架构设计");
    }
}
