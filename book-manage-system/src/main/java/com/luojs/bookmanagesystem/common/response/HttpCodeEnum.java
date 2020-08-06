package com.luojs.bookmanagesystem.common.response;

public enum HttpCodeEnum {

    OK(200,"操作成功"),
    INVALID_REQUEST(400,"参数错误"),
    UNAUTHORIZED(401,"没有权限"),
    FORBIDDEN(403,"禁止访问"),
    NOT_FOUND(404,"资源不存在"),
    NOT_ACCEPTABLE(406,"请求的格式不正确"),
    GONE(410,"数据被删除"),
    UNPROCESABLE_ENTITY(422,"参数验证错误"),
    INTERNAL_SERVER_ERROR(500,"服务器发生错误"),
    UN_KNOW_ERROR(500,"未知错误"),
    FAIL(501,"操作失败"),
    VERIFICATION_FAILED(1001, "业务逻辑验证未通过");

    private final int code;
    private final String message;

    HttpCodeEnum(final int code, final String message){
        this.code=code;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}
