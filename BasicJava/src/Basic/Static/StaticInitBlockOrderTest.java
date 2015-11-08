package Basic.Static;

class Parent{ 
	static String name = "P_hello"; 
	{ 
		System.out.println("#P# parent block"); 
	} 
	static { 
		System.out.println("#P# parent static block"); 
	} 
	public Parent(){ 
		System.out.println("#P# parent constructor"); 
		System.out.println(name);
	} 
} 

class Child extends Parent{ 
	static String name = "C_hello"; 
	{ 
		System.out.println("#C# child block"); 
	} 
	static { 
		System.out.println("#C# child static block"); 
		name = "childName in child static block";
	} 
	public Child(){ 
		System.out.println("#C# child constructor"); 
		System.out.println(name);
	} 
} 
/**
 * 
 * @author DamianZhou
 * @see http://www.cnblogs.com/panjun-Donet/archive/2010/08/10/1796209.html
 */
public class StaticInitBlockOrderTest{ 

	public static void main(String[] args) { 

		/*
		 	parent static block
			child static block
			parent block
			parent constructor
			child block
			child constructor
		 */
		new Child();
	} 
}
