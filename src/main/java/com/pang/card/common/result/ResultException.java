package com.pang.card.common.result;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ResultException
 * @Package com.pang.card.common.result
 * @description: 统一异常
 * @date 2019/10/28 11:18
 */
public class ResultException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int status;

    private String msg;

    public ResultException(int status, String msg) {
        super(msg);
        this.status = status;
        this.msg = msg;
    }

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
        this.msg = resultEnum.getMessage();
    }

    public int getStatus() {
        return status;
    }

    public ResultException setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
