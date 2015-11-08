package newcode.Programers;
/**
 * 
 * @author DamianZhou
 * @see http://www.nowcoder.com/practice/c0503ca0a12d4256af33fce2712d7b24
 */
public class CoinsSplit {
    public int countWays(int n) {
    	if(n<0)
    		return 0;
    	else if(n<5)
    		return 1;
    	else
    		return countWays(n-25)+countWays(n-10)+countWays(n-5);
    }
    
	public static void main(String[] args) {
		CoinsSplit test = new CoinsSplit();
		int result = test.countWays(6);
		System.out.println(result);
	}

}
