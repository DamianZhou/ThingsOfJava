package Basic;

public class VirtualDemo {

    public static void main(String[] args) {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
        
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        s.salaryCheck();
        
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
        //e.salaryCheck();  使用父类定义的变量，无法调用子类的新方法

    }

}
