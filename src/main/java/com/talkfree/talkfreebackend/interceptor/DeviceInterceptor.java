package com.talkfree.talkfreebackend.interceptor;

import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class DeviceInterceptor implements HandlerInterceptor {

    @Resource
    private RedisOperations<String, String> operations;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Browser is "+request.getHeader("User-Agent"));
        System.out.println(request.getRemoteAddr());

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods",
                "POST, GET, OPTIONS,PUT, HEAD, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

//        Cookie[] cookies = request.getCookies();
//        if(cookies != null) {
//            for (Cookie cookie: cookies
//            ) {
//                if(cookie.getName().equals("sessionId")) {
//                    System.out.println("Cookie value from request is "+cookie.getValue());
//                    boolean isMember = operations.opsForSet().isMember("sessionId", cookies[0].getValue());
//                    System.out.println(isMember);
//                    return true;
//                }else {
//                    System.out.println(false);
//                    return true;
//                }
//            }
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
