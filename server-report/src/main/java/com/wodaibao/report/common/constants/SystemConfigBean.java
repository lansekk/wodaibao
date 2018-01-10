package com.wodaibao.report.common.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 本项目的常量,生产环境和开发环境不一样的那种
 *
 */
@Component
@Getter
public class SystemConfigBean {
    /**
     * 项目名称
     */
    @Value("${server.context-path}")
    private String contextPath;
}
