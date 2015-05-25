package newcode;
/**
 * 二维数组查找
 * @author DamianZhou
 * @see http://www.nowcoder.com/books/coding-interviews/abc3fe2ce8e146608e868a70efebf62e
 */
public class Array_findNum {

	public boolean Find(int [][] array,int target) {

		if(array == null) return false;

		int m = array.length;
		if(m==0) return false; 	// array is {}

		int n = array[0].length;
		if(n==0) return false; // array is {{}}

		return subFind(array, target, 0, 0, m-1, n-1);
	}
	/**
	 * 在子矩阵中查找
	 * @param array
	 * @param target
	 * @param topm
	 * @param topn
	 * @param bottomm
	 * @param bottomn
	 * @return
	 */
	boolean subFind(int[][] array,int target,int topm,int topn,int bottomm,int bottomn){

		if(topm>bottomm || topn>bottomn)
			return false;

		if(array[topm][topn]>target || array[bottomm][bottomn]<target) 
			return false;

		int tm = (bottomm-topm)/2;
		int tn = (bottomn-topn)/2;

		if(array[topm+tm][topn+tn] == target)
			return true;
		else	if( array[topm+tm][topn+tn]  > target){
			return subFind(array, target, topm, topn, topm+tm, topn+tn);
		}else{
			return subFind(array, target, topm, topn+tn+1, topm+tm, bottomn) 
					||  subFind(array, target, topm+tm+1, topn, bottomm, topn+tn) 
					||  subFind(array, target, topm+tm+1, topn+tn+1, bottomm, bottomn);
		}
	}

	//---------------------------------------------------------------------

	/**
	 * 参考剑指offer
	 * 从右上角开始，进行剔除操作
	 * @param array
	 * @param target
	 * @return
	 */
	public boolean Find_ref(int [][] array,int target) {
		if(array==null || array[0].length==0) 
			return false;

		int startm=0;
		int startn=0;
		int endm=array.length-1;
		int endn=array[0].length-1;

		if(array[startm][startn]>target || array[endm][endn]<target) 
			return false;

		while(startm<=endm && startn<=endn){
			//    		System.out.println("("+startm+","+startn+")    ("+endm+","+endn+")");

			if(array[startm][endn] == target) //右上角的值
				return true;
			else if(array[startm][endn] > target){
				//剔除该列,向左前进
				endn--;
			}else{
				//剔除改行，向下前进
				startm++;
			}
		}
		return false;
	}



	public static void main(String[] args) {
		Array_findNum test = new Array_findNum();


		int[][] array =  {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

		System.out.println( test.Find_ref(array, 2));
		System.out.println( test.Find_ref(array, 3));
		System.out.println( test.Find_ref(array, 11));
		System.out.println( test.Find_ref(array, 16));

	}

}
