package io.github.biezhi.java8.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: dalele
 * @date: 2020/11/23 22:41
 * @description:
 */
public class ReentrantLockExample {

    int  a    =0;
    ReentrantLock lock =new ReentrantLock(true);

    public  void writer(){
        lock.lock();



        try {
            a++;
            Thread t = Thread.currentThread();
            String name = t.getName();
            System.out.println(name);

        }finally {
            lock.unlock();
        }


    }


    public void reader(){
        lock.lock();

        try {
            int i=a;
            Thread t = Thread.currentThread();
            String name = t.getName();
            System.out.println(name);

        }finally {
            lock.unlock();
        }


    }


    /**
     happens-before验证
     * @param reentrantLockExample
     */
    public static void test1(ReentrantLockExample reentrantLockExample){
        Runnable runnable=() ->{
            reentrantLockExample.writer();
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

    /**
     happens-before验证
     * @param reentrantLockExample
     */
    public static void test2(ReentrantLockExample reentrantLockExample){
        Runnable runnable=() ->{
            reentrantLockExample.reader();
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }


    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample=new ReentrantLockExample();

        ReentrantLockExample.test1(reentrantLockExample);
        ReentrantLockExample.test2(reentrantLockExample);
        ReentrantLockExample.test2(reentrantLockExample);
        ReentrantLockExample.test2(reentrantLockExample);



    }


}
