package SourceCode.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import SourceCode.util.LinkedList;

public class CollectionTest {
	
	void testArray(){
		int[] nums = {1,2,3,4,5};
		nums = (int[]) testArray_copy(nums, 10);
		
		System.out.println( Arrays.toString(nums) );
	}
	
	/**
	 * 拷贝元素到指定长度的数组
	 * @param 通用数组 obj
	 * @param newLen
	 * @return
	 */
	Object testArray_copy(Object obj,int newLen){
		Class c = obj.getClass();
		if(!c.isArray())
			return null;
		Class componentType = c.getComponentType();
		int length = Array.getLength(obj);
		Object newArray = Array.newInstance(componentType, newLen);
		System.arraycopy(obj,0,newArray,0, Math.min(length, newLen));
		return newArray;
	}
	
	void testLinkedlist(){
		SourceCode.util.LinkedList<Integer> list = new LinkedList<>();
		
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(null);
		
		System.out.println(list.size());		
	}
	
	void testArraylist(){
		ArrayList<Integer> arraylist = new ArrayList<Integer>(10);
		arraylist.add(null);
		arraylist.add(null);
		arraylist.add(null);
		arraylist.add(null);
		System.out.println(arraylist.size()); //4		
	}
	
	void testHashMap(){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(10);
	}

	public static void main(String[] args) {
		
		CollectionTest test = new CollectionTest();
		test.testArray();

	}

}
