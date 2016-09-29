package com.hezhenxing.base.common.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with h-sm.
 * User: xing
 * Date: 2016/4/27
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class ThreadHandle {

    public static ExecutorService MarkingPool = Executors.newFixedThreadPool(5);

}
