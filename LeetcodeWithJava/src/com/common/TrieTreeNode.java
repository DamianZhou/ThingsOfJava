package com.common;

public class TrieTreeNode {
	public int val;
	public TrieTreeNode[] data = new TrieTreeNode[26];
	
	public TrieTreeNode(){
		this.val=0;
	}
}
