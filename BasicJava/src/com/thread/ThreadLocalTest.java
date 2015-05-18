package com.thread;

/**
 * 
 * 最常见的ThreadLocal使用场景为 用于 【数据库连接】、【Session管理】等。
 * 
 * @author DamianZhou
 * @see http://www.cnblogs.com/dolphin0520/p/3920407.html
 */
public class ThreadLocalTest {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();


	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void main(String[] args) throws InterruptedException {
		final ThreadLocalTest test = new ThreadLocalTest();

		test.set();
		System.out.println(test.getLong()); // 1
		System.out.println(test.getString()); // main


		Thread thread1 = new Thread(){
			public void run() {
				test.set();
				System.out.println(test.getLong()); // 8 
				System.out.println(test.getString()); // Thread-0
			};
		};
		thread1.start();
		thread1.join();

		System.out.println("-------------");
		
		System.out.println(test.getLong()); // 1
		System.out.println(test.getString()); // main
	}
}
