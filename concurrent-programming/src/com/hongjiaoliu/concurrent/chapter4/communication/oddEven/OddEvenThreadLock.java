package com.hongjiaoliu.concurrent.chapter4.communication.oddEven;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : liuhj
 * @date : 2018/6/25
 * @email : liuhongjiao@weimingedu.com
 */
public class OddEvenThreadLock {
    private int start = 1;
    private boolean flag = true;
    /**
     * 重入锁
     */
    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        OddEvenThreadLock oddEvenThreadLock = new OddEvenThreadLock();
        Thread oddThread = new Thread(new OddThread(oddEvenThreadLock), "oddThread");
        Thread evenThread = new Thread(new EvenThread(oddEvenThreadLock), "evenThread");
        oddThread.start();
        evenThread.start();
    }

    public static class OddThread implements Runnable {
        private OddEvenThreadLock oddEvenThreadLock;

        public OddThread(OddEvenThreadLock oddEvenThreadLock) {
            this.oddEvenThreadLock = oddEvenThreadLock;
        }

        @Override
        public void run() {
            while (oddEvenThreadLock.start <= 100) {
                if (oddEvenThreadLock.flag) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "-" + oddEvenThreadLock.start);
                    oddEvenThreadLock.start++;
                    oddEvenThreadLock.flag = false;
                    lock.unlock();
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }


    public static class EvenThread implements Runnable {
        private OddEvenThreadLock oddEvenThreadLock;

        public EvenThread(OddEvenThreadLock oddEvenThreadLock) {
            this.oddEvenThreadLock = oddEvenThreadLock;
        }

        @Override
        public void run() {
            while (oddEvenThreadLock.start <= 100) {
                if (!oddEvenThreadLock.flag) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "-" + oddEvenThreadLock.start);
                    oddEvenThreadLock.start++;
                    oddEvenThreadLock.flag = true;
                    lock.unlock();
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
