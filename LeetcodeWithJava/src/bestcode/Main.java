package bestcode;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double x1,x2,y1,y2;

		while(input.hasNextDouble()){ 
			x1 = input.nextDouble();
			y1 = input.nextDouble();
			x2 = input.nextDouble();
			y2 = input.nextDouble();

			double result = Math.sqrt( (y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));

			//			System.out.println( result );
			System.out.println( String.format("%.2f", result) );

		}//while
		
	}
}
