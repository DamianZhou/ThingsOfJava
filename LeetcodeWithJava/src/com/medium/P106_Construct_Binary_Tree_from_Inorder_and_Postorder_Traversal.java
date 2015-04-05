package com.medium;

import com.common.CommonComponents;
import com.common.CommonComponents.TreeNode;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class P106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length==0)
			return null;
		return getTree(inorder, postorder, 0,inorder.length-1, 0, postorder.length-1);

	}

	/**
	 * 退出条件：起始位置=结束位置（唯一元素）&& 左边的元素或者右边的元素为空
	 * @param inorder
	 * @param postorder
	 * @param is 中序起始
	 * @param ie 中序结束
	 * @param ps 后续起始
	 * @param pe 后续结束
	 * @return
	 */
	public static TreeNode getTree(int[] inorder,int[] postorder,int is,int ie,int ps,int pe){
//		    	System.out.println(is+","+ie+","+ps+","+pe);
//		if(is==ie) return new TreeNode(postorder[pe]); //添加下面的长度判断以后，不再需要该判断
		int val = postorder[pe];
		TreeNode root = new TreeNode(val);
		int i=-1;
		for(i=is;i<=ie;i++){
			if(inorder[i]==val)
				break;
		}
		int leftlen=i-is;
		int rightlen = ie-i;
//		    	System.out.println("i="+i+"---leftlen="+leftlen+"---rightlen:"+rightlen);
		
		if(leftlen>0)
			root.left = getTree(inorder, postorder, is, is+leftlen-1, ps, ps+leftlen-1);
		else
			root.left=null;
	
		if(rightlen>0)
			root.right = getTree(inorder, postorder, i+1, ie, pe-rightlen, pe-1);
		else
			root.right=null;
		return root;

	}

	public static void main(String[] args) {
		int[] in ={2,1};
		int[] post = {2,1};
		TreeNode root = getTree(in, post, 0, 1, 0, 1);

		//		int[] in = {-4,-10,3,-1,7,11,-8,2};
//		int[] post= {-4,-1,3,-10,11,-8,2,7};
//		TreeNode root = getTree(in, post, 0, 7, 0, 7);

		CommonComponents.printTree(root);

	}

}
