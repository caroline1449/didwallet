package com.didwallet.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.didwallet.model.po.Information;
import com.didwallet.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * jwt工具类
 *
 * @author 俞静雯
 * @date 2023/2/28
 */
@Component
public class JwtUtil {

    private static InformationService staticInformationService;

    @Autowired
    private InformationService informationService;

    @PostConstruct
    public void setUserService(){
        staticInformationService = informationService;
    }

    /**
     * 生成token
     * @param information
     * @return
     */
    public static String getToken(Information information) {
        return JWT.create().withAudience((information.getId().toString()))
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(information.getPassword()));
    }

    /**
     * 获取当前登录的用户信息
     * @return
     */
    public static Information getCurrentUser(){
        Information user = new Information();
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)) {
                String userId = JWT.decode(token).getAudience().get(0);
                user = staticInformationService.getById(userId);
            }
        }catch (Exception e) {
            return null;
        }
        return user;
    }

}
