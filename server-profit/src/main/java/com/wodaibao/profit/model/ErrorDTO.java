package com.wodaibao.profit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ErrorDTO
 */
@Data
@Accessors(chain = true)
public class ErrorDTO {

    /**
     * HTTP 状态码
     */
    private Integer httpStatusCode;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误代码
     */
    private String code;

    /**
     * 返回参数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public ErrorDTO(ErrorEnum ee) {
        this.code = ee.toString();
        this.message = ee.getMessage();
        this.httpStatusCode = ee.getHttpStatusCode();
    }
}
