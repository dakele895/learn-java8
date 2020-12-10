package io.github.biezhi.java8.concurrent;

/**
 * @author: dalele
 * @date: 2020/11/22 01:13
 * @description:
 */
public class VolatileDemo {
    int a=0;

    volatile boolean flag=false;

    public void writer(){
        a=1;
        flag=true;
    }


    public void  reader(){
        if (false){
           int i=a;
        }
    }


    /**
     happens-before验证
     * @param volatileDemo
     */
    public static void test1(VolatileDemo volatileDemo){
        Runnable runnable=() ->{
            volatileDemo.writer();
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

    /**
     happens-before验证
     * @param volatileDemo
     */
    public static void test2(VolatileDemo volatileDemo){
        Runnable runnable=() ->{
            volatileDemo.reader();
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }


    public static void main(String[] args) {
        VolatileDemo volatileDemo=new VolatileDemo();
        VolatileDemo.test1(volatileDemo);
        VolatileDemo.test2(volatileDemo);
        VolatileDemo.test2(volatileDemo);
        VolatileDemo.test2(volatileDemo);

    }

}
