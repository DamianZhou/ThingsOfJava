package com.medium;


/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class P331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	
	
	/**
	 * Ë¼Â·Ò»ÖÂ£¬\d## Ìæ»»
	 * @param preorder
	 * @return
	 * @see https://leetcode.com/discuss/83942/2-lines-java-using-regex
	 */
	public boolean isValidSerialization(String preorder) {
	    String s = preorder.replaceAll("\\d+,#,#", "#");
	    return s.equals("#") || !s.equals(preorder) && isValidSerialization(s);
	}
	

	public boolean isValidSerialization_notwork(String preorder) {

		String[] nodes = preorder.split(",");
		if(nodes.length<3 || nodes.length%2==0)
			return false;

		StringBuilder stb = new StringBuilder();
		for(String s : nodes)
			stb.append(s);

		//    	System.out.println(stb.toString());

		try{

			while(stb.indexOf("##") != -1){
				int startfind = 0;
				while(stb.indexOf("##",startfind) != -1){
					int pos = stb.indexOf("##",startfind);
					stb.replace(pos-1,pos+2,"#");
					startfind=pos;
				}
			}

			return stb.toString().equals("#");
		}catch(Exception e){
			return false;
		}
	}
	
	

	public static void main(String[] args) {
		P331_Verify_Preorder_Serialization_of_a_Binary_Tree test = new P331_Verify_Preorder_Serialization_of_a_Binary_Tree();
				String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//		String preorder = "1,#,#,#,#";
		boolean result =test.isValidSerialization(preorder);
		System.out.println(result);
	}

}
