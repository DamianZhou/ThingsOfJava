package bestcode;
import java.io.*;
import java.util.*;
import java.math.BigInteger; 

public class Baidu_4 {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n;
		while(in.hasNextInt())
		{
			BigInteger result = new BigInteger("1");
			n = in.nextInt();
			for(int i=0;i<n;i++){
				result.add(getResult(0,n));
			}
			System.out.println(result);
		}

	}
	public static BigInteger getResult(int m,int n){
		BigInteger result = new BigInteger("1");
		if(m<=n){
			int tmp=n-2;
			result=getCvalue(m,n);
			while(tmp>=m){
				result.subtract(getCvalue(m-1,tmp));
				tmp--;
			}

		}else{
			return new BigInteger("0"); 
		}
		return result;
	}

	public static BigInteger getCvalue(int m,int n){
		BigInteger result = new BigInteger("1");
		if(m==0||m==n) return result;
		for(int t=n;t>n-m;t--){
			result= result.multiply(new BigInteger(t+""));
		}
		BigInteger divide = new BigInteger("1");
		for(int t=m;t>0;t--){
			divide= divide.multiply(new BigInteger(t+""));
		}
		result=result.divide(divide);
		return result;
	}
}