package com.hezhenxing.base.common.interceptor;


import org.springframework.web.method.HandlerMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类描述： 用户登录权限认证 - 拦截器
 */
public class UserAuthInterceptor extends BaseInterceptor {

    /**
     * preHandle调用controller具体方法之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {

//            OutScrpit(response, "未经授权");
//            return false;
        }
        //直接返回true是无需验证的
        return true;
    }
}
