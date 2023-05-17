package com.didwallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.didwallet.common.Result;
import com.didwallet.model.dto.UserDto;
import com.didwallet.model.po.Information;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  14:10
 */
public interface InformationService extends IService<Information> {
    /**
     * 验证用户登录信息
     * @param information 邮箱和加密完成的密码
     * @return
     */
    Result<UserDto> getUser(Information information);

    /**
     * 用户注册
     * @param information
     * @return
     */
    Result<String> register(Information information);
}
