package com.didwallet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.didwallet.mapper.ActiveMapper;
import com.didwallet.model.po.Active;
import com.didwallet.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  16:39
 */
@Service
public class ActiveServiceImpl extends ServiceImpl<ActiveMapper, Active> implements ActiveService {
    @Autowired
    ActiveMapper activeMapper;

    @Override
    public void updateByEmail(Integer activeId, String email) {
        LambdaQueryWrapper<Active> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Active::getEmail, email);
        Active active = activeMapper.selectOne(queryWrapper);

        if(active == null){
            throw new RuntimeException("系统错误，找不到用户！");
        }

        if (activeId == 1){
            active.setIdActive(1);
        }else if (activeId == 2){
            active.setStActive(1);
        }else if(activeId == 3){
            active.setVcActive(1);
        }else if(activeId == 4){
            active.setCpActive(1);
        }
        activeMapper.update(active, queryWrapper);
    }
}
