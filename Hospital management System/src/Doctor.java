
public class Doctor extends Employee implements Displayable {
    private String specialization;

    public Doctor(int id, double salary, String name, int age,
                  String phoneNumber, String address, String specialization) {
        super(id, salary, name, age, phoneNumber, address);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.1;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Doctor Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialization: " + specialization);
        System.out.println("Salary: $" + getSalary());
    }
}


