package com.wodaibao.report.framework;

import com.wodaibao.report.model.ErrorDTO;
import com.wodaibao.report.model.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一异常处理
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * json格式转换出错,多是前端传送格式不对
     * 
     * @param e 异常
     * @return ErrorDTO
     *
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus
    public ErrorDTO httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("json格式转换错误", e);
        return new ErrorDTO(ErrorEnum.FORMATTER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus
    public ErrorDTO allException(Exception e) {
        log.error("服务器错误", e);
        return new ErrorDTO(ErrorEnum.SERVER_ERROR);
    }
}
