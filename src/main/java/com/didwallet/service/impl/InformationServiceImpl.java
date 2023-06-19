package com.didwallet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.didwallet.common.CustomException;
import com.didwallet.common.Result;
import com.didwallet.mapper.ActiveMapper;
import com.didwallet.mapper.InformationMapper;
import com.didwallet.model.dto.UserDto;
import com.didwallet.model.po.Active;
import com.didwallet.model.po.Information;
import com.didwallet.service.InformationService;
import com.didwallet.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @author 俞静雯
 * @Description TODO
 * @date 2023-05-17  14:10
 */
@Service
@Slf4j
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information> implements InformationService {

    @Autowired
    InformationMapper informationMapper;

    @Autowired
    ActiveMapper activeMapper;

    @Override
    public Result<UserDto> getUser(Information information) {
        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Information::getEmail, information.getEmail());
        Information user = informationMapper.selectOne(queryWrapper);

        if (user == null){
            return Result.error("邮箱错误！", 0);
        }
        if (!user.getPassword().equals(information.getPassword())){
            return Result.error("密码错误，请重试！", 0);
        }

        String token = JwtUtil.getToken(user);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setToken(token);
        log.info("userDto:{}", userDto);

        return Result.success(userDto);
    }

    @Transactional
    @Override
    public Result<String> register(Information information) {
        // 查询是否已经有账号
        LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Information::getEmail, information.getEmail());
        Information user = informationMapper.selectOne(queryWrapper);
        if (user != null){
            return Result.error("邮箱已存在，请登录！");
        }

        // 注册,生成基础信息
        Information information1 = setInformation(information);
        int i1 = informationMapper.insert(information1);
        Active active = new Active(information1.getEmail(), 0, 0, 0, 0,0,0,0,0);
        int i2 = activeMapper.insert(active);

        if (i1 == 1 && i2 == 1)
            return Result.success("注册成功！");
        else{
            throw new CustomException("注册失败，请重试！");
        }
    }

    /**
     * 用于注册后生成个人基础信息,所有授权默认为0
     * @param information
     * @return
     */
    private Information setInformation(Information information) {
        information.setName("张三");
        information.setBirthday(LocalDate.parse("1990-01-01"));
        information.setCountry("CHN");
        information.setArea("Shang Hai");
        information.setSpeciality("软件工程");
        information.setUniversity("东华大学");
        information.setEnrollmentYear("2015");
        information.setVaccinum("Pfizer-BioNTech COVID-19 Vaccine");
        information.setVaccinationDate(LocalDate.parse("2021-09-15"));
        information.setLocation("Health Center A");
        information.setCompany("Baidu");
        information.setPosition("Bei Jing");
        information.setJoinedDate(LocalDate.parse("2021-03-20"));
        information.setDid("diddididididididid");
        return information;
    }
}
