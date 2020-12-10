package io.github.biezhi.java8.concurrent;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author: dalele
 * @date: 2020/11/10 23:06
 * @description:
 */
public class ConcurrencyTest {

    private  static final long count=100000000L;

    public static void main(String[] args) throws InterruptedException {

            concuttency();
            serial();








    }


    /**
     * 多线程执行
     * @throws InterruptedException
     */
    private  static void concuttency() throws  InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for(long i=0;i<count;i++){
                    a+=5;
                }
            }
        });
        thread.start();
        int b=0;
        for (long i=0;i<count;i++){
            b--;
        }

        long time=System.currentTimeMillis()-start;
        thread.join();
        System.out.println("concurrency:"+time + "ms,b"+b);
    }

    /**
     * 单线程执行
     */
    private  static void serial(){
        long start = System.currentTimeMillis();

        int a=0;
        for (long i=0;i<count;i++){
            a+=5;
        }
        int b=0;

        for (long i=0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;

        System.out.println("serial:"+time+"ms,b="+b+",a="+a);
    }










}
