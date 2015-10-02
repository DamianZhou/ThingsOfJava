package com.medium;
/**
 * Baidu Intern Test
 * @author Damian
 * @see https://leetcode.com/problems/decode-ways/
 */
public class P091_Decode_Ways {
	
	
	/**
	 * 动态规划 找出递推关系
	 * @param s
	 * @return
	 */
    public int numDecodings_ref(String s) {
        int n = s.length();
        if (n == 0) 
        	return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') 		// '0' 不能单独存在
            	continue;
            else 									//对于下一个数，若和当前的数能组成10~26之间的值，就有两种添加方式：单独取memo[i+1] 、取两个memo[i+2]
            	memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
    
    /**
     * @param s
     * @return
     * @see https://leetcode.com/discuss/49719/dp-with-easy-understand-java-solution
     */
    public int numDecodings_ref2(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0') 
        	return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= s.length() ;i++){
            int num = Integer.parseInt(s.substring(i-2,i));
            int twoStepsBehind = (num <= 26 && num >= 10) ? dp[i-2] : 0;
            int oneStepBehind = (Integer.parseInt(s.substring(i-1,i)) != 0) ? dp[i-1] : 0;
            dp[i] = twoStepsBehind + oneStepBehind; // can reach here by either hopping 2 steps or 1 step
        }

        return dp[s.length()];
    }

	/**
	 * 需要注意 0 的影响
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		//check whether s is valid
		int len = s.length();
		if(len == 0)
			return 0;


		return subNumDecodings(s, 0, 0);
	}
	
	public int subNumDecodings(String s, int start , int count) {
		
		int pos = start;
		
		//首先跳过前面的0
		while(s.charAt(pos)=='0')
			pos++;
		if(pos>=s.length())
			return 0;
		
		// todo
		
		return 0;
	}
	
	/**
	 * 
	 * @param s
	 * @param start
	 * @param count
	 * @return
	 */
	public int subNumDecodings_TLE(String s, int start , int count) {
		
		if(start > s.length()-1) 
			return count;
		else if(start+1 == s.length()){
			if(count==0 && s.charAt(start)!='0')
				return 1;
			else
				return count;
		}
		//--------------------------------
		char ch = s.charAt(start);
		if( ch == '0' )
			return subNumDecodings(s, start+1, count);		
		
		count = (count==0)?1:count; //遇到第一个非0值，count置1	
		
		if(ch >='3' && ch <='9')
			return subNumDecodings(s, start+1, count);	
		else if(ch == '1'){
			char next = s.charAt(start+1);
			if(next=='0')
				return subNumDecodings(s, start+2, count);
			else
				return subNumDecodings(s, start+1, count) + subNumDecodings(s, start+2, count);	
		}else if(ch == '2'){
			char next = s.charAt(start+1);
			if(next=='0' || (next>='7' && next<='9'))
				return subNumDecodings(s, start+2, count);
			else
				return subNumDecodings(s, start+1, count) + subNumDecodings(s, start+2, count);				
		}
		return count; //应该不会执行到这
	}



	public static void main(String[] args) {
		P091_Decode_Ways test = new P091_Decode_Ways();
		int result = test.numDecodings("1");
		System.out.println(result);

		result = test.numDecodings("0");
		System.out.println(result);

		result = test.numDecodings("122");
		System.out.println(result);

		result = test.numDecodings("25");
		System.out.println(result);
	}

}
