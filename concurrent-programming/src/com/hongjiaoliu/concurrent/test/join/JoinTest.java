package com.hongjiaoliu.concurrent.test.join;

/**
 * @author liuhongjao
 * @date 2019/6/5 10:22
 */

public class JoinTest {

	private static void method1(){
		final Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t1 is finished!");
			}
		});

		final Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2 is finished!");
			}
		});

		final Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t3 is finished!");
			}
		});

		t1.start();
		t3.start();
		t2.start();
	}

	private static void method2(){
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "执行完成!");
			}
		};
		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");
		Thread t3 = new Thread(runnable, "t3");

		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		JoinTest.method1();
		JoinTest.method2();
	}
}
