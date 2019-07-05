package com.hongjiaoliu.concurrent.chapter8.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by liuhj on 2017/11/28.
 * Description :
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data.");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

}
