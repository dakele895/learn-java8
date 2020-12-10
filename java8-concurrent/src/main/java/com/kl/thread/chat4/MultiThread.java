package com.kl.thread.chat4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author: dalele
 * @date: 2020/11/29 22:22
 * @description:
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取java线程的管理
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和sychronized信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo: threadInfos){
            System.out.println(threadInfo.getThreadId()+"------------"+threadInfo.getThreadName());
        }


    }



}
