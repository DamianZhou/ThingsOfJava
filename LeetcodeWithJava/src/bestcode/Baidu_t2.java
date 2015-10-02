package bestcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class Baidu_t2 {
	
	/**
	 * 字符 ch 对应的权重可以通过 indexlist[ch-'a'] 获取
	 * 每次更新，相当于剔除ch，剩余 n 个字符全排列的相对权重
	 * @param indexlist
	 * @param ch
	 */
	static void  subUpdateIndex(int[] indexlist , char ch){
		int pos = ch - 'a';
		indexlist[pos] = 0; //已经访问过，直接置零
 		while(++pos < indexlist.length){
			if(indexlist[pos]>0)
				indexlist[pos]--;
		}
		
		System.out.println(Arrays.toString(indexlist));
	}
	
	
	/**
	 * 给出一个字符串，仅由a~l组成，每个出现一次，求给出字符串的字典序大小
	 * 对于每一个字符s，若在其后有k个字符小于s，则当前的序列的排序会增大k*f[12-i]
	 * 其中f是每个数的阶乘，i为s的位置，因此只需模拟每一位进行比较即可。
	 */

	public static void main(String[] args) {
		
		int[] base = new int[13];
		base[12] = 0;
		base[11] = 1;
		for(int i = 10;i>0;i--)
			base[i] = (12-i)*base[i+1]; //当前第n个字符 决定  (n-1)! 的次序
		
		int index = 1;
		
		String str = "abcdefghijkl";
		
//		String str = "hgebkflacdji";
//		String str = "gfkedhjblcia";
//		StringBuilder str = new StringBuilder("hgebkflacdji");
		
		int[] indexlist = new int[12];
		for(int i = 0;i<12;i++)
			indexlist[i]=i;
		
		for(int i =0;i<str.length();i++){
			char ch = str.charAt(i);
			index = index + indexlist[ch-'a'] *base[i+1];			
			subUpdateIndex(indexlist,ch);
			System.out.println(index);
		}
	}

}
