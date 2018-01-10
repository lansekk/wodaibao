package com.wodaibao.report.model;

/**
 * ErrorEnum
 *
 */
public enum ErrorEnum {
    /**
     * 令牌过期
     */
    AUTHORIZATION_EXPIRED(401, "令牌过期"),
    /**
     * 验证码错误
     */
    CODE_ERROR(400, "验证码错误"),
    /**
     * 增加失败
     */
    ADD_ERROR(400, "增加失败,数据已存在"),
    /**
     * 删除失败
     */
    DEL_ERROR(400, "删除失败"),
    /**
     * 修改失败
     */
    UPD_ERROR(400, "修改失败"),
    /**
     * 参数不全或为空
     */
    PARAM_NULL(400, "参数不全或为空"),
    /**
     * 格式错误
     */
    FORMATTER_ERROR(400, "格式错误"),

    /**
     * 系统内部错误
     */
    IMG_ERROR(500, "上传图片出错"),
    /**
     * 系统内部错误
     */
    SERVER_ERROR(500, "系统内部错误");

    private ErrorEnum(int httpStatusCode, String message) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    private String message;

    private Integer httpStatusCode;

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
