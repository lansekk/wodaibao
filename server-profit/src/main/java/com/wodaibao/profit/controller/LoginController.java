package com.wodaibao.profit.controller;

import com.wodaibao.profit.model.BaseHrmResDTO;
import com.wodaibao.profit.service.LoginService;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户相关业务控制器
 */
@RestController
@RequestMapping("/v1/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 用户登录
     *
     * @param baseHrmResDTO 用户对象
     * @return ResponseEntity
     */
    @PostMapping("/hrm")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiResponses({@ApiResponse(code = 200, message = "true:登录成功 false:登录失败")})
    public ResponseEntity<?> getBaseHrmResDTO(@ApiParam(value = "登陆用户对象", required = true) @RequestBody BaseHrmResDTO baseHrmResDTO) {
        BaseHrmResDTO hrd = loginService.getHrmRes(baseHrmResDTO);
        if (null != hrd) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

    /**
     * 获取用户列表
     * @return List<BaseHrmResDTO>
     */
    @PostMapping("/hrm/list")
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @ApiResponses({@ApiResponse(code = 200, message = "获取用户列表集合")})
    public List<BaseHrmResDTO> listBaseHrmRes() {
        return loginService.listHrmRes();
    }
}