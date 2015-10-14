package bestcode;

public class amazon_1 {
	//METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int countHomes(int grid[][])
	{
		// INSERT YOUR CODE HERE
		int heigth = grid.length;
		int width = grid[0].length;
		Boolean[][] flag = new Boolean[heigth][width];

		for(int i=0;i<flag.length;i++)
			for(int j=0;j<flag[0].length;j++)
				flag[i][j]=false;

		int count = 0;

		int i=0;
		int j=0;

		while(i<heigth && j<width){
			count +=    subCountHomes(grid,flag,i,j);
			i++;
			j++;
		}

		return count;
	}

	public static int subCountHomes(int[][] grid,Boolean[][] flag,int start_m,int start_n){
		int count = 0;
		int m = start_m;
		int n = start_n;

		System.out.println("m="+m+"n="+n);

		//h
		for(int i = n;i<grid[0].length;i++){
			if(grid[m][i]==1){
				if(i-1>=0){
					if(flag[m][i-1]==true)
						flag[m][i]=true; //already added
				}
			}
		}

		//v
		for(int i = m;i<grid.length;i++){
			if(grid[i][n]==1){
				if(i-1>=0){
					if(flag[i-1][n]==true)
						flag[i][n]=true; //already added
				}
			}
		}

		//h
		for(int i = n;i<grid[0].length;i++){
			//			if(grid[m][i]==1){
			//				if(i-1>=0){
			//					if(flag[m][i-1]==false && grid[m][i-1]==1){
			//						flag[m][i-1]=true;
			//						flag[m][i]=true;
			//						count++;
			//					}
			//				}
			//			}
			if(grid[m][i]==1 && flag[m][i]==false){
				flag[m][i]=true;
				count++;
			}
		}
		//v
		for(int i = m;i<grid.length;i++){
			if(grid[i][n]==1 && flag[i][n]==false){
				flag[i][n]=true;
				count++;
			}
		}

		System.out.println("temp:"+count);

		return count;

	}

	public static void main(String[] args) {
		int[][] grid = {
				{0,0,0,0,0},
				{0,0,0,1,0},
				{0,0,0,1,0},
				{0,1,0,0,0},
				{0,0,0,0,0}
		};
		int result = amazon_1.countHomes(grid);
		System.out.println(result);
	}

}
