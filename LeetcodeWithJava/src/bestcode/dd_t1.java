package bestcode;

import java.util.Scanner;

public class dd_t1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line=input.nextLine();
		String[] nums=line.split(";");
		int len=0;
		for(int j=0;j<nums[0].length();j++){
			if(nums[0].charAt(j)!=' '){
				len++;
			}
		}
		int[][] a=new int[nums.length][len];
		for(int i=0;i<nums.length;i++){
			for(int j=0,k=0;j<nums[i].length()&&k<len;j++){
				if(nums[i].charAt(j)!=' '){
					a[i][k++]=nums[i].charAt(j)-'0';
				}
			}
		}
		int max=0,temp=0;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a[i].length-1;j++){
				temp=a[i][j]+a[i][j+1]+a[i+1][j]+a[i+1][j+1];
				if(max<temp){
					max=temp;
				}
			}
		}
		System.out.println(max);
	}

}
