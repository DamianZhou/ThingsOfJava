#BasicJava的说明

## Package Basic 
###Employee 重载 `override`
方法的重载都是基于同一个类的。

在一个类中，多个`同名方法`满足一下条件，即实现了方法重载：
 1. 不同的参数个数
 2. 不同的参数类型
 3. 不同的参数顺序


###Salary 多态

在 Salary `继承(Extends)`自 Employee，并且`覆盖(Overload)`了父类的mailCheck()方法，且自定义了一个salaryCheck()方法。

在类 VituralDemo 中，分别用不用的变量来实例化Salary：
```java
		//public class Salary extends Employee
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
```

调用`s.mailCheck()`,实际调用的是Salary中定义的mailCheck();但是`e.mailCheck()`却调用的是父类Employee中的方法。

子类的方法`s.salaryCheck()`只有子类能调用，使用父类定义的变量e，无法调用子类的新方法。

>综上，java中的`多态`就体现在一个变量可以引用多个不同类(class)对象，前提是这类不同类必须有共同的父类，从而该变量可以且**只能调用每个不同对象之间的公共操作集（共有的父类中的方法）**。

>多态的实现是基于继承的。

