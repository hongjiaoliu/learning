package com.hongjiaoliu.concurrent.chapter8.countDown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liuhj on 2017/11/28.
 * Description :
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args)  throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }
}
