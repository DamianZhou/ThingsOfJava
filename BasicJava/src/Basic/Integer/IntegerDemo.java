package Basic.Integer;

public class IntegerDemo {
	
	void testFunctions(){
		
		int n=3;
		
		System.out.println( Integer.bitCount(n) ); // 二进制中 1  的个数
		
		System.out.println( Integer.highestOneBit(15) ); // 二进制中，最高位的 1 代表的值
		
		
//		System.out.println(  );
	}

	public static void main(String[] args) {
		IntegerDemo test = new IntegerDemo();
		
		test.testFunctions();

	}

}
