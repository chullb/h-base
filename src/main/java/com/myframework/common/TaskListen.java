package com.myframework.common;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2016/4/27.
 */
public class TaskListen implements ServletContextListener {

    private static Logger logger = Logger.getLogger(TaskListen.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("程序开始执行TaskListen.contextInitialized()..");
        for (int i = 0; i < 5; i++) {
            ThreadHandle.MarkingPool.execute(new TestThread());
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("程序结束执行TaskListen.contextDestroyed()..");
        ThreadHandle.MarkingPool.shutdown();
    }
}
