package com.Basic.Algorithm;


/**
 * 二分查找
 * 
 * @author Damian
 *
 */
public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class BinarySearchPackage{


	/**
	 * 二分查找(递归方式)
	 *
	 * @param <E>
	 * @param array 需要查找的有序数组
	 * @param from 起始下标
	 * @param to 终止下标
	 * @param key 需要查找的关键字
	 * @return
	 * @throws Exception
	 */
	public static <E extends Comparable<E>> int binarySearch(E[] array, int from, int to, E key) throws Exception {
		if (from < 0 || to < 0) {
			throw new IllegalArgumentException("params from & length must larger than 0 .");
		}
		if (from <= to) {
			int middle = (from >>> 1) + (to >>> 1); // 右移即除2
			E temp = array[middle];
			if (temp.compareTo(key) > 0) {
				to = middle - 1;
			} else if (temp.compareTo(key) < 0) {
				from = middle + 1;
			} else {
				return middle;
			}
		}
		return binarySearch(array, from, to, key);
	}
	
	
	/**
	 * 二分查找（非递归）---待定
	 * @param a
	 * @param fromIndex
	 * @param toIndex
	 * @param key
	 * @return
	 */
	public static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
	    int low = fromIndex;
	    int high = toIndex - 1;
	    while (low <= high) {
	        int mid = (low + high) >>> 1;
	        int midVal = a[mid];
	        if (midVal < key)
	        low = mid + 1;
	        else if (midVal > key)
	        high = mid - 1;
	        else
	        return mid; // key found
	    }
	    return -(low + 1);  // key not found.
	    }

}