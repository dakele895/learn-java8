package com.kl.thread.chat4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: dalele
 * @date: 2020/11/30 23:56
 * @description:
 */
public class WaitNotify {

    static boolean flag=true;

    static Object lock=new Object();


    public static void main(String[] args) throws Exception {
        Thread waitThread=new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }




    static class Wait implements  Runnable{


        @Override
        public void run() {

            synchronized (lock){

                while (flag){

                    try {
                        System.out.println(Thread.currentThread()+"flag is true. wait@ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }catch (InterruptedException e){

                    }


                }

                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+"flag is false. running @"+ new SimpleDateFormat("HH:mm:ss").format(new Date()));


            }


        }

    }
    static class Notify implements  Runnable{

        @Override
        public void run() {

            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock noyify @"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag= false;
                SleepUtils.second(5);


            }

            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock again sleep @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }


        }
    }











}
