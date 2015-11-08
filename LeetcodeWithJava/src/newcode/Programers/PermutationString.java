package newcode.Programers;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author DamianZhou
 * @see http://www.nowcoder.com/practice/8380c8cf28954a188362206b1991b5d6
 */
public class PermutationString {

    Comparator<String> strCompator = new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			String s1 = o1+o2;
			String s2 = o2+o1;
			return s2.compareTo(s1);
		}
	};
	
    public ArrayList<String> getPermutation(String A) {
        ArrayList<String> result = new ArrayList<String>();
        
        if(A.length()<1)
        	result.add(A);
        else{
        	subGetPermutation(result, 0, new StringBuilder(A));
        }
        
        result.sort(strCompator);
        return result;
    }
    
    void subGetPermutation(ArrayList<String> result,int start,StringBuilder stb){
    	if(start == stb.length()-1){
    		result.add(stb.toString());
    	}else{
    		subGetPermutation(result, start+1, stb);
    		
    		char ch = stb.charAt(start);
    		for(int i = start+1 ; i<stb.length() ; i++){
    			stb.setCharAt(start, stb.charAt(i));
    			stb.setCharAt(i, ch);
    			
    			subGetPermutation(result, start+1, stb);
    			
    			stb.setCharAt(i, stb.charAt(start));
    			stb.setCharAt(start, ch);
    		}
    	}
    }
    

	
	public static void main(String[] args) {
		PermutationString test = new PermutationString();
		String A = "ABC";
		
		ArrayList<String> t = test.getPermutation(A);
		
		for(String s:t){
			System.out.println(s);
		}
	}

}
