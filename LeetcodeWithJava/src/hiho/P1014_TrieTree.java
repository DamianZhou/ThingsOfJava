package hiho;

import java.util.Scanner;

/**
 * 
 * @author DamianZhou
 * @see http://hihocoder.com/problemset/problem/1014
 */
public class P1014_TrieTree {
	
	/**
	 * 根据多个字符串构造字典树
	 * @param words
	 * @return
	 */
	public static TrieTreeNode getTrieTree(String[] words){
		TrieTreeNode root = new TrieTreeNode();
		TrieTreeNode tnode = root;
		char w;
		int len,i,j;
		int n = words.length;
		for(i=0;i<n;i++){
			len=words[i].length();
			for(j=0;j<len;j++){
				w=words[i].charAt(j);
				if(tnode.data[w-'a']==null)
					tnode.data[w-'a']=new TrieTreeNode();
				tnode=tnode.data[w-'a'];
				tnode.val+=1; //设置重叠个数
			}
			tnode=root;//another word
		}
		
		return root;
	}

	public static void main(String[] args) {
		int n = 0,i,m=0,j;
		Scanner in = new Scanner(System.in);
		if(in.hasNext())
			n=in.nextInt();
		String[] words = new String[n];
		for(i=0;i<n;i++){
			words[i] = new String(in.next());
		}
		m=in.nextInt();
		String[] tests= new String[m];
		for(i=0;i<m;i++){
			tests[i]=new String(in.next());
		}
		
		TrieTreeNode root = getTrieTree(words);//构造字典树
		TrieTreeNode tnode = root;
		int len;
		char w;
		int result=0;
		for(i=0;i<m;i++){
			len=tests[i].length();
			for(j=0;j<len;j++){
				w=tests[i].charAt(j);
				if(tnode.data[w-'a']!=null){
					tnode=tnode.data[w-'a'];
					result=tnode.val;
				}else{
					System.out.println(0);	//	没有该前缀
					break;
				}
			}
			if(j==len)
				System.out.println(result);	
			tnode=root;
		}
		

		
		

	}

}
/**
 * 字典树
 * @author DamianZhou
 *
 */
class TrieTreeNode {
	public int val;
	public TrieTreeNode[] data = new TrieTreeNode[26];
	
	public TrieTreeNode(){
		this.val=0;
	}
}