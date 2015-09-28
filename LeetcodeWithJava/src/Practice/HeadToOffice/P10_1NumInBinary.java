package Practice.HeadToOffice;

public class P10_1NumInBinary {
	
	/**
	 * 求二进制中的1的个数
	 * @param num
	 * @return
	 */
	private int count_1_in_binary(int num){
		
		int temp = num;
		int count = 0;
		while(temp != 0 ){
			temp = temp & (temp-1); //删除最后一个 1
			count++;
		}
		
		return count;
	}
	
	
	public static void main(String[] args) {
		P10_1NumInBinary test = new P10_1NumInBinary();
		
		System.out.println(test.count_1_in_binary(7));
		System.out.println(test.count_1_in_binary(Integer.MAX_VALUE));
		System.out.println(test.count_1_in_binary(Integer.MIN_VALUE));
	}

}
