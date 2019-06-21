package com.hongjiaoliu.concurrent.chapter4.communication;

/**
 * @author : liuhj
 * @date : 2018/6/22
 * @email : liuohongjiao@weimingedu.com
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class){

        }
        m();
    }
    public static synchronized void m(){

    }
}
