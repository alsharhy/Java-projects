
public class Appointment implements Displayable {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + date);
    }
}

