package newcode.Programers;


public class ReverseString {
	public void reverseCharArray(StringBuilder stb,int i,int j){
		char temp;  
		while(i<j){
			temp = stb.charAt(i);
			stb.setCharAt(i,stb.charAt(j));
			stb.setCharAt(j, temp);
			i++;
			j--;
		}
	}

	public String reverseString(String iniString) {
		if(iniString.length()<2)
			return iniString;
		StringBuilder stb = new StringBuilder(iniString);
		
		int i=0;
		int j=stb.length()-1;

		reverseCharArray(stb, i, j);
		i=0;
		j=0;
		while(j<stb.length()){
			if(stb.charAt(j)==' '){
				reverseCharArray(stb, i, j-1);
				i=j+1;
			}
			j++;
		}
		reverseCharArray(stb, i, j-1);
		return stb.toString();

	}
	public static void main(String[] args) {
		ReverseString test = new ReverseString();
		
		String str = "This  is  nowcoder";
		
		String result = test.reverseString(str);
		System.out.println(result);
		
		
		
	}

}
