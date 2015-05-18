package com.common;
/**
 * 输入全是 小写字母 a-z
 * @author DamianZhou
 * @see https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class TrieTree {
	private TrieNode root;

	public TrieTree() {
		root = new TrieNode('#'); 	//使用 # 开头
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		char[] charlist = word.toCharArray();
		TrieNode temp = root;
		int index = -1;
		for(int i=0;i<charlist.length;i++){
			index = charlist[i] - 'a' ;

			if(temp.node[index] == null){
				temp.node[index] = new TrieNode(charlist[i]);
			}
			temp = temp.node[index];
		}
		temp.isEnd=true; //设置最后一个字符为单词结束
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		char[] charlist = word.toCharArray();
		TrieNode temp = root;
		int index = -1;
		for(int i=0;i<charlist.length;i++){
			index = charlist[i] - 'a' ;
			if(temp.node[index] == null) 
				return false;
			temp=temp.node[index];
		}
		if(temp.isEnd)
			return true;
		else
			return false;
	}

	// Returns if there is any word in the trie that starts with the given prefix.
	public boolean startsWith(String prefix) {
		char[] charlist = prefix.toCharArray();
		TrieNode temp = root;
		int index = -1;
		for(int i=0;i<charlist.length;i++){
			index = charlist[i] - 'a' ;
			if(temp.node[index] == null) 
				return false;
			temp=temp.node[index];
		}
		return true;
	}


	class TrieNode {
		// Initialize your data structure here.

		char val; 				// 记录该位置的字符
		boolean isEnd; 	//	判断是否是单词的结尾
		TrieNode[] node;

		public TrieNode(char val) {
			this.val=val;
			this.isEnd=false;
			this.node=new TrieNode[26];
		}
	}
}


