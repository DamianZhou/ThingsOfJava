package newcode;


/**
 * 
 * @author Damian
 * @see http://www.nowcoder.com/discuss/338
 */
public class lesson1_ZRect {
	
	/**
	 * 之字形打印矩阵。斜着打印。
	 * @param rect
	 */
	void printZRect(int[][] rect){
		if( rect==null )
			return;
		subPrintZRect(rect, 0, 0, 0, 0, true);
	}
	
	/**
	 * 按照找斜线打印，并调整方向
	 * @param rect
	 * @param ll
	 * @param lr
	 * @param rl
	 * @param rr
	 * @param ditectionFlag
	 */
	void subPrintZRect(int[][] rect,int ll,int lr,int rl,int rr,boolean ditectionFlag){
		if(ll<rl || lr>rr)
			return;

		if(ditectionFlag){
			//从左向上打印
			int posl = ll;
			int posr = lr;
			while(posl>=rl && posr<=rr){
				System.out.print(","+rect[posl][posr]);
				posl--;
				posr++;
			}
		}else{
			//从右向下打印
			int posl = rl;
			int posr = rr;
			while(posl<=ll && posr>=lr){
				System.out.print(","+rect[posl][posr]);
				posl++;
				posr--;
			}
		}
		//更新下一个直线的位置
		if(ll<rect.length-1){
			ll++;
		}else
			lr++;
		
		if(rr<rect[0].length-1)
			rr++;
		else
			rl++;
		
		subPrintZRect(rect, ll, lr, rl, rr, !ditectionFlag);
	}
	

	public static void main(String[] args) {
		lesson1_ZRect test = new lesson1_ZRect();
		int[][] rect = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		
		test.printZRect(rect);

	}

}
