package com.demo.bitop;

import java.util.BitSet;

/**
 * BitSet 初始为 64 ，以后申请为 64*n
 * 打印结果，打印每个值为true的index；如果全部是false，打印“{}”
 * 
 * @author DamianZhou
 *
 */
public class BitSetDemo {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		System.out.println(flag);
		
		BitSet bs1 = new BitSet();		//64	默认&最小 初始大小 就是 64，Long的长度
		
		BitSet bs2 = new BitSet(88);	//128
		
		bs1.set(0, 64); //使用全部的64位
		
		System.out.println(bs1.toString());
		System.out.println(bs2.toString());
		
		System.out.println(bs1.size());
		System.out.println(bs2.size());
		

	}

}
