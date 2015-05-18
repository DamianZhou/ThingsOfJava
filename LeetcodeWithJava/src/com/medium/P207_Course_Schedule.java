package com.medium;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/course-schedule/
 */
public class P207_Course_Schedule {

	/**
	 * 2015/05/07 形成单链表，判断是否有环
	 * @param numCourses
	 * @param prerequisites k*2 的数组，表示课程的依赖关系
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		HashSet<Integer> fromSet = new HashSet<Integer>();
		for(int i=0;i<numCourses;i++){
			fromSet.add(i);
		}
		
		int len = prerequisites.length;
		int from,to;
		
		for(int i=0;i<len;i++){
			from=prerequisites[i][0];
			to=prerequisites[i][1];
			
			if(from==to) continue;
			
			
		}
		
		
		return false;


	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
