package com.luojs.bookmanagesystem.book.controller;

import com.luojs.bookmanagesystem.book.dto.BookDTO;
import com.luojs.bookmanagesystem.book.entity.Book;
import com.luojs.bookmanagesystem.book.service.BookService;
import com.luojs.bookmanagesystem.common.domain.Params;
import com.luojs.bookmanagesystem.common.response.PageVO;
import com.luojs.bookmanagesystem.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 图书管理接口
 * @author: luojs
 * @since: 2020/8/3
 */
@RestController
@RequestMapping("book")
@Api("图书管理API")
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @ApiOperation("根据查询条件分页查询图书列表")
    @GetMapping("/book-list")
    public PageVO<Book> getBookByPage(@ApiParam("查询条件") @RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return bookService.getPageList(p);
    }

    @ApiOperation("更新图书")
    @GetMapping("/book-detail")
    public Response getBookDetail(@ApiParam("图书主键ID") Integer id){
        return bookService.getBookDetailById(id);
    }

    @ApiOperation("添加图书")
    @PostMapping("/create")
    public Response create(@ApiParam("图书实体对象") @RequestBody BookDTO record){
        return bookService.create(record);
    }

    @ApiOperation("更新图书")
    @PutMapping("/update")
    public Response update(@ApiParam("图书实体对象") @RequestBody BookDTO record){
        return bookService.update(record);
    }

    @ApiOperation("删除图书")
    @DeleteMapping("/delete")
    public Response delete(@ApiParam("图书主键ID") Integer id){
        return bookService.delete(id);
    }

}
