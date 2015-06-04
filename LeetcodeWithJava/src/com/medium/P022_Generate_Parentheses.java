package com.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Backtracking 回溯
 * @author DamianZhou
 * @see https://leetcode.com/problems/generate-parentheses/
 */
public class P022_Generate_Parentheses {

	/**
	 * 最原始的方法，替换String，使用HashSet保存结果
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis(int n) {
    	if(n<1) return null;
    	HashSet<String> oldset =  new HashSet<String>();
    	HashSet<String> newset = new HashSet<String>();
    	HashSet<String> temp;
    	StringBuilder str;
    	LinkedList<String> result = new LinkedList<String>();
    	
    	if(n==1) {
    		result.add("()");
    		return result;
    	}
    	Iterator<String> it;
    	newset.add("()");
    	while(n>1){
    		temp=oldset;
    		oldset=newset;
    		newset=temp;
    		
    		it = oldset.iterator();
    		while(it.hasNext()){
    			str=new StringBuilder(it.next());
    			int len = str.length();
    			for(int i=0;i<len;i++){
    				str.insert(i, "()");
    				newset.add(str.toString());
    				str.replace(i, i+2, "");
    			}
    		}
    		oldset.clear();
    		n--;
    	}
    	it = newset.iterator();
    	while(it.hasNext())
    		result.add(it.next());
		return result;
        
    }
    
    /**
     * 回溯的方式实现
     * @param n
     * @return
     * @see https://leetcode.com/discuss/25063/easy-to-understand-java-backtracking-solution
     */
    public static List<String> generateParenthesis_ref(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){
    	System.out.println("---open="+open+"   ---close="+close);//测试
        if(str.length() == max*2){
        	System.out.println(str);//测试
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
	public static void main(String[] args) {
		generateParenthesis_ref(3);
	}

}
