package com.wodaibao.common.model;
/**
 * Copyright © 2015-2018 吉林省帮我贷信息技术有限公司
 * FileName: com.wodaibao.common.model.CommonResult
 * Description : CommonResult
 *
 */
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author C.K
 */
@Data
@Accessors(chain = true)
public class CommonResult<T> {

    /**
     * 是否成功
     *
     * author C.K
     */
    private Boolean success;

    private String mssage;

    private T data;

}
