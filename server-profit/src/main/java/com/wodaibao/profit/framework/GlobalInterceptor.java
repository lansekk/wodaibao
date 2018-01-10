package com.wodaibao.profit.framework;

import com.alibaba.fastjson.JSON;
import com.wodaibao.profit.common.constants.Constants;
import com.wodaibao.profit.common.constants.SystemConfigBean;
import com.wodaibao.profit.model.ErrorDTO;
import com.wodaibao.profit.model.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器
 *
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(GlobalInterceptor.class);

    @Autowired
    private SystemConfigBean systemConfigBean;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader(Constants.JWT_HEADER);
            logger.info("解析token:" + token);
//            token = token.substring(Constants.JWT_TOKEN_HEAD.length());
//            Claims claims = JwtUtil.getClaimsFromToken(token);
            request.setAttribute("ctx",systemConfigBean.getContextPath());
        } catch (Exception e) {
            logger.error("解析token", e);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(ErrorEnum.AUTHORIZATION_EXPIRED.getHttpStatusCode());
            PrintWriter pw = response.getWriter();
            pw.append(JSON.toJSONString(new ErrorDTO(ErrorEnum.AUTHORIZATION_EXPIRED)));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
    }
}