package bestcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Qihu360_t1 {

	public static char[][][] getBigNum(){
		char[][][] nums = new char[10][5][3];

		nums[0][0][0] = ' ';
		nums[0][0][1] = '-';
		nums[0][0][2] = ' ';
		nums[0][1][0] = '|';
		nums[0][1][1] = ' ';
		nums[0][1][2] = '|';
		nums[0][2][0] = ' ';
		nums[0][2][1] = ' ';
		nums[0][2][2] = ' ';
		nums[0][3][0] = '|';
		nums[0][3][1] = ' ';
		nums[0][3][2] = '|';
		nums[0][4][0] = ' ';
		nums[0][4][1] = '-';
		nums[0][4][2] = ' ';

		nums[1][0][0] = ' ';
		nums[1][0][1] = ' ';
		nums[1][0][2] = ' ';
		nums[1][1][0] = ' ';
		nums[1][1][1] = ' ';
		nums[1][1][2] = '|';
		nums[1][2][0] = ' ';
		nums[1][2][1] = ' ';
		nums[1][2][2] = ' ';
		nums[1][3][0] = ' ';
		nums[1][3][1] = ' ';
		nums[1][3][2] = '|';
		nums[1][4][0] = ' ';
		nums[1][4][1] = ' ';
		nums[1][4][2] = ' ';

		nums[2][0][0] = ' ';
		nums[2][0][1] = '-';
		nums[2][0][2] = ' ';
		nums[2][1][0] = ' ';
		nums[2][1][1] = ' ';
		nums[2][1][2] = '|';
		nums[2][2][0] = ' ';
		nums[2][2][1] = '-';
		nums[2][2][2] = ' ';
		nums[2][3][0] = '|';
		nums[2][3][1] = ' ';
		nums[2][3][2] = ' ';
		nums[2][4][0] = ' ';
		nums[2][4][1] = '-';
		nums[2][4][2] = ' ';

		nums[3][0][0] = ' ';
		nums[3][0][1] = '-';
		nums[3][0][2] = ' ';
		nums[3][1][0] = ' ';
		nums[3][1][1] = ' ';
		nums[3][1][2] = '|';
		nums[3][2][0] = ' ';
		nums[3][2][1] = '-';
		nums[3][2][2] = ' ';
		nums[3][3][0] = ' ';
		nums[3][3][1] = ' ';
		nums[3][3][2] = '|';
		nums[3][4][0] = ' ';
		nums[3][4][1] = '-';
		nums[3][4][2] = ' ';

		nums[4][0][0] = ' ';
		nums[4][0][1] = ' ';
		nums[4][0][2] = ' ';
		nums[4][1][0] = '|';
		nums[4][1][1] = ' ';
		nums[4][1][2] = '|';
		nums[4][2][0] = ' ';
		nums[4][2][1] = '-';
		nums[4][2][2] = ' ';
		nums[4][3][0] = ' ';
		nums[4][3][1] = ' ';
		nums[4][3][2] = '|';
		nums[4][4][0] = ' ';
		nums[4][4][1] = ' ';
		nums[4][4][2] = ' ';


		nums[5][0][0] = ' ';
		nums[5][0][1] = '-';
		nums[5][0][2] = ' ';
		nums[5][1][0] = '|';
		nums[5][1][1] = ' ';
		nums[5][1][2] = ' ';
		nums[5][2][0] = ' ';
		nums[5][2][1] = '-';
		nums[5][2][2] = ' ';
		nums[5][3][0] = ' ';
		nums[5][3][1] = ' ';
		nums[5][3][2] = '|';
		nums[5][4][0] = ' ';
		nums[5][4][1] = '-';
		nums[5][4][2] = ' ';

		nums[6][0][0] = ' ';
		nums[6][0][1] = '-';
		nums[6][0][2] = ' ';
		nums[6][1][0] = '|';
		nums[6][1][1] = ' ';
		nums[6][1][2] = ' ';
		nums[6][2][0] = ' ';
		nums[6][2][1] = '-';
		nums[6][2][2] = ' ';
		nums[6][3][0] = '|';
		nums[6][3][1] = ' ';
		nums[6][3][2] = '|';
		nums[6][4][0] = ' ';
		nums[6][4][1] = '-';
		nums[6][4][2] = ' ';

		nums[7][0][0] = ' ';
		nums[7][0][1] = '-';
		nums[7][0][2] = ' ';
		nums[7][1][0] = ' ';
		nums[7][1][1] = ' ';
		nums[7][1][2] = '|';
		nums[7][2][0] = ' ';
		nums[7][2][1] = ' ';
		nums[7][2][2] = ' ';
		nums[7][3][0] = ' ';
		nums[7][3][1] = ' ';
		nums[7][3][2] = '|';
		nums[7][4][0] = ' ';
		nums[7][4][1] = ' ';
		nums[7][4][2] = ' ';

		nums[8][0][0] = ' ';
		nums[8][0][1] = '-';
		nums[8][0][2] = ' ';
		nums[8][1][0] = '|';
		nums[8][1][1] = ' ';
		nums[8][1][2] = '|';
		nums[8][2][0] = ' ';
		nums[8][2][1] = '-';
		nums[8][2][2] = ' ';
		nums[8][3][0] = '|';
		nums[8][3][1] = ' ';
		nums[8][3][2] = '|';
		nums[8][4][0] = ' ';
		nums[8][4][1] = '-';
		nums[8][4][2] = ' ';

		nums[9][0][0] = ' ';
		nums[9][0][1] = '-';
		nums[9][0][2] = ' ';
		nums[9][1][0] = '|';
		nums[9][1][1] = ' ';
		nums[9][1][2] = '|';
		nums[9][2][0] = ' ';
		nums[9][2][1] = '-';
		nums[9][2][2] = ' ';
		nums[9][3][0] = ' ';
		nums[9][3][1] = ' ';
		nums[9][3][2] = '|';
		nums[9][4][0] = ' ';
		nums[9][4][1] = '-';
		nums[9][4][2] = ' ';


		return nums;
	}

	public static void addBigNum(char[][] result, char[][][] nums , int start ,int target){
		if(start!=0){
			for(int i=0;i<5;i++){
				if(i==2)
					result[i][start]='*';
				else
					result[i][start]=' ';
				result[i][start+1]=nums[target][i][0];
				result[i][start+2]=nums[target][i][1];
				result[i][start+3]=nums[target][i][2];
			}
		}else{
			for(int i=0;i<5;i++){
				result[i][start]=nums[target][i][0];
				result[i][start+1]=nums[target][i][1];
				result[i][start+2]=nums[target][i][2];
			}
		}

	}
	public static void decPrime(int n){
		//返回质因数数组  
		List<Integer> list = new ArrayList<Integer>();  
		for (int i=2;i <= n;i++){  
			while(n != i){  
				if(n%i != 0){  
					break;
				}  
				list.add(Integer.valueOf(i));  
				n = n/i;  
			}  
		}  
		list.add(Integer.valueOf(n));  

		System.out.println( Arrays.toString(list.toArray()) );

		char[][][] test = getBigNum();

		int len = list.size();
		if(len==0)
			return ;
		else if(len==1){
			int num = list.get(0);
			for(int i=0;i<test[num].length;i++){
				for(int j=0;j<test[num][0].length;j++)
					System.out.print(test[num][i][j]);
				System.out.println();
			}
		}else{

			int width = 3*len+len-1;
			char[][] result = new char[5][width];
			int start = 0;
			for(int i=0;i<list.size();i++){
				addBigNum(result, test, start, list.get(i));
				if(start==0)
					start+=3;
				else
					start+=4;
			}

			for(int i=0;i<5;i++){
				for(int j=0;j<width;j++)
					System.out.print(result[i][j]);
				System.out.println();
			}

		}

	}

	public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				while( input.hasNextInt()){
					int n = input.nextInt();
					Qihu360_t1.decPrime(n);					
				}


	}

}
