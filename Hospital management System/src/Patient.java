
public class Patient extends Person implements Displayable {
    private String medicalRecord;
    private String diseaseType;

    public Patient(String name, int age, String phoneNumber, String address,
                   String medicalRecord, String diseaseType) {
        super(name, age, phoneNumber, address);
        this.medicalRecord = medicalRecord;
        this.diseaseType = diseaseType;
    }

    public String getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(String medicalRecord) { this.medicalRecord = medicalRecord; }
    public String getDiseaseType() { return diseaseType; }
    public void setDiseaseType(String diseaseType) { this.diseaseType = diseaseType; }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Patient Details ===");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Medical Record: " + medicalRecord);
        System.out.println("Disease Type: " + diseaseType);
    }
}
