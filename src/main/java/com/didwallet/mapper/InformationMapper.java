package com.didwallet.mapper;

import com.didwallet.model.po.Information;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 俞静雯
 */
@Mapper
public interface InformationMapper extends BaseMapper<Information> {

}
