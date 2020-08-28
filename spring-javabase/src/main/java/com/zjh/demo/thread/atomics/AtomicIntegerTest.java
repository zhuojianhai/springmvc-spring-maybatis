package com.zjh.demo.thread.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) throws InterruptedException {
//        showAtomicInteger();
        showCountDownLatch();
    }
    private static void showCountDownLatch() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            final int finalI = i;
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"  "  + finalI);
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName()+" 执行完毕");
                }
            });
        }

        executorService.shutdown();
        System.out.println("主线程等待子线程执行完毕");
        countDownLatch.await();
        System.out.println("主线程执行完毕");
    }
    private static void showAtomicInteger(){
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<20;i++){
            executorService.submit(new Runnable() {
                public void run() {
                        int value = atomicInteger.getAndIncrement();
                        System.out.println(Thread.currentThread().getName() +" value is " +value);
                }
            });
        }
        executorService.shutdown();
    }
}
