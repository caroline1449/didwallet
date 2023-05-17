package com.didwallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.didwallet.model.po.Active;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  14:10
 */
public interface ActiveService extends IService<Active> {

    /**
     * 授权身份
     * @param activeId
     * @param email
     */
    void updateByEmail(Integer activeId, String email);
}
