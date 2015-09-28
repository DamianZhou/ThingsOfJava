package Practice.HeadToOffice;

import com.common.CommonComponents;
import com.common.TreeNode;
/**
 * 
 * @author Damian
 * @see http://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P39_DepthOfTree {
	
    public int TreeDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	int leftDepth = 1 + TreeDepth(root.left);
    	int rightDepth = 1 + TreeDepth(root.right);
    	return Math.max(leftDepth, rightDepth);
    }
    

	public static void main(String[] args) {
		P39_DepthOfTree test = new P39_DepthOfTree();
		
		TreeNode root = CommonComponents.getTree();
		
		System.out.println( test.TreeDepth(root) );
	}

}
