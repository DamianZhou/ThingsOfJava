package bestcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Sogou_cheat {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[][] matrix = new int[1000001][1000001];
		
		HashSet<Integer> cheatPersons = new HashSet<Integer>();
		
		while(N-- > 0){
			String line = in.nextLine();
			String[] nums = line.split(" ");
			
			int ask = Integer.parseInt(nums[0]);
			for(int i=1;i<nums.length;i++){
				int answer = Integer.parseInt(nums[i]);
				matrix[ask][answer] = 1;
				if(matrix[answer][ask] == 1){
					cheatPersons.add(ask);
					cheatPersons.add(answer);
				}
			}//for
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(cheatPersons);
		
		for(int i = 0;i<list.size();i++){
		}

	}

}
