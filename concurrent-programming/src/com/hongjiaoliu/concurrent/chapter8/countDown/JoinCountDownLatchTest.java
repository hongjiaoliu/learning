package com.hongjiaoliu.concurrent.chapter8.countDown;

/**
 * Created by liuhj on 2017/11/28.
 * Description : 等待多线程完成的CountDownLatch
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("enter parser1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser1 finished!");
            }
        });

        Thread parser2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("enter parser2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser2 finished!");
            }
        });

        parser1.start();
        parser2.start();

        parser1.join();
        parser2.join();
        System.out.println("all parser finished!");
    }
}
