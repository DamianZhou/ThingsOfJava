package com.hard;

import java.util.Arrays;
import java.util.HashMap;

import com.common.Point;

/**
 * 
 * @author DamianZhou
 * @see https://leetcode.com/problems/max-points-on-a-line/
 */
public class P149_Max_Points_on_a_Line {
	/**
	 * 针对每一个点，查看斜率
	 * 要考虑 
	 * 1、 重复的点(区别于 k=无穷大的点)
	 * 2.    Integer 保存斜率的准确性。使用 float可能导致末尾不准确，暂时保存4位
	 * @param points
	 * @return
	 * 
	 * 优化： 可以直接统计所有的斜率，不用每次都向前遍历求斜率
	 */
	public static int maxPoints(Point[] points) {
		
		if(points.length==0)
			return 0;
		
		int i=0,j=0;
		HashMap<Float, Integer> map = new HashMap<Float, Integer>(); //记录当前的斜率
		int max = 0;
		int realmax=0;
		int same = 0; //记录重复的数字
		for(;i<points.length;i++){
			for(j=0;j<points.length;j++){
				if(i==j)	continue;
				if(points[i].x==points[j].x && points[i].y==points[j].y ){
					same++;
					continue;
				}
				
				if(points[i].x==points[j].x){
					if(map.containsKey(Float.MAX_VALUE)){
						int t = map.get(Float.MAX_VALUE)+1;
						max=max>t?max:t;
						map.put(Float.MAX_VALUE, t);
					}else{
						max=max>1?max:1;
						map.put(Float.MAX_VALUE, 1);
					}
				}else{
					int temp = (points[j].y-points[i].y)*10000/(points[j].x-points[i].x);
					float k=(float) temp/10000;
//					System.out.println("i="+i+" j="+j+" k="+k);
					if(map.containsKey(k)){
						int t = map.get(k)+1;
						max=max>t?max:t;
						map.put(k, t);
					}else{
						max=max>1?max:1;
						map.put(k, 1);
					}
				}
			}//j
			if(realmax==0){
				realmax=max+same;
			}else{
				realmax=realmax>(max+same)?realmax:(max+same);
			}
//			System.out.println("-------------------realmax="+realmax);
			max=0;
			same=0;
			map.clear();
		}//i

		return realmax+1;
	}
	public static void main(String[] args) {
		// (0,0),(0,0)
		// (0,0),(0,0),(1,1)
		//(-4,-4),(-8,-582),(-3,3),(-9,-651),(9,591)
		//(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)
		Point p1 = new Point(84,250);
		Point p2 = new Point(0,0);
		Point p3 = new Point(1,0);
		Point p4 = new Point(0,-70);
		Point p5 = new Point(0,-70);
		Point p6 = new Point(1,-1);
		Point p7 = new Point(21,10);
		Point p8 = new Point(42,90);
		Point p9 = new Point(-42,-230);

		Point[] points = new Point[9];
		points[0]=p1;
		points[1]=p2;
		points[2]=p3;
		points[3]=p4;
		points[4]=p5;
		points[5]=p6;
		points[6]=p7;
		points[7]=p8;
		points[8]=p9;

		System.out.println(maxPoints(points));


	}

}
