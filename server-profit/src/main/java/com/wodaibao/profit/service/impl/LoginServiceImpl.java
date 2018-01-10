package com.wodaibao.profit.service.impl;

import com.wodaibao.profit.dao.LoginDao;
import com.wodaibao.profit.model.BaseHrmResDTO;
import com.wodaibao.profit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MemberServiceImpl
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    /**
     * 获取用户信息
     *
     * @param baseHrmResDTO baseHrmResDTO
     * @return baseHrmResDTO
     */
    @Override
    public BaseHrmResDTO getHrmRes(BaseHrmResDTO baseHrmResDTO) {
        return loginDao.getHrmRes(baseHrmResDTO);
    }

    /**
     * 获取用户列表
     *
     * @return List<BaseHrmResDTO>
     */
    @Override
    public List<BaseHrmResDTO> listHrmRes() {
        return loginDao.listHrmRes();
    }
}
