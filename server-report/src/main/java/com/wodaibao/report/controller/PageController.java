package com.wodaibao.report.controller;

import com.wodaibao.report.common.constants.SystemConfigBean;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 *
 */
@Controller
@RequestMapping("/v1/page")
@Slf4j
public class PageController {

    private final SystemConfigBean systemConfigBean;

    @Autowired
    public PageController(SystemConfigBean systemConfigBean) {
        this.systemConfigBean = systemConfigBean;
    }

    /**
     * 跳转到首页
     *
     * @return String
     */
    @RequestMapping("/main")
    public String mallMain(Model model) {
        model.addAttribute("ctx",systemConfigBean.getContextPath());
        return "main/index";
    }
}