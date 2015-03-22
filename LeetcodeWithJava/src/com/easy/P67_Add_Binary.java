package com.easy;


/**
 * Given two binary strings, return their sum (also a binary string).

	For example,
	a = "11"
	b = "1"
	Return "100".
 * 
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/add-binary/
 */
public class P67_Add_Binary {
	
	/**
	 * Java 中的Long有对应的转化方式
	 * Runtime Error Message，无法解析太长的字符串
	 * @param a
	 * @param b
	 * @return
	 */
    public static String addBinary1(String a, String b) {
    	long num=Long.parseLong(a,2)+Long.parseLong(b,2);
    	return Long.toBinaryString(num);
    }
    
    /**
     * 手动实现二进制加法
     * 统一比较格式，从后向前
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
    	int lena=a.length();
    	int lenb=b.length();
    	int len=lena<lenb?lena:lenb;
    	if(len==0)    		return a+b; //有空字符串
    	
        int carry = 0;
        int l1 = lena - 1;//作为下标
        int l2 = lenb - 1;
        StringBuilder sb = new StringBuilder();		//字符串经常需要改变，用StringBuffer（线程安全） / 单线程中使用StringBuilder快一点（非线程安全）
        while (l1 >= 0 || l2 >= 0 || carry != 0) {
            int tmp = (l1 >= 0 ?  Integer.parseInt(a.charAt(l1--)+"") : 0) + (l2 >= 0 ?  Integer.parseInt(b.charAt(l2--)+"") : 0) + carry;
            carry = tmp >= 2 ? 1 : 0;
            sb.insert(0, tmp % 2 == 0 ? '0' : '1');
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    	
    }
    
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

}
