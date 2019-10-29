package com.pang.card.common.result;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ResultJSON
 * @Package com.pang.card.common.result
 * @description: 统一返回标识
 * @date 2019/10/28 10:44
 */
public class ResultJSON<E> {
    /**
     * 错误消息
     */
    private String message;
    /**
     * 状态码
     */
    private int status;
    /**
     * 消息实体
     */
    private E data;


    public ResultJSON(E data) {
        this.data = data;
    }

    public ResultJSON(E data, ResultEnum resultEnum) {
        this.data = data;
        this.message = resultEnum.getMessage();
        this.status = resultEnum.getStatus();
    }

    public ResultJSON(String message, int status, E data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ResultJSON(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public ResultJSON(ResultEnum resultEnum) {
        this.message = resultEnum.getMessage();
        this.status = resultEnum.getStatus();
    }

    public int getStatus() {
        return status;
    }

    public ResultJSON<E> setStatus(int status) {
        this.status = status;
        return this;
    }

    public E getData() {
        return data;
    }

    public ResultJSON<E> setData(E data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultJSON<E> setMessage(String message) {
        this.message = message;
        return this;
    }
}
