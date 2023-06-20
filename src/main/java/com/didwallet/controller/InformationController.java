package com.didwallet.controller;

import cn.hutool.json.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.didwallet.common.Result;
import com.didwallet.model.dto.InformationDto;
import com.didwallet.model.po.Active;
import com.didwallet.model.po.Information;
import com.didwallet.model.po.Other;
import com.didwallet.service.ActiveService;
import com.didwallet.service.InformationService;
import com.didwallet.service.OtherService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class InformationController {
    @Autowired
    InformationService informationService;

    @Autowired
    ActiveService activeService;

    @Autowired
    OtherService otherService;
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

    @RequestMapping("/update")
    public Result<String> updateByEmail(@RequestParam Integer activeId, @RequestParam String email){
        log.info("ens:{}",email);
        activeService.updateByEmail(activeId, email);
        return Result.error("授权成功！");
    }

    @PostMapping("/send")
    public Result<String> send(@RequestBody Other other){

        otherService.sendData(other);
        log.info("other:{}", other);
        return Result.success("Success");
    }
}
