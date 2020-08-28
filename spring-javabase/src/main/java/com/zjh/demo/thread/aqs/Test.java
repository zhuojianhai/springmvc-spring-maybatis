package com.zjh.demo.thread.aqs;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        final BoundedBufferTest boundedBuffer = new BoundedBufferTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run");
//                for (int i=0;i<20;i++) {
//                    try {
//                        System.out.println("putting..");
//                        boundedBuffer.put(Integer.valueOf(i));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                while (true){
                    Random random = new Random();
                    int i = random.nextInt(1000);
                    try {
                        System.out.println(Thread.currentThread().getName()+" 生产者 putting..");
                        boundedBuffer.put(Integer.valueOf( i));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }) ;

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i=0;i<20;i++) {
//                    try {
//                        Object val = boundedBuffer.take();
//                        System.out.println(val);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                while (true){
                    try {
                        Object val = boundedBuffer.take();
                        System.out.println(Thread.currentThread().getName() +" 消费者"+val);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }) ;

        t1.start();
        t2.start();
    }
}
