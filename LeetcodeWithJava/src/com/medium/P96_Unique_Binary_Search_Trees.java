package com.medium;

/**
 * 
 * 给定n, 
 * 返回 n 可以组成的不同结构的二叉搜索树的数目
 * 
 * @author Damian
 * @see https://leetcode.com/problems/unique-binary-search-trees/
 */
public class P96_Unique_Binary_Search_Trees {
    public static int numTrees1(int n) {
        return 0;
    }
    
    //参考--------------------------------
    /**
     * G(n): the number of unique BST for a sequence of length n.
     * G(n) 只和 个数有关，与具体的数值无关
     * 
     * F(i, n), 1 <= i <= n: the number of unique BST, 
     * where the number i is the root of BST, and the sequence ranges from 1 to n.
     * 
     * G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
     * 
     * 任选一个数作为 顶点，左右两部分都可以计算。
     * F(i, n) = G(i-1) * G(n-i)   1 <= i <= n 
     * 
     * 综上，G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
     * 
     * @param n
     * @return
     * @see https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
     */
    public static int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];                
            }
            System.out.println("G["+i+"]="+G[i]);
        }

        return G[n];
    }
    
    
    
	public static void main(String[] args) {
		System.out.println(numTrees(4));
	}

}
