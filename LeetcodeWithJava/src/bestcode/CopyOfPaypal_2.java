package bestcode;
import java.util.*;

public class CopyOfPaypal_2 {
	public static void main(String[] args){
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String str=cin.nextLine();
			String begin=cin.nextLine();
			String end=cin.nextLine();
			System.out.println(getSubSrtingNum(str,begin,end));
		}
	}

	private static int getSubSrtingNum(String str, String begin, String end) {
		HashSet<String> set=new HashSet<String>();
		int[] b=new int[str.length()];
		int[] e=new int[str.length()];

		for(int j=0;j<=e.length-1;j++){
			b[j]=-1;
			e[j]=-1;
		}
		int bi=0;
		int ei=0;
		int i=0;
		int step=0;
		while((step=str.substring(i,str.length()).indexOf(begin))>=0){
			b[bi]=i+step;
			i=i+step+1;
			bi++;
		}
		i=0;
		while((step=str.substring(i,str.length()).indexOf(end))>=0){
			e[ei]=i+step;
			i=i+step+1;
			ei++;
		}
//		for(int j=0;j<=e.length-1;j++){
//			System.out.println(e[j]);
//		}
		for(int j=0;j<b.length && b[j]!=-1;j++){
			for(int k=0;k<e.length && e[k]!=-1;k++){
				if(b[j]<=e[k]){
					set.add(str.substring(b[j],e[k]+end.length()));
				}
			}
		}
		return set.size();
	}
}