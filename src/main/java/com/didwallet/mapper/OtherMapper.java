package com.didwallet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.didwallet.model.po.Other;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OtherMapper extends BaseMapper<Other> {

    Integer getIdByTextAndEmail(Other other);

    // 根据id更新数据
    int updateDataById(Other other);

    // 插入数据
    int insertData(Other other);
}
