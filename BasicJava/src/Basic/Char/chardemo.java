package Basic.Char;

public class chardemo {
	
	void testChar(){
		String greeting = "Hello";
		int n = greeting.length();
		
		int cpCount = greeting.codePointCount(0, n);
		
		System.out.println(n+" , "+cpCount);
	}
	
	public static void main(String[] args) {
		chardemo test = new chardemo();
		
		test.testChar();

	}

}
