package bestcode;
import java.util.ArrayList;
import java.util.Scanner;
public class dd_2_copy {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String[] values = str.split(" ");
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(String v : values)
			nums.add(Integer.parseInt(v));

		int begin = 0;
		int end = 0;
		int max = 0;
		for(int i=0;i<nums.size();i++){
			int sum = 0;
			//暴力遍历
			for(int j=i;j<nums.size();j++){
				sum = sum + nums.get(j);
				if(sum == 0){
					if(j-i+1>max){
						max = j-i+1;
						begin =i;
						end = j;
					}
				}//sum=0
			}//for
		}
		for(int i=begin;i<=end;i++){
			System.out.print(nums.get(i) + " ");
		}

	}

}
