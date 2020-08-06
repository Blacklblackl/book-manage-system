package com.luojs.bookmanagesystem.common.response;

/**
 * TODO
 *
 * @author: luojs
 * @since: 2020/8/1
 */
public class ResponseUtil {

    /**
     * 请求成功
     * @return
     */
    public static Response success() {
        return new Response(HttpCodeEnum.OK.getCode(),HttpCodeEnum.OK.getMessage());
    }

    /**
     * 请求成功（无消息）
     * @return
     */
    public static Response successAndNoMsg() {
        return new Response(HttpCodeEnum.OK.getCode(),"");
    }

    /**
     * 成功请求
     *
     * @param data
     * @return
     */
    public static Response success(Object data) {
        return new Response(HttpCodeEnum.OK.getCode(), HttpCodeEnum.OK.getMessage() , data);
    }

    /**
     * 成功请求（无消息）
     *
     * @param data
     * @return
     */
    public static Response successAndNoMsg(Object data) {
        return new Response(HttpCodeEnum.OK.getCode(), "", data);
    }

    /**
     * 操作失败
     * @return
     */
    public static Response fail() {
        return new Response(HttpCodeEnum.FAIL.getCode(), HttpCodeEnum.FAIL.getMessage());
    }
    /**
     * 操作失败
     * @return
     */
    public static Response fail(Object data) {
        return new Response(HttpCodeEnum.FAIL.getCode(), HttpCodeEnum.FAIL.getMessage() ,data);
    }

    /**
     * 服务器错误
     * @return
     */
    public static Response error() {
        return new Response(HttpCodeEnum.INTERNAL_SERVER_ERROR.getCode(),HttpCodeEnum.INTERNAL_SERVER_ERROR.getMessage());
    }


    /**
     * 服务器错误
     * @param data
     * @return
     */
    public static Response error(Object data) {
        return new Response(HttpCodeEnum.INTERNAL_SERVER_ERROR.getCode(),HttpCodeEnum.INTERNAL_SERVER_ERROR.getMessage(), data);
    }
    /**
     * 参数错误
     * @return
     */
    public static Response paramError() {
        return new Response(HttpCodeEnum.INVALID_REQUEST.getCode(), HttpCodeEnum.INVALID_REQUEST.getMessage());
    }

    /**
     * 参数错误
     * @param data
     * @return
     */
    public static Response paramError(Object data) {
        return new Response(HttpCodeEnum.INVALID_REQUEST.getCode(), HttpCodeEnum.INVALID_REQUEST.getMessage(), data);
    }

    /**
     * 没有权限
     * @return
     */
    public static Response unAuthorized() {
        return new Response(HttpCodeEnum.UNAUTHORIZED.getCode(),HttpCodeEnum.UNAUTHORIZED.getMessage());
    }

    /**
     * 没有权限
     * @param data
     * @return
     */
    public static Response unAuthorized(Object data) {
        return new Response(HttpCodeEnum.UNAUTHORIZED.getCode(),HttpCodeEnum.UNAUTHORIZED.getMessage(),data);
    }


    /**
     *  禁止访问
     * @return
     */
    public static Response forbidden() {
        return new Response(HttpCodeEnum.FORBIDDEN.getCode(),HttpCodeEnum.FORBIDDEN.getMessage());
    }

    /**
     * 禁止访问
     * @param data
     * @return
     */
    public static Response forbidden(Object data) {
        return new Response(HttpCodeEnum.FORBIDDEN.getCode(),HttpCodeEnum.FORBIDDEN.getMessage(), data);
    }


    /**
     * 资源不存在
     * @return
     */
    public static Response notFound() {
        return new Response(HttpCodeEnum.NOT_FOUND.getCode(),HttpCodeEnum.NOT_FOUND.getMessage());
    }


    /**
     * 资源不存在
     * @param data
     * @return
     */
    public static Response notFound(Object data) {
        return new Response(HttpCodeEnum.NOT_FOUND.getCode(),HttpCodeEnum.NOT_FOUND.getMessage(), data);
    }


    /**
     * 请求的格式不正确
     * @return
     */
    public static Response notAcceptable() {
        return new Response(HttpCodeEnum.NOT_ACCEPTABLE.getCode(),HttpCodeEnum.NOT_ACCEPTABLE.getMessage());
    }


    /**
     * 请求的格式不正确
     * @param data
     * @return
     */
    public static Response notAcceptable(Object data) {
        return new Response(HttpCodeEnum.NOT_ACCEPTABLE.getCode(),HttpCodeEnum.NOT_ACCEPTABLE.getMessage(), data);
    }


    /**
     * 数据已经被删除
     * @return
     */
    public static Response gone() {
        return new Response(HttpCodeEnum.GONE.getCode(),HttpCodeEnum.GONE.getMessage());
    }


    /**
     * 数据已经被删除
     * @param data
     * @return
     */
    public static Response gone(Object data) {
        return new Response(HttpCodeEnum.GONE.getCode(),HttpCodeEnum.GONE.getMessage(), data);
    }

    /**
     * 实体参数校验错误
     * @return
     */
    public static Response unprocesableEntity() {
        return new Response(HttpCodeEnum.UNPROCESABLE_ENTITY.getCode(),HttpCodeEnum.UNPROCESABLE_ENTITY.getMessage());
    }

    /**
     * 实体参数校验错误
     * @param data
     * @return
     */
    public static Response unprocesableEntity(Object data) {
        return new Response(HttpCodeEnum.UNPROCESABLE_ENTITY.getCode(),HttpCodeEnum.UNPROCESABLE_ENTITY.getMessage(), data);
    }

    /**
     * 未知错误
     * @return
     */
    public static Response unKnowError() {
        return new Response(HttpCodeEnum.UN_KNOW_ERROR.getCode(),HttpCodeEnum.UN_KNOW_ERROR.getMessage());
    }

    /**
     * 未知错误
     * @param data
     * @return
     */
    public static Response unKnowError(Object data) {
        return new Response(HttpCodeEnum.UN_KNOW_ERROR.getCode(),HttpCodeEnum.UN_KNOW_ERROR.getMessage(), data);
    }

    /**
     * 业务逻辑验证未通过
     * @return
     */
    public static Response verificationFailed() {
        return new Response(HttpCodeEnum.VERIFICATION_FAILED.getCode(),HttpCodeEnum.VERIFICATION_FAILED.getMessage());
    }

    /**
     * 业务逻辑验证未通过
     * @param data
     * @return
     */
    public static Response verificationFailed(Object data) {
        return new Response(HttpCodeEnum.VERIFICATION_FAILED.getCode(),HttpCodeEnum.VERIFICATION_FAILED.getMessage(), data);
    }

    /**
     * 自定义返回
     * @param e
     * @return
     */
    public static Response custom(HttpCodeEnum e) {
        return new Response(e.getCode(),e.getMessage());
    }
    /**
     * 自定义返回
     * @param error
     * @return
     */
    public static Response custom(int code, String error) {
        return new Response(code,error);
    }

    /**
     * 自定义返回
     * @param error
     * @param data
     * @return
     */
    public static Response custom(int code, String error, Object data) {
        return new Response(code,error,data);
    }

}
