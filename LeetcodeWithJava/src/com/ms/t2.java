package com.ms;

import java.util.HashMap;
import java.util.HashSet;

public class t2 {

	public static void main(String[] args) {

		int N=3;
		int M=2;
		int[] model = new int[N];
		int[][] matrix = new int[N][];
		int[] temp={456,256};
		matrix[0]=temp;
		int[] temp1={666,111,256};
		matrix[1]=temp1;
		int[] temp2={90};
		matrix[2]=temp2;

		HashSet<Integer> set = new HashSet<Integer>();

		for(int i=0;i<N;i++){
			set.add(matrix[i][0]);
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<matrix.length;i++){
			for(int j=1;j<matrix[i].length;j++)
			{				
				if(set.contains(matrix[i][j])){
					if(map.containsKey(model[i]))
						map.put(model[i], map.get(model[i])+1);
					else
						map.put(model[i], 1);
				}
			}
		}

	}

}
