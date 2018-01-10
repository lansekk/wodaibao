package com.wodaibao.report.service;


import com.wodaibao.report.model.BaseHrmResDTO;

import java.util.List;

/**
 * LoginService
 *
 */
public interface LoginService {

    /**
     * 获取用户信息
     *
     * @param baseHrmResDTO baseHrmResDTO
     * @return baseHrmResDTO
     */
    BaseHrmResDTO getHrmRes(BaseHrmResDTO baseHrmResDTO);

    /**
     * 获取用户列表
     *
     * @return List<BaseHrmResDTO>
     */
    List<BaseHrmResDTO> listHrmRes();
}
