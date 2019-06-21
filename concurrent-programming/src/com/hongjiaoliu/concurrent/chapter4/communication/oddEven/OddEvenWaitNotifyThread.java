package com.hongjiaoliu.concurrent.chapter4.communication.oddEven;

/**
 * @author : liuhj
 * @date : 2018/6/25
 * @email : liuhongjiao@weimingedu.com
 */
public class OddEvenWaitNotifyThread {
    private int start = 1;
    private boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) {
        OddEvenWaitNotifyThread oddEvenWaitNotifyThread = new OddEvenWaitNotifyThread();
        Thread oddThread = new Thread(new OddThread(oddEvenWaitNotifyThread), "oddThread");
        Thread evenThread = new Thread(new EvenThread(oddEvenWaitNotifyThread), "evenThread");
        oddThread.start();
        evenThread.start();
    }

    public static class OddThread implements Runnable {
        private OddEvenWaitNotifyThread oddEvenWaitNotifyThread;

        public OddThread(OddEvenWaitNotifyThread oddEvenWaitNotifyThread) {
            this.oddEvenWaitNotifyThread = oddEvenWaitNotifyThread;
        }

        @Override
        public void run() {
            //加锁，拥有lock的Monitor
            synchronized (lock) {
                while (oddEvenWaitNotifyThread.start <= 100) {
                    if (oddEvenWaitNotifyThread.flag) {
                        System.out.println(Thread.currentThread().getName() + "-" + oddEvenWaitNotifyThread.start);
                        oddEvenWaitNotifyThread.start++;
                        oddEvenWaitNotifyThread.flag = false;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }


        }
    }


    public static class EvenThread implements Runnable {
        private OddEvenWaitNotifyThread oddEvenWaitNotifyThread;

        public EvenThread(OddEvenWaitNotifyThread oddEvenWaitNotifyThread) {
            this.oddEvenWaitNotifyThread = oddEvenWaitNotifyThread;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (oddEvenWaitNotifyThread.start <= 100) {
                    if (!oddEvenWaitNotifyThread.flag) {
                        System.out.println(Thread.currentThread().getName() + "- " + oddEvenWaitNotifyThread.start);
                        oddEvenWaitNotifyThread.start++;
                        oddEvenWaitNotifyThread.flag = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
