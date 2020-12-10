package io.github.biezhi.java8.concurrent;

/**
 * @author: dalele
 * @date: 2020/11/25 00:12
 * @description:
 */
public class FinalExample {

    int i;

   final int j;

    FinalExample obj;

    public FinalExample() {
        i=1;
        j=2;
        Thread thread=new Thread();
        System.out.println(i+"------"+j+"---------"+thread.getName());
    }

    public  void writer(){
        obj=new FinalExample();
    }

    public  void reader(){
        FinalExample object=obj;
        int a=object.i;
        int b=object.j;
        System.out.println(a+"------"+b);

    }

    public static void test1(FinalExample finalExample){
        Runnable runnable=() ->{
            Thread thread=new Thread();
            System.out.println(thread.getName());
            finalExample.writer();
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

    public static void test2(FinalExample finalExample){
        Runnable runnable=() ->{
            Thread thread=new Thread();
            System.out.println(thread.getName());
            finalExample.reader();
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }


    public static void main(String[] args) {
        FinalExample finalExample=new FinalExample();
        FinalExample.test1(finalExample);
        FinalExample.test2(finalExample);




    }




}
