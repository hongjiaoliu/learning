package com.hongjiaoliu.concurrent.test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuhj
 * @date : 2018/8/8
 * @email : liuhongjiao@weimingedu.com
 */
public class DemoHashMap extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2);
    static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while(at.get() < 100000){
            map.put(at.get(), at.get());
            at.incrementAndGet();
        }
    }
}
