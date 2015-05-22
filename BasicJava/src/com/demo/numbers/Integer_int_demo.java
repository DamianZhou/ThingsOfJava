package com.demo.numbers;

public class Integer_int_demo {

	/**
	 * java1.5 以后 装箱/拆箱
	 * @see http://www.cnblogs.com/shenliang123/archive/2012/04/16/2451996.html
	 */
	void Integer_int(){

		// int 基本数据类型
		// Integer 对象

		//声明一个Integer对象
		Integer num = 10;  //装箱，解析为: Integer num = new Integer(10);

		int num1 = num; //拆箱

		//进行计算时隐含的有自动拆箱
		System.out.println(--num);

		//-------------------------------------------

		//在-128~127 之外的数，自动装箱使用新的地址
		Integer a = 1100;
		Integer b=1100;
		int c = 1100;

		System.out.println("a==c "+(a==c?true:false));

		System.out.println("a!=b "+(a!=b?true:false));

		System.out.println("c==b "+(b==c?true:false));
	}

	public static void main(String[] args) {
		Integer_int_demo test = new Integer_int_demo();

		test.Integer_int();


	}

}
