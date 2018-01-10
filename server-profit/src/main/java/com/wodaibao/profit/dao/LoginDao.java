package com.wodaibao.profit.dao;

import com.wodaibao.profit.model.BaseHrmResDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LoginDao
 *
 */
@Mapper
@Repository
public interface LoginDao {

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
