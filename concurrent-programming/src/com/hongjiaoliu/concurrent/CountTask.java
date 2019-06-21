package com.hongjiaoliu.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by liuhj on 2017/9/6.
 * Description :
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;//阈值

    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask countTask1 = new CountTask(start, middle);
            CountTask countTask2 = new CountTask(middle + 1, end);
            //执行子任务
            countTask1.fork();
            countTask2.fork();
            //等待子任务执行完，并得到其结果
            Integer result1 = countTask1.join();
            Integer result2 = countTask2.join();
            //合并子任务
            sum = result1 + result2;
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(1, 1000000);
        //执行一个任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try {
            Integer integer = result.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
