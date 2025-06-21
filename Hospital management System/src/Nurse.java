
public class Nurse extends Employee implements Displayable {
    private String department;

    public Nurse(int id, double salary, String name, int age,
                 String phoneNumber, String address, String department) {
        super(id, salary, name, age, phoneNumber, address);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.05;
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Nurse Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + getSalary());
    }
}

