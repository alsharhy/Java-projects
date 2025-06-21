
public class Worker extends Employee implements Displayable {
    private String role;

    public Worker(int id, double salary, String name, int age,
                  String phoneNumber, String address, String role) {
        super(id, salary, name, age, phoneNumber, address);
        this.role = role;
    }

    public String getRole1() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.03;
    }

    @Override
    public String getRole() {
        return "Worker - " + role;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Worker Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Role: " + role);
        System.out.println("Salary: $" + getSalary());
    }
}

