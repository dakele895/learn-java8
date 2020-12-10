package io.github.biezhi.java8.concurrent;

/**
 * @author: dalele
 * @date: 2020/11/25 00:12
 * @description:
 */
public class FinalReferenceEscapeExample {

    final int i;

   static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample() {
        i=1;
        obj=this;
    }

    public static void writer(){
        obj=new FinalReferenceEscapeExample();
    }

    public static void reader(){
      if (obj!=null){
          System.out.println(obj.i);
      }

    }


    public static void main(String[] args) throws InterruptedException {
        Thread one=new Thread(new Runnable() {
            @Override
            public void run() {
                FinalReferenceEscapeExample.writer();
            }
        });

        Thread two=new Thread(new Runnable() {
            @Override
            public void run() {
                FinalReferenceEscapeExample.reader();
            }
        });
        Thread three=new Thread(new Runnable() {
            @Override
            public void run() {
                FinalReferenceEscapeExample.reader();
            }
        });

        one.start();
        two.start();
        three.start();
        three.join();
        one.join();
        two.join();

    }




}
