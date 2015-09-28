package Practice.HeadToOffice;

public class P32_NumberOfOne {

	/**
	 * 计算1~n的正整数中，1出现的次数
	 * @param n
	 * @return
	 */
	int numberOfOneBetween1AndN( int n){
		if(n<1)
			return 0;
		return  numberOfOne(Integer.toString(n), 0);
	}

	int powerBase10(int n){
		int result = 1;
		for(int i=0;i<n;i++){
			result *=10;
		}
		return result;
	}

	/**
	 * 从最高位开始，判断该数位上 1 的个数
	 * @param num
	 * @param start
	 * @return
	 */
	int numberOfOne(String num , int start){
		if(start > num.length()-1)
			return 0;
		int first = num.charAt(start) - '0';
		int len = num.length() - start;

		if(len==1 && first>0)
			return 1;

		//计算最高位的1的个数
		int numFirstDIgit  = 0;
		if(first>1)
			numFirstDIgit = powerBase10(len-1);
		else if(first==1)
			numFirstDIgit = Integer.parseInt( num.substring(start+1) ) +1 ;
		
		//计算最高位在位时，其余数位的1的个数
		int numOtherDigit = first*(len-1)*powerBase10(len-2);
		
		//计算余数中1的个数
		int numRecursive = numberOfOne(num, start+1);
		
		return numFirstDIgit+numOtherDigit+numRecursive;
	}


	public static void main(String[] args) {
		P32_NumberOfOne test = new P32_NumberOfOne();
		
		System.out.println( test.numberOfOneBetween1AndN(11) );
		System.out.println( test.numberOfOneBetween1AndN(10000) );
		
		System.out.println( "012345".substring(1) );

	}

}
