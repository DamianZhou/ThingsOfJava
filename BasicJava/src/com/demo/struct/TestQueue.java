package com.demo.struct;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("Hello");
		queue.offer("World!");
		queue.offer("你好！");

		System.out.println("size="+queue.size());

		String str;
		while( (str=queue.poll()) !=null ){
			System.out.println(str);
		}

		System.out.println(queue.size());
		
		ObjectQueueTest();
	}

	/**
	 * 测试元素为Object的Queue
	 * 
	 * 使用Object可以添加任意元素
	 */
	static void ObjectQueueTest(){
		
		System.out.println("----------------ObjectQueueTest Start------------------");
		
		Queue<Object> OQueue = new LinkedList<Object>();

		OQueue.offer(new String("Gona have a try!"));
		OQueue.offer(new Double(1111.23241111));
		OQueue.offer(new Integer(222));
		
		Object temp;
		while( (temp=OQueue.poll()) != null ){
			System.out.println(temp.toString());
		}
		
		System.out.println("-----------------ObjectQueueTest End-----------------");

	}

}
