package com.didwallet.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.didwallet.common.Result;
import com.didwallet.model.dto.InformationDto;
import com.didwallet.model.po.Active;
import com.didwallet.model.po.Information;
import com.didwallet.service.ActiveService;
import com.didwallet.service.InformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  15:32
 */
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    InformationService informationService;

    @Autowired
    ActiveService activeService;

    /**
     * 根据email查询到所有的信息及授权状态
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public Result<InformationDto> getInformation(@PathVariable String email){
        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Information::getEmail, email);
        Information information = informationService.getOne(queryWrapper);

        LambdaQueryWrapper<Active> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Active::getEmail, email);
        Active active = activeService.getOne(queryWrapper1);

        InformationDto informationDto = new InformationDto();
        BeanUtils.copyProperties(information, informationDto);
        BeanUtils.copyProperties(active, informationDto);

        return Result.success(informationDto);
    }
}
