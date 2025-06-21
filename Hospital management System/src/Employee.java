
public abstract class Employee extends Person {
    private int id;
    private double salary;

    public Employee(int id, double salary, String name, int age, String phoneNumber, String address) {
        super(name, age, phoneNumber, address);
        this.id = id;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public abstract double calculateBonus();
}
