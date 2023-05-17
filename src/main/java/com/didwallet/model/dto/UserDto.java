package com.didwallet.model.dto;

import lombok.Data;

/**
 * @author 俞静雯
 * @Description 用户登录模型类
 * @date 2023-05-17  19:28
 */
@Data
public class UserDto {
    private Long id;

    private String email;

    private String password;

    private String token;
}
