import java.util.ArrayList;
import java.util.List;
public class HospitalManagement {
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Invoice> invoices = new ArrayList<>();
    public void addPatient(Patient p) { patients.add(p); }
    public void addDoctor(Doctor d) { doctors.add(d); }
    public void addNurse(Nurse n) { nurses.add(n); }
    public void addWorker(Worker w) { workers.add(w); }
    public void addAppointment(Appointment a) { appointments.add(a); }
    public void addInvoice(Invoice i) { invoices.add(i); }
    public boolean removePatient(String name) { return patients.removeIf(p ->
            p.getName().equals(name)); }
    public boolean removeDoctor(int id) { return doctors.removeIf(d -> d.getId() == id); }
    public boolean removeNurse(int id) { return nurses.removeIf(n -> n.getId() == id); }
    public boolean removeWorker(int id) { return workers.removeIf(w -> w.getId() == id); }
    public boolean removeAppointment(String pName, String dName, String date) {
        return appointments.removeIf(a -> a.getPatient().getName().equals(pName) &&
                a.getDoctor().getName().equals(dName) && a.getDate().equals(date));
    }
    public boolean removeInvoice(String pName) { return invoices.removeIf(i ->
            i.getPatient().getName().equals(pName)); }
    public void displayAllPatients() { patients.forEach(Patient::displayDetails); }
    public void displayAllDoctors() { doctors.forEach(Doctor::displayDetails); }
    public void displayAllNurses() { nurses.forEach(Nurse::displayDetails); }
    public void displayAllWorkers() { workers.forEach(Worker::displayDetails); }
    public void displayAllAppointments() { appointments.forEach(Appointment::displayDetails); }
    public void displayAllInvoices() { invoices.forEach(Invoice::displayDetails); }
    public ArrayList<Patient> getPatients() { return new ArrayList<>(patients); }
    public ArrayList<Doctor> getDoctors() { return new ArrayList<>(doctors); }
    public ArrayList<Nurse> getNurses() { return new ArrayList<>(nurses); }
    public ArrayList<Worker> getWorkers() { return new ArrayList<>(workers); }
    public ArrayList<Appointment> getAppointments() { return new ArrayList<>(appointments); }
    public ArrayList<Invoice> getInvoices() { return new ArrayList<>(invoices); }
}