package Basic.Assert;

public class AssertDemo {

	public static void main(String[] args) {
		int i = 0;
		for(i=0;i<5;i++)
		{
			System.out.println(i); 
		}
		//假设程序不小心多了一句--i; 
		--i;
		assert i==4;
		System.out.println(2/0); // java.lang.ArithmeticException: / by zero

	}

}
