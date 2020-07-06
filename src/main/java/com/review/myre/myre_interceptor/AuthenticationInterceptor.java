/**
 * @Project Name: myre
 * @File Name: AuthenticationInterceptor
 * @author wangzhihao E-mail: w15603919702@gmail.com
 * @date 2020-06-29 9:04 PM
 * @version 1.0
 * @By IDE: IntelliJ IDEA
 */
package com.review.myre.myre_interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.review.myre.controller.vo.PassToken;
import com.review.myre.controller.vo.UserLoginToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){

            return true;
        }

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        // 检查是否有passtoken注解，有则跳过
        if (method.isAnnotationPresent(PassToken.class)){
            PassToken p = method.getAnnotation(PassToken.class);

            if (p.required()){
                return true;
            }
        }

        //有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)){

            UserLoginToken u = method.getAnnotation(UserLoginToken.class);
            if (u.required()){

                if(token == null){
                    throw new RuntimeException("No authentication, please login");
                }
                // 获取 token 中的userid

                try{
                String useId = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException e){

                    throw new RuntimeException("401");
                }
//                User user = userService.findUserById(userId);
//                if (user == null) {
//                    throw new RuntimeException("用户不存在，请重新登录");
//                }
//                // 验证 token
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//                try {
//                    jwtVerifier.verify(token);
//                } catch (JWTVerificationException e) {
//                    throw new RuntimeException("401");
//                }
//                return true;

            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
