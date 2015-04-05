package DataStructure;

/**
 * Java数组操作的demo
 * 
 * @author DamianZhou
 *
 */
public class TestArray {

	/**
	 * 初始化数组的demo.
	 * 
	 * Java语言中，由于把二维数组看作是数组的数组，数组空间不是连续分配的，
	 * 所以不要求二维数组每一维的大小相同。
	 */
	void initArrayDemo(){
		//静态
		int[] nums 			= 	{1,2,3,4,5,6,7};
		int intArray[ ][ ]	=	{{1,2},{2,3},{3,4,5}};

		//动态
		int[] list = new int[7];
		int[][] listArray=new int[2][3];
	}


	/**
	 * 二维矩阵相乘
	 */
	void MatrixMultiply(){
		int i,j,k;
		int a[][]=new int [2][3]; //动态初始化一个二维数组
		int b[][]={{1,5,2,8},{5,9,10,-3},{2,7,-5,-18}};//静态初始化一个二维数组
		int c[][]=new int[2][4]; //动态初始化一个二维数组
		
		for (i=0;i<2;i++)
			for (j=0; j<3 ;j++)
				a[i][j]=(i+1)*(j+2);
		
		for (i=0;i<2;i++){
			for (j=0;j<4;j++){
				c[i][j]=0;
				for(k=0;k<3;k++)
					c[i][j]+=a[i][k]*b[k][j];
			}
		}
		System.out.println("*******Matrix C********");//打印Matrix C标记
		for(i=0;i<2;i++){
			for (j=0;j<4;j++)
				System.out.println(c[i][j]+" ");
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
