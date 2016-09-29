package com.hezhenxing.base.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class SpringContextUtil implements ApplicationContextAware {
  
    // Spring应用上下文环境  
    private static ApplicationContext applicationContext;
  
    public static void setApplicationContextStaticlly(ApplicationContext vApplicationContext)
    {  
        SpringContextUtil.applicationContext = vApplicationContext;  
    }  
  
    

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = (WebApplicationContext) applicationContext;
    }  
  

    public static ApplicationContext getApplicationContext() {
        return applicationContext;  
    }  
  
    /** 
     * 获取对象 
     */  
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);  
    }  
  
} 
