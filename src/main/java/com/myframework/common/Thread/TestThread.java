package com.myframework.common.Thread;

import org.apache.log4j.Logger;

/**
 * Created with h-sm.
 * User: xing
 * Date: 2016/4/27
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
public class TestThread extends Thread {

    private static Logger logger = Logger.getLogger(TestThread.class);

    @Override
    public void run() {
        while (true) {
            for(int i=0;i<4;i++){
                System.out.println(i);
            }
        }
    }
}
