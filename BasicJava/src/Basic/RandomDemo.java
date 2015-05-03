package Basic;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Random random =  new Random(100); //不管用
		
		
		int i=10;
		while(i-->0){
			System.out.println((int)(Math.random()*10000));
		}

	}

}
