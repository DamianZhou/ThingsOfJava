package Practice.HeadToOffice;
/**
 * 
 * @author Damian
 * @see http://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P34_UglyNumber {
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	int getUglyNumber( int index ){
		if(index < 1 )
			return -1;
		int[] uglyNums = new int[index];
		uglyNums[0]=1;
		
		int uglyGBy2 = 0;
		int uglyGBy3 = 0;
		int uglyGBy5 = 0;
		
		int pos = 0 ;
		int min = uglyNums[0];
		
		while( pos < index-1){
			min = getMin( 2*uglyNums[uglyGBy2] , 3*uglyNums[uglyGBy3], 5*uglyNums[uglyGBy5]);
			uglyNums[++pos] = min;
			
			//确保三个因子对应的基数是当前最接近临界点的
			while( uglyGBy2 < pos && 2*uglyNums[uglyGBy2]<=uglyNums[pos]  )
				uglyGBy2++;
			while( uglyGBy3 < pos && 3*uglyNums[uglyGBy3]<=uglyNums[pos]  )
				uglyGBy3++;
			while( uglyGBy5 < pos && 5*uglyNums[uglyGBy5]<=uglyNums[pos]  )
				uglyGBy5++;
		}//while
		
		return uglyNums[index-1];
	}
	
	int getMin(int a,int b,int c){
		return Math.min(a, Math.min(b, c));
	}

	public static void main(String[] args) {
		
		P34_UglyNumber test = new P34_UglyNumber();
		int result = test.getUglyNumber(10);
		
		System.out.println( result );

	}

}
