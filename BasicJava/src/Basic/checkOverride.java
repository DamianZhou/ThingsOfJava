package Basic;

public class checkOverride {

	public int getSum(int a,int b){
		return a+b;
	}

	//添加 throws Exception 并不会涉及 重写
	//	public int getSum(int a,int b) throws Exception

	/**
	 * 不同的参数类型
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a,float b){
		return (int) (a+b);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
