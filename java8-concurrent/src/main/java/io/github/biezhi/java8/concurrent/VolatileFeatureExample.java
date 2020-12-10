package io.github.biezhi.java8.concurrent;

/**
 * @author: dalele
 * @date: 2020/11/22 00:40
 * @description:
 */
public class VolatileFeatureExample {
    volatile  long vl=0L;

    public void set(long l){
        System.out.println(vl+"--------------------1");
        vl=l;
        System.out.println(vl+"--------------------2");
    }

    public long getAndIncrement(){
        vl++;
        System.out.println(vl+"-------------------------------------");
       return vl;

    }


    public  long get(){
        return vl;

    }

    /**
     原子性验证1
     * @param volatileFeatureExample
     */
    public static void test1(VolatileFeatureExample volatileFeatureExample){
        Runnable runnable=() ->{
            volatileFeatureExample.set(2);
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }
    /**
     原子性验证2
     * @param volatileFeatureExample
     */
    public static void test2(VolatileFeatureExample volatileFeatureExample){
        Runnable runnable=() ->{
            long l = volatileFeatureExample.get();
            System.out.println(l);
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }
    /**
     不具有原子性
     * @param volatileFeatureExample
     */
    public static void test3(VolatileFeatureExample volatileFeatureExample){
        Runnable runnable=() ->{
            long l = volatileFeatureExample.getAndIncrement();
            System.out.println(l);
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }


    public static void main(String[] args) {
        VolatileFeatureExample volatileFeatureExample=new VolatileFeatureExample();
       /* VolatileFeatureExample.test2(volatileFeatureExample);
        VolatileFeatureExample.test1(volatileFeatureExample);*/
        VolatileFeatureExample.test3(volatileFeatureExample);
        VolatileFeatureExample.test3(volatileFeatureExample);
        VolatileFeatureExample.test3(volatileFeatureExample);



    }



}
