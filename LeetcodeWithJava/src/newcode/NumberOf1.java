package newcode;
/**
 * 
 * @author DamianZhou
 * @see http://www.nowcoder.com/books/coding-interviews/8ee967e43c2c4ec193b040ea7fbb10b8
 */
public class NumberOf1 {
    public static int getNumberOf1(int n) {
        int count = 0;
        int t=32;
        while(t>0){
            if((n&1)==1)
            		count++;
            n=n>>1;
            t--;
        }
        return count;
    }
    
    //---------------------------------------
    
    public static int getNumberOf1_ref(int n) {
    	int count = 0 ;
    	while(n!=0){
    		
    		System.out.println("n   = "+Integer.toBinaryString(n));
    		
    		count++;
    		 n = (n-1)&n; //去除最右的1
    	}
    	return count;
    }
    
    
	public static void main(String[] args) {
		int n=15;
		
		System.out.println(getNumberOf1_ref(n));
		System.out.println(getNumberOf1_ref(188));
		System.out.println(getNumberOf1_ref(-2));
	}

}
