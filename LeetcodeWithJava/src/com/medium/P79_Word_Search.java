package com.medium;

/**
 * 给定一个二维字符数组 和 一个单词，判断单词是否在数组中存在。
 * 
 * 贪吃蛇的形式在数组中取值
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/word-search/
 */
public class P79_Word_Search {
	public static boolean exist1(char[][] board, String word) {
		return false;

	}

	//-------------------------------
	/**
	 * 从二维字符数组中，每一个字母开始寻找
	 * 查看是否有从该位置开始的匹配
	 * @param board
	 * @param word
	 * @return
	 * @see https://leetcode.com/discuss/23165/accepted-very-short-java-solution-no-additional-space
	 */
	public static boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();

		for (int y=0; y<board.length; y++) {
			for (int x=0; x<board[y].length; x++) {
				if (exist(board, y, x, w, 0)) 
					return true;
			}
		}
		return false;
	}

	/**
	 * 重载
	 * @param board
	 * @param 行 y
	 * @param 列 x
	 * @param 单词 word
	 * @param word中当前匹配的字符下标 i
	 * @return
	 */
	private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) 
			return true;

		if (y<0 || x<0 || y == board.length || x == board[y].length) //到达边界
			return false;

		if (board[y][x] != word[i]) //字母不同
			return false;

		//如果当前字母相同
		board[y][x] ^= 256;	//-----------切换是否已读的状态

		boolean exist =  exist(board, y, x+1, word, i+1)
				|| exist(board, y, x-1, word, i+1)
				|| exist(board, y+1, x, word, i+1)
				|| exist(board, y-1, x, word, i+1);

		board[y][x] ^= 256;	//恢复成未读状态
		return exist;
	}
	//-------------------------------

	public static void main(String[] args) {
		char[][] board={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};

		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";

		if(exist(board, word1))
			System.out.println(word1);


		System.out.println("----1---"+board[0][0]);

		board[0][0]^=256;

		System.out.println("----2---"+board[0][0]);

		board[0][0]^=256;

		System.out.println("----3---"+board[0][0]);		
	}

}
