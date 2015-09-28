package Practice.HeadToOffice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class P28_PrintAllString {

	/**
	 * 打印字符串的全排列
	 * @param str
	 */
	void printAllString(String str){
		if(str.length()==0)
			return;
		HashSet<Character> charset = new HashSet<Character>();
		int i=0;
		while(i<str.length()){
			charset.add( str.charAt(i)  );
			i++;
		}

		//		LinkedList<Character> list = new LinkedList<Character>(charset);
		//		subPrintString(new StringBuilder(""), list);

		subPrinStringWithSwap( charset.toArray(), 0);

	}
	/**
	 * 使用 LinkedList 实现全排列
	 * @param prefix
	 * @param list
	 */
	void subPrintString(StringBuilder prefix,LinkedList<Character> list){
		if(list.size()==0 && prefix.length()!=0)
			System.out.println( prefix );

		char ch ;
		for(int i=0;i<list.size();i++){
			ch = list.remove(i);
			prefix.append(ch);
			subPrintString(prefix, list);
			//恢复list，下一轮输出
			prefix.deleteCharAt(prefix.length()-1);
			list.add(i, ch);
		}

	}

	/**
	 * 使用 交换 的方式实现全排列
	 * @param objects
	 * @param pos
	 */
	void subPrinStringWithSwap(Object[] objects , int pos){
		if(pos==objects.length-1)
			System.out.println( Arrays.toString(objects) );
		else{
			int nextpos = pos+1;
			subPrinStringWithSwap(objects, pos+1);
			char temp;
			for(;nextpos<objects.length;nextpos++){
				temp = (char) objects[nextpos];
				objects[nextpos]=objects[pos];
				objects[pos]=temp;
				subPrinStringWithSwap(objects, pos+1);
				temp = (char) objects[nextpos];
				objects[nextpos]=objects[pos];
				objects[pos]=temp;			
			}
		}
	}


	public static void main(String[] args) {
		P28_PrintAllString test = new P28_PrintAllString();
		String str="abc";
		test.printAllString(str);
	}

}
