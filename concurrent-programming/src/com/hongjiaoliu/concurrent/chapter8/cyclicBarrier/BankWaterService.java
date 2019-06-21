package com.hongjiaoliu.concurrent.chapter8.cyclicBarrier;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by liuhj on 2017/11/28.
 * Description :
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class BankWaterService implements Runnable {
    /**
     * 创建4个屏障，处理完成之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4,this);

    /**
     * 假设只有4个sheet,所以启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //计算当前sheet 的银流数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    System.out.println("....1");
                    //银流计算完成，插入一个屏障
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        System.out.println("this.run");
        int result = 0;
        for(Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        //将结果输出
        sheetBankWaterCount.put("result",result);
        System.out.println(result);

    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }


}
