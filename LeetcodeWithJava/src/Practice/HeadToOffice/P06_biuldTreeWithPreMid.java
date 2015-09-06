package Practice.HeadToOffice;

import com.common.CommonComponents;
import com.common.TreeNode;

public class P06_biuldTreeWithPreMid {

	private TreeNode buildTreeWithPreMid(int[] preOrder, int[] midOrder){
		if(preOrder == null || midOrder == null || preOrder.length==0 || midOrder.length==0)
			return null;
		else
			return subBuildTree(preOrder, 0, preOrder.length-1, midOrder, 0, midOrder.length-1);
	}

	/**
	 * 构建子节点
	 * @param preOrder
	 * @param s1
	 * @param e1
	 * @param midOrder
	 * @param s2
	 * @param e2
	 * @return
	 */
	private TreeNode subBuildTree(int[] preOrder, int s1,int e1, int[] midOrder,int s2,int e2){
		if(e1<s1 || e2<s2)
			return null;
		else if(e1==s1)
			return new TreeNode(preOrder[s1]);
		else{
			int val = preOrder[s1];
			TreeNode temp = new TreeNode(val);

			int i=0;
			for(i=s2;i<=e2;i++){
				if(midOrder[i] == val)
					break;
			}

			int leftLen = i-s1;
			temp.right = subBuildTree(preOrder, s1+leftLen+1, e1, midOrder, s2+leftLen+1, e2);
			temp.left = subBuildTree(preOrder, s1+1, s1+leftLen, midOrder, s2, s2+leftLen-1);
			return temp;
		}

	}



	public static void main(String[] args) {

		P06_biuldTreeWithPreMid test = new P06_biuldTreeWithPreMid();

		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] midOrder = {4,7,2,1,5,3,8,6};

		TreeNode root = test.buildTreeWithPreMid(preOrder, midOrder);

		CommonComponents.printTree(root);

	}

}
