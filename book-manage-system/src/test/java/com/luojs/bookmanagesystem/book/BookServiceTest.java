package com.luojs.bookmanagesystem.book;

import com.luojs.bookmanagesystem.BookManageSystemApplication;
import com.luojs.bookmanagesystem.book.dao.BookDAO;
import com.luojs.bookmanagesystem.book.dto.BookDTO;
import com.luojs.bookmanagesystem.book.entity.Book;
import com.luojs.bookmanagesystem.book.service.BookService;
import com.luojs.bookmanagesystem.common.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BookService单元测试类
 * @author: luojs
 * @since: 2020/08/05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookManageSystemApplication.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDAO bookDAO;

    @Test
    public void createTest1(){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId("000099");
        bookDTO.setBookName("项目管理知识体系指南");
        bookDTO.setAuthorName("项目管理协会");
        bookDTO.setStatus(1);
        bookDTO.setKeyWord("项目管理");
        bookDTO.setIntroduction("");
        bookDTO.setIsbn("9787121336379");

        Response response = bookService.create(bookDTO);
        Assert.assertEquals(response.getMsg(),"添加成功！");
    }

    @Test
    public void createTest2(){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId("0001");
        bookDTO.setBookName("项目管理知识体系指南");
        bookDTO.setAuthorName("项目管理协会");
        bookDTO.setStatus(1);
        bookDTO.setKeyWord("项目管理");
        bookDTO.setIntroduction("");
        bookDTO.setIsbn("9787121336379");

        Response response = bookService.create(bookDTO);
        Assert.assertEquals(response.getMsg(),"添加失败，该图书ID已经存在");
    }

    @Test
    public void updateTest(){
        Book book = bookDAO.selectByBookId("000099");
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setStatus(0);

        Response response = bookService.update(bookDTO);
        Assert.assertEquals(response.getMsg(),"更新成功！");
    }

    @Test
    public void deleteTest(){
        Book book = bookDAO.selectByBookId("000099");
        Response response = bookService.delete(book.getId());
        Assert.assertEquals(response.getMsg(),"删除成功！");
    }
}
