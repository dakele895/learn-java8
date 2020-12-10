package com.kl.thread.chat4;

import java.util.concurrent.TimeUnit;

/**
 * @author: dalele
 * @date: 2020/11/29 23:03
 * @description:
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
