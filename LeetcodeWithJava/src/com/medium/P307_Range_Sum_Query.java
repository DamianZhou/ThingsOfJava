package com.medium;
/**
 * 线段树 Segment Tree
 * @author DamianZhou
 * @see https://leetcode.com/problems/range-sum-query-mutable/
 */
public class P307_Range_Sum_Query {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,8,9};
		NumArray test = new NumArray(nums);
		
		System.out.println(test.sumRange(0, 8));

	}

}


class NumArray {
	/**
	 * 线段树
	 * @see https://leetcode.com/discuss/70202/17-ms-java-solution-with-segment-tree
	 */
	class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
	
    SegmentTreeNode root = null;

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;             
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }         
            return ret;
        }
    }
    
    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
           root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                 update(root.left, pos, val);
            } else {
                 update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {    
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
    
    public NumArray(int[] nums) {
    	root = buildTree(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
    	update(root, i, val);
    }

    public int sumRange(int i, int j) {
    	 return sumRange(root, i, j);
    }
}