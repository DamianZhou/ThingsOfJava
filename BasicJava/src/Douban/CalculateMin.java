package Douban;

import java.util.Scanner;

public class CalculateMin {
	public static void main(String[] args) {

//		//让用户输入矩阵的行列数
//		System.out.println("请输入矩阵的行列数");
//		System.out.println("行数：");
//		Scanner scanner = new Scanner(System.in);
//		int row =  scanner.nextInt();
//		System.out.println("列数");
//		int col = scanner.nextInt();

		//构造矩阵
//		double[][] matrix = new double[row][col];
		
//		//让用户输入矩阵每个元素的值
//		System.out.println("请输入矩阵每个元素的值");
//		for(int i = 0; i < row; i++){
//			for(int j = 0; j < col; j++){
//				System.out.println(i + "," + j);
//				double ele = scanner.nextDouble();
//				matrix[i][j] = ele;
//			}
//		}

		int row=4;
		int col=5;
		double[][] matrix = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{15,14,13,12,11},
				{16,17,18,19,20}
		};
		//开始计算和的最小值元素
		int minEleRow1 = -1;
		int minEleCol1 = -1;
		int minEleRow2 = -1;
		int minEleCol2 = -1;
		double minSum = -1;

		for(int i1 = 0; i1 < row; i1++){
			for(int j1 = 0; j1 < col; j1++){
				double ele1 = matrix[i1][j1];

				for(int i2 = 0; i2 < row; i2++){
					for(int j2 = 0; j2 < col; j2++){
						//每行只能有一个数
						if(i1 == i2){
							continue;
						}
						//每列只能有一个数
						if(j1 == j2){
							continue;
						}

						double ele2 = matrix[i2][j2];

						double sum = ele1 + ele2;
						//如果是第一次计算，则直接给minSum赋值
						if(i1 == 0 && j1 == 0 && i2 == 1 && j2 == 1){
							minSum = sum;
							continue;
						}

						//如果sum小于当前的minSum，则更新minSum
						if(sum < minSum){
							minSum = sum;

							minEleRow1 = i1;
							minEleCol1 = j1;
							minEleRow2 = i2;
							minEleCol2 = j2;
						}

					}
				}
			}
		}

		System.out.println("矩阵中最小的和:" + minSum);
		System.out.println("这两个元素的坐标是：");
		System.out.println(minEleRow1 + "," + minEleCol1);
		System.out.println(minEleRow2 + "," + minEleCol2);
		System.out.println("执行完毕");

	}
}
