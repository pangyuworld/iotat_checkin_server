package com.pang.card.common.result;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ResultAdvice
 * @Package com.pang.card.common.result
 * @description: 全局异常捕获
 * @date 2019/10/28 11:50
 */
@ControllerAdvice
@ResponseBody
public class ResultAdvice {
    @ExceptionHandler(value = ResultException.class)
    public ResultJSON errorHandle(ResultException e) {
        ResultJSON resultJSON = new ResultJSON(e.getMsg(), e.getStatus());
        return resultJSON;
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResultJSON methodHandle(HttpRequestMethodNotSupportedException e) {
        return new ResultJSON(ResultEnum.METHOD_NOT_ALLOWED);
    }
}
