package com.didwallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.didwallet.common.Result;
import com.didwallet.model.po.Other;

public interface OtherService extends IService<Other> {

    Result<String> sendData(Other other);
}
