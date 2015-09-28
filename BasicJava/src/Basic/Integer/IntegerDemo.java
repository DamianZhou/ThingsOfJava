package Basic.Integer;

public class IntegerDemo {
	
	void testFunctions(){
		
		int n=3;
		
		System.out.println( Integer.bitCount(n) ); // 二进制中 1  的个数
		
		System.out.println( Integer.highestOneBit(15) ); // 二进制中，最高位的 1 代表的值
		
		
//		System.out.println(  );
	}
	
	
	void check_basic_Binary(){
		System.out.println( Integer.toBinaryString( Integer.MAX_VALUE ) );  // 01111111111111111111111111111111
		System.out.println( Integer.toBinaryString( 3 ) ); 									// 00000000000000000000000000000011
		System.out.println( Integer.toBinaryString( -3 ) );									// 11111111111111111111111111111101   补码的形式
	}

	public static void main(String[] args) {
		IntegerDemo test = new IntegerDemo();
		
//		test.testFunctions();
		test.check_basic_Binary();

	}

}
