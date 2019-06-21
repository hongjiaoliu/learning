package com.hongjiaoliu.concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuhj on 2017/11/28.
 * Description :
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水B";
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exgr.exchange("B");
                    System.out.println("A和B的数据是否一致：" + A.equals(B)+ ",A录入的数据为："+A+",B录入的数据为："+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
