package com.medium;

import com.common.TrieTree;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class P208_Implement_Trie {
	
	public static void main(String[] args) {
		
//		P208_Implement_Trie test = new P208_Implement_Trie();
		
		TrieTree trie = new TrieTree();
		 trie.insert("somestring");
		 
		 String check = "somestring";
		 if(trie.search(check))
			 System.out.println(check+" is in the trie tree");
		 else
			 System.out.println(check+" is not in the trie tree");

		 check = "somestr";
		 if(trie.search(check))
			 System.out.println(check+" is in the trie tree");
		 else
			 System.out.println(check+" is not in the trie tree");
		 
		 check = "somest";
		 if(trie.search(check))
			 System.out.println(check+" is in the trie tree");
		 else
			 System.out.println(check+" is not in the trie tree");
		 
		 //------------------------------
		 
		 check = "somestt";
		 if(trie.startsWith(check))
			 System.out.println(check+" is a effrient prefix");
		 else
			 System.out.println(check+" is not a effrient prefix");
		 
		 check = "some";
		 if(trie.startsWith(check))
			 System.out.println(check+" is a effrient prefix");
		 else
			 System.out.println(check+" is not a effrient prefix");
	}

	}