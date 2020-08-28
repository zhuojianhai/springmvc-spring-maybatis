package com.zjh.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrinterNumber {
    private int max = 100;
    AtomicInteger status = new AtomicInteger(1);


    public void printNumber(int type){

        if (type ==1){
            while (status.get()<=max){
                System.out.println(Thread.currentThread().getName());
                synchronized (PrinterNumber.class){//这段代码执行完 ，释放锁
                    if (status.get()<=max && status.get()%2==0){
                        System.out.println("奇数 "+status.getAndIncrement());
                    }
                }

            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+Thread.currentThread().getName());
        }else{
            while (status.get()<=max){
                System.out.println(Thread.currentThread().getName());
                synchronized (PrinterNumber.class){//这段代码执行完 ，释放锁
                    if (status.get()<=max && status.get()%2!=0){
                        System.out.println("偶数 "+status.getAndIncrement());
                    }
                }

            }
            System.out.println("====================================="+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        final PrinterNumber printerNumber = new PrinterNumber();
//        new Thread(new Runnable() {
//            public void run() {
//                printerNumber.printNumber(2);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            public void run() {
//                printerNumber.printNumber(1);
//            }
//        }).start();


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(printerNumber.new Myrunnable1());
        executorService.submit(printerNumber.new Myrunnable2());
        executorService.shutdown();
    }


    /**
     * 奇数任务
     */
    class Myrunnable1 implements Runnable{
        public void run() {
            while (status.get()<=max){
                synchronized (status){
                    if (status.get()<=max && status.get()%2!=0){
                        System.out.println(Thread.currentThread().getName() +" 奇数："+status.getAndIncrement());
                    }

                }
            }
        }
    }

    /**
     * 偶数任务
     */
    class Myrunnable2 implements Runnable{
        public void run() {
            while (status.get()<=max){
                synchronized (status){
                    //status.get()<=max 不加这个判断，会多打印 到101
                    if (status.get()<=max &&  status.get()%2==0){
                        System.out.println(Thread.currentThread().getName() +" 偶数： "+status.getAndIncrement());
                    }

                }
            }
        }
    }
}
