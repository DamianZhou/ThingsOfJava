package bestcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Qunar_t3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		 input.nextLine();
		ArrayList<String> pidList = new ArrayList<String>();
		HashMap<String, String> holdMap = new HashMap<String, String>();
		HashMap<String, String> applyMap = new HashMap<String, String>();
		
		for(int i=0;i<n;i++){
			String line = input.nextLine();
			String[] data = line.split("\t");
			if(" ".equals(data[1]) || " ".equals(data[2])) //不占有，不请求，不会引发死锁
				continue;
		
			pidList.add(data[0]);
			
			if(!" ".equals(data[1])){
				String[] hold = data[1].split(",");
				for(String val : hold)
					holdMap.put(val, data[0]); // lockID , pid
			}
			
			if(!" ".equals(data[2])){
				String[] apply = data[2].split(",");
				for(String val : apply)
					holdMap.put(val, data[0]); // lockID , pid
			}
			
		}
		
		int result = 0;
		pidNode head = null;
		
		Qunar_t3 test = new Qunar_t3();
		
		for(String pid:pidList){
			pidNode node = test.new pidNode();
			if(head == null)
				head = node;

			
			
		}
			
		
		System.out.println(1);
		
	}
	
	class  pidNode{
		public String pid;
		public LinkedList<pidNode> apply;
		
		public pidNode(){
			this.pid="";
			this.apply=new LinkedList<Qunar_t3.pidNode>();
		}
		
		public pidNode(String pid) {
			this.pid = pid;
		}
	}
}
