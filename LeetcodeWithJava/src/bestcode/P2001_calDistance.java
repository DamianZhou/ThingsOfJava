package bestcode;

import java.util.Scanner;

/**
 * 测试
 * 实际运行，把类名换为 Main , 并带上import
 * 考试须知 http://oj.acmcoder.com/ExamNotice.html
 * @author Damian
 * @see http://acm.acmcoder.com/showproblem.php?pid=2001
 */
public class P2001_calDistance {
	
	/**
	 * 可以作为静态方法使用
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static double getDistance(double x1,double y1,double x2,double y2){
		return Math.sqrt( (y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double x1,x2,y1,y2;
		
		while(input.hasNextDouble()){ 			//此处 hasNext 最好指明具体类型
			x1 = input.nextDouble();
			y1 = input.nextDouble();
			x2 = input.nextDouble();
			y2 = input.nextDouble();
			
			double result = P2001_calDistance.getDistance(x1, y1, x2, y2);
			
//			System.out.println( result );
			System.out.println( String.format("%.2f", result) );
			
		}
	}

}
