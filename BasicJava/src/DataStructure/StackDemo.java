package DataStructure;

import java.util.EmptyStackException;

/**
 * 内存泄露 Demo
 * 
 * 假如堆栈加了10个元素,然后全部弹出来.
 * 虽然堆栈是空的,没有我们要的东西,
 * 但是这是个对象是无法回收的,
 * 
 * 这个才符合了内存泄露的两个条件:无 用,无法回收。
 * @author DamianZhou
 *
 */
public class StackDemo {
	private Object[] elements=new Object[10]; 
	private int size = 0;
	
	public void push(Object e){ 
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop(){
		if( size == 0)
			throw new EmptyStackException(); 
		return elements[--size];
	}
	
	private void ensureCapacity(){
		if(elements.length == size){
			Object[] oldElements = elements;
			elements = new Object[2 * elements.length+1];
			
			System.arraycopy(oldElements,0, elements, 0, size);//拷贝数组
		}
	}
	
}
