package hiho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author DamianZhou
 * @see http://hihocoder.com/problemset/problem/1015
 */
public class P1015_KMP_String {

	public static void main(String[] args) {
		int n;
		String[] checks;
		String[] strs ;
		
		File file = new File("/Users/DamianZhou/Documents/Documents/hiho/1015");
		BufferedReader  reader =  null;
		try{
			reader =  new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			n=Integer.valueOf(line);
			checks=new String[n];
			strs=new String[n];
			
//			while( (line=reader.readLine())!=null){		}
			for(int i=0;i<n;i++){
				line = reader.readLine();
				checks[i]=line;
				line= reader.readLine();
				checks[i]=line;
			}
			
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		//-------------
		

	}

}
