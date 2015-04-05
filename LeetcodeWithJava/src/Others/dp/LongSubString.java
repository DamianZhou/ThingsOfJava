package Others.dp;

/**
 *	最大连续乘积子串 
 * 
 * @author DamianZhou
 * @see https://github.com/DamianZhou/The-Art-Of-Programming-By-July/blob/master/ebook/zh/05.01.md
 */
public class LongSubString {
	
	private static double getNums(double[] num){
		double tmax=num[0];
		double tmin=num[0];
		
		int len = num.length;
		double result = num[0];
		
		for(int i=1;i<len;i++){
			System.out.println("tmax="+tmax+"    tmin="+tmin+"   result="+result);
			tmax = Math.max( Math.max(tmax*num[i], tmin*num[i]), num[i]);
			tmin = Math.min( Math.min(tmin*num[i], tmax*num[i]), num[i]);		//存在负数，需要考虑负数的转变
			result = Math.max(tmax, result);
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		double[] num = {-2.5,4,0,3,0.5,8,-1};
		
		System.out.println(getNums(num));
		
	}

}
