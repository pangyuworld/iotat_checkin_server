package com.pang.card.common.result;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ResultEnum
 * @Package com.pang.card.common.result
 * @description: 统一返回状态码
 * @date 2019/10/28 10:45
 */
public enum ResultEnum {
    SUCCESS_OPTION(200,"操作成功"),
    BAD_REQUEST(400,"错误的请求参数"),
    LOGIN_SUCCESS(200,"登陆成功"),
    REPEAT_EMAIL(403, "已存在此邮箱地址"),
    REPEAT_NAME(403,"用户已存在"),
    REPEAT_MAC(403,"该计算机已经注册"),
    NOT_MATCH(401,"用户名、密码不匹配"),
    ILLEGAL_ARGUMENT(400, "参数不合法"),
    NO_USER_EXIST(404, "用户不存在"),
    REPEAT_STU_ID(403,"学号已经注册"),
    METHOD_NOT_ALLOWED(400, "不合法的请求方式");
    /**
     * 状态码
     */
    private int status;
    /**
     * 返回消息
     */
    private String message;

    ResultEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public ResultEnum setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultEnum setMessage(String message) {
        this.message = message;
        return this;
    }
}
