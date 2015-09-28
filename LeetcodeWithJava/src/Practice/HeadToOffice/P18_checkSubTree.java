package Practice.HeadToOffice;

import com.common.CommonComponents;
import com.common.TreeNode;

public class P18_checkSubTree {

	/**
	 * 判断 root2 是不是 root1 的子树
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean checkSubTree(TreeNode root1, TreeNode root2){
		if(root1==null || root2 == null)
			return false;
		
		boolean result = false;
		
		if(root1.val == root2.val){
			result = (  checkSameTree(root1.left, root2.left) && checkSameTree(root1.right, root2.right) ) ;
		}
		
		if(result)
			//如果查询到子树，则直接返回
			return result;
		else
			return (  checkSubTree(root1.left, root2) || checkSubTree(root1.right, root2) ) ;
	}
	
	/**
	 * 检验两个tree是是否完全相同
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean checkSameTree(TreeNode root1, TreeNode root2){
		if(root1==null && root2 == null)
			return true;
		else if(root1==null || root2 == null)
			return false;
		
		if(root1.val!=root2.val)
			return false;
		else{
			return (  checkSameTree(root1.left, root2.left) && checkSameTree(root1.right, root2.right) ) ;
		}
	}
	
	
	public static void main(String[] args) {
		P18_checkSubTree  test = new P18_checkSubTree();
		
		TreeNode root1 = CommonComponents.getTree();
		CommonComponents.printTree(root1);
		
//		TreeNode root2 = new TreeNode(2);
//		TreeNode c15 = new TreeNode(15);
//		TreeNode c7 = new TreeNode(7);
//		root2.left=c15;
//		root2.right=c7;
		
		TreeNode root2=null;
		
		System.out.println( test.checkSubTree(root1, root2) );
		
	}

}
