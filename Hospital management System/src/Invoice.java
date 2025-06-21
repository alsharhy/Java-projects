
public class Invoice implements Displayable {
    private Patient patient;
    private double consultationFee;
    private double medicationFee;
    private static final double INSPECTION_FEE = 3000;

    public Invoice(Patient patient, double consultationFee, double medicationFee) {
        this.patient = patient;
        this.consultationFee = consultationFee;
        this.medicationFee = medicationFee;
    }

    public Patient getPatient() {
        return patient;
    }

    public double calculateTotal() {
        return consultationFee + medicationFee + INSPECTION_FEE;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Invoice Details ===");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Consultation Fee: $" + consultationFee);
        System.out.println("Medication Fee: $" + medicationFee);
        System.out.println("Inspection Fee: $" + INSPECTION_FEE);
        System.out.println("Total: $" + calculateTotal());
    }
}

