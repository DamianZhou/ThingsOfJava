package Basic;

public class Finally_return {

	/**
	 * finally 中修改变量: finally 执行，但是返回的是finally修改前的值
	 * @param n
	 * @return
	 */
	static int test1(int n){

		n++;
		try{
			return ++n; //计算出 新的n值，暂不返回，finally执行之后再返回该值
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("from finally:" +  ++n);
		}

		return 0;
	}

	/**
	 * finally 中修改变量，并且返回：finally 执行，返回的是finally修改后的值
	 * @param n
	 * @return
	 */
	static int test2(int n){

		n++;
		try{
			return ++n; 		//计算出 新的n值，暂不返回，finally中遇到新的return，返回新的值
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("from finally:" +  ++n);
			return ++n;
		}

		//		return 0;
	}
	public static void main(String[] args) {
		/*
				from finally:4
				from main:3
				----------------
				from finally:4
				from main:5		
		 */

		System.out.println("from main:" + test1(1));
		System.out.println("----------------");
		System.out.println("from main:" + test2(1));

	}

}
