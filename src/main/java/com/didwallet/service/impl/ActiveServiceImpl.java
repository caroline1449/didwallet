package com.didwallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.didwallet.mapper.ActiveMapper;
import com.didwallet.model.po.Active;
import com.didwallet.service.ActiveService;
import org.springframework.stereotype.Service;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  16:39
 */
@Service
public class ActiveServiceImpl extends ServiceImpl<ActiveMapper, Active> implements ActiveService {
}
