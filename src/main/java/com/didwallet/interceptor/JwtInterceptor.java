package com.didwallet.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.didwallet.common.CustomException;
import com.didwallet.model.po.Information;
import com.didwallet.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 登录拦截器
 *
 * @author 俞静雯
 * @date 2023/2/28
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private InformationService informationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");

        //如果不是映射到方法，直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        //执行认证
        if (StrUtil.isBlank(token)) {
            throw new CustomException("无token，请登录！");
        }
        //获取token中的userid
        String userId;
        try{
            userId = JWT.decode(token).getAudience().get(0);
        }catch (Exception e){
            throw new CustomException("token验证失败！");
        }

        //验证用户信息
        Information user = informationService.getById(userId);
        if (user == null) {
            throw new CustomException("用户不存在！");
        }

        //用户密码加签验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        }catch (Exception e) {
            throw new CustomException("token验证失败！");
        }
        return true;

    }
}
