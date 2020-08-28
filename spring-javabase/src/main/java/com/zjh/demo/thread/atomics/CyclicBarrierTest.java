package com.zjh.demo.thread.atomics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        showCycliebarrier();
    }
    private static void showCycliebarrier(){

       final List<Integer> result = new ArrayList<Integer>();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            public void run() {
                System.out.println("到达开始屏障了");
                for (int i=0;i<result.size();i++){
                    System.out.print(result.get(i) +"  ");
                }
                System.out.println();
                System.out.println("离开屏障了");
            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            executorService.submit(new Runnable() {
                public void run() {

                    Random random = null;
                    random = new Random();

                    int randomNum = random.nextInt(1000);
                    result.add(randomNum);

                    try {
                        System.out.println(Thread.currentThread().getName()+" is wait");
                        cyclicBarrier.await();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+" randomNum value is "+ randomNum);

                }
            });
        }
        executorService.shutdown();
    }
}
