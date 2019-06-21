package com.hongjiaoliu.concurrent.chapter8.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuhongjao
 * @date 2019/6/20 14:46
 */

public class CyclicBarrierTest3 {
	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
			}
		});

		thread.start();
		thread.interrupt();
		try {
			c.await();
		} catch (Exception e) {
			System.out.println(c.isBroken());
		}
	}
}
