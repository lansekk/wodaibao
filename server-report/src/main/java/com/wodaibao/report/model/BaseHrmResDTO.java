package com.wodaibao.report.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * BaseHrmResDTO
 */
@Data
@Accessors(chain = true)
public class BaseHrmResDTO {
    private Integer id;

    private String hrmName;
}
