package Basic;

/**
 * ���ص�ʵ��
 * @author Damian
 *
 */
public class Emplyee {
    private String name;
    private int salary;

    public Emplyee(String n ,int s){
        setName(n);
        setSalary(s);
    }

    public Emplyee(String n){
        /* ���κι��캯���У�������� this �ĵ��ã� �����ǵ�һ������ֻ����һ����*/
        this(n,0);
    }

    public Emplyee(){
        this("Unknown");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

}
