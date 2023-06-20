package com.didwallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.didwallet.common.Result;
import com.didwallet.mapper.OtherMapper;
import com.didwallet.model.po.Other;
import com.didwallet.service.OtherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OtherServiceImpl extends ServiceImpl<OtherMapper,Other> implements OtherService {

    @Autowired
    OtherMapper otherMapper;

    @Override
    public Result<String> sendData(Other other) {
        Integer id = otherMapper.getIdByTextAndEmail(other);
        System.out.println("ds");
        if (id != null) {
            other.setId(Long.valueOf(id));
            otherMapper.updateDataById(other);
        } else {
            otherMapper.insertData(other);
        }
        return Result.success("Success");
    }

}
