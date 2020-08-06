package com.luojs.bookmanagesystem.book.service;

import com.luojs.bookmanagesystem.book.dto.BookDTO;
import com.luojs.bookmanagesystem.book.entity.Book;
import com.luojs.bookmanagesystem.common.domain.Params;
import com.luojs.bookmanagesystem.common.response.PageVO;
import com.luojs.bookmanagesystem.common.response.Response;

public interface BookService {

    /**
     * 分页查询图书列表
     * @param params
     * @return PageVO<Book>
     */
    public PageVO<Book> getPageList(Params params);

    /***
     * 图书详情
     * @param id
     * @return Response
     */
    public Response getBookDetailById(Integer id);

    /***
     * 新增图书
     * @param bookDTO
     * @return Response
     */
    public Response create(BookDTO bookDTO);

    /***
     * 根据主键ID修改图书信息
     * @param bookDTO
     * @return Response
     */
    public Response update(BookDTO bookDTO);

    /***
     * 根据主键ID删除图书信息
     * @param id
     * @return Response
     */
    public Response delete(Integer id);

}
