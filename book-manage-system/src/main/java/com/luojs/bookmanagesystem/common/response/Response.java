package com.luojs.bookmanagesystem.common.response;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author: luojs
 * @since: 2020/8/1
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private Object data;

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response() {

    }

    /**
     * 构建消息内容
     *
     * @param msg
     * @return
     */
    public Response buildMessage(String msg) {
        this.setMsg(msg);
        return this;
    }

    /**
     * 构建消息data的值，key默认为data
     *
     * @param obj data值
     * @return
     */
    public Response buildData(Object obj) {
        this.setData(obj);
        return this;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
