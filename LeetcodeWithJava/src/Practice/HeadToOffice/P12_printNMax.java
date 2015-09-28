package Practice.HeadToOffice;

public class P12_printNMax {

	/**
	 * n为位数，打印出所有的1~9999..99(n位)
	 * @param n
	 */
	private void printNMax(int n){
		subPrintNMax(n, "");
	}

	private void subPrintNMax(int n , String preFix){
		if(n<1)
			return;
		else if(n==1){
			for(int i=0;i<10;i++){
				if(i==0 && preFix.length()==0) 		//个位数的 0 不输出
					continue;
				System.out.println(preFix+i);
			}
		}else{
			for (int i = 0; i < 10; i++) {
				if(i==0 && preFix.length()==0)
					subPrintNMax(n-1, "");
				else
					subPrintNMax(n-1, preFix+i);
			}
		}
	}

	public static void main(String[] args) {
		P12_printNMax test = new P12_printNMax();
		test.printNMax(1);

	}

}
