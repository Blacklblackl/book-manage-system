package com.luojs.bookmanagesystem.book.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.luojs.bookmanagesystem.book.dto.BookDTO;
import com.luojs.bookmanagesystem.book.dao.BookDAO;
import com.luojs.bookmanagesystem.book.entity.Book;
import com.luojs.bookmanagesystem.book.service.BookService;
import com.luojs.bookmanagesystem.common.domain.Params;
import com.luojs.bookmanagesystem.common.response.PageVO;
import com.luojs.bookmanagesystem.common.response.Response;
import com.luojs.bookmanagesystem.common.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 图书服务实现类
 * @author: luojs
 * @since: 2020/8/3
 */
@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookDAO bookDAO;

    @Override
    public PageVO<Book> getPageList(Params params){
        Integer page = params.getInt("page");
        Integer limit = params.getInt("limit");
        // 查询条件
        String bookId = params.getString("bookId");
        String bookName = params.getString("bookName");
        String authorName = params.getString("authorName");
        Integer status = params.getInt("status");
        PageHelper.startPage(page, limit);
        Page<Book> pageList = (Page<Book>) bookDAO.getPageList(bookId, bookName, authorName, status);
        return new PageVO<>(pageList.getTotal(),200,"",pageList);
    }

    @Override
    public Response getBookDetailById(Integer id){
        Book book = bookDAO.selectById(id);
        return ResponseUtil.successAndNoMsg(book);
    }

    @Override
    public Response create(BookDTO bookDTO){

        try{
            Book dbBook = bookDAO.selectByBookId(bookDTO.getBookId());
            if(dbBook != null){
                logger.warn("添加失败，该图书ID已经存在");
                return ResponseUtil.verificationFailed().buildMessage("添加失败，该图书ID已经存在");
            }

            Book book = new Book();
            Date date = new Date();
            BeanUtils.copyProperties(bookDTO, book);
            book.setCreateTime(date);
            book.setUpdateTime(date);

            bookDAO.insert(book);
        }catch (Exception e){
            logger.error("添加图书异常:{}",e.getMessage());
            return ResponseUtil.fail().buildMessage("添加图书异常:"+e.getMessage());
        }
        return ResponseUtil.success().buildMessage("添加成功！");
    }

    @Override
    public Response update(BookDTO bookDTO){

        try{
            if(bookDTO.getId() == null){
                logger.warn("更新失败，ID为空");
                return ResponseUtil.unprocesableEntity().buildMessage("更新失败，ID为空");
            }
            Book dbBook = bookDAO.selectById(bookDTO.getId());
            if(dbBook == null){
                logger.warn("更新失败，ID对应的图书不存在");
                return ResponseUtil.verificationFailed().buildMessage("更新失败，ID对应的图书不存在");
            }
            Book book = new Book();
            Date date = new Date();
            BeanUtils.copyProperties(bookDTO, book);
            book.setUpdateTime(date);

            bookDAO.update(book);
        } catch (Exception e){
            logger.error("更新图书异常:{}",e.getMessage());
            return ResponseUtil.fail().buildMessage("更新图书异常:"+e.getMessage());
        }
        return ResponseUtil.success().buildMessage("更新成功！");
    }

    @Override
    public Response delete(Integer id){
        try{
            if(id == null){
                logger.warn("删除失败，ID为空");
                return ResponseUtil.unprocesableEntity().buildMessage("删除失败，ID为空");
            }
            Book dbBook = bookDAO.selectById(id);
            if(dbBook == null){
                logger.warn("删除失败，ID对应的图书不存在");
                return ResponseUtil.verificationFailed().buildMessage("删除失败，ID对应的图书不存在");
            }
            bookDAO.delete(id);
        } catch (Exception e){
            logger.error("删除图书异常:{}",e.getMessage());
            return ResponseUtil.fail().buildMessage("删除图书异常:"+e.getMessage());
        }
        return ResponseUtil.success().buildMessage("删除成功！");
    }

}
