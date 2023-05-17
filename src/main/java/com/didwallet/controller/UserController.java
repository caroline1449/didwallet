package com.didwallet.controller;

import com.didwallet.common.Result;
import com.didwallet.model.dto.UserDto;
import com.didwallet.model.po.Information;
import com.didwallet.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author 俞静雯
 * @Description 用户登录注册
 * @date 2023-05-17  14:14
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    InformationService informationService;

    /**
     * 用户登录验证
     * @param information
     * @return
     */
    @PostMapping("/login")
    public Result<UserDto> login(@RequestBody Information information){
        log.info("information:{}", information);
        String password = information.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        information.setPassword(password);

        Result<UserDto> result = informationService.getUser(information);
        return result;
    }

    /**
     * 用户注册(两张表)
     * @param information
     * @return
     */
    @PutMapping("/register")
    public Result<String> register(@RequestBody Information information){
        String password = information.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        information.setPassword(password);

        Result<String> result = informationService.register(information);
        return result;
    }
}
