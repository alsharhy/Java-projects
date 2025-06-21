import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagement hospital = new HospitalManagement();

        while(true) {
            System.out.println("\n==== نظام إدارة المستشفى ====");
            System.out.println("1. إدارة المرضى");
            System.out.println("2. إدارة الأطباء");
            System.out.println("3. إدارة الممرضين");
            System.out.println("4. إدارة العاملين");
            System.out.println("5. إدارة المواعيد");
            System.out.println("6. إدارة الفواتير");
            System.out.println("7. إنهاء البرنامج");
            System.out.print("اختر الخيار: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1: managePatients(hospital, scanner); break;
                case 2: manageDoctors(hospital, scanner); break;
                case 3: manageNurses(hospital, scanner); break;
                case 4: manageWorkers(hospital, scanner); break;
                case 5: manageAppointments(hospital, scanner); break;
                case 6: manageInvoices(hospital, scanner); break;
                case 7:
                    System.out.println("جارٍ إنهاء البرنامج...");
                    scanner.close();
                    System.exit(0);
                default: System.out.println("خيار غير صحيح!");
            }
        }
    }


    private static void managePatients(HospitalManagement h, Scanner s) {
        while(true) {
            System.out.println("\n==== إدارة المرضى ====");
            System.out.println("1. إضافة مريض جديد");
            System.out.println("2. عرض جميع المرضى");
            System.out.println("3. بحث مريض بالاسم");
            System.out.println("4. حذف مريض");
            System.out.println("5. الرجوع للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");

            int choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("\n--- إضافة مريض جديد ---");
                    System.out.print("اسم المريض: ");
                    String name = s.nextLine();

                    System.out.print("العمر: ");
                    int age = s.nextInt();
                    s.nextLine();

                    System.out.print("رقم الهاتف: ");
                    String phone = s.nextLine();

                    System.out.print("العنوان: ");
                    String addr = s.nextLine();

                    System.out.print("السجل الطبي: ");
                    String record = s.nextLine();

                    System.out.print("نوع المرض: ");
                    String disease = s.nextLine();

                    // التحقق من الحقول المطلوبة
                    if(name.isEmpty() || record.isEmpty()) {
                        System.out.println("!خطأ: الاسم والسجل الطبي حقول إجبارية");
                        continue;
                    }

                    h.addPatient(new Patient(name, age, phone, addr, record, disease));
                    System.out.println("\nتمت إضافة المريض بنجاح!");
                    break;

                case 2:
                    System.out.println("\n--- قائمة جميع المرضى ---");
                    if(h.getPatients().isEmpty()) {
                        System.out.println("لا يوجد مرضى مسجلين حالياً");
                    } else {
                        System.out.println("عدد المرضى: " + h.getPatients().size());
                        System.out.println("-----------------------------");
                        h.getPatients().forEach(patient -> {
                            patient.displayDetails();
                            System.out.println("-----------------------------");
                        });
                    }
                    break;

                case 3:
                    System.out.println("\n--- بحث عن مريض ---");
                    System.out.print("أدخل اسم المريض: ");
                    String searchName = s.nextLine();

                    List<Patient> results = h.getPatients().stream()
                            .filter(p -> p.getName().equalsIgnoreCase(searchName))
                            .collect(Collectors.toList());

                    if(results.isEmpty()) {
                        System.out.println("لا يوجد مريض بهذا الاسم");
                    } else {
                        System.out.println("تم العثور على " + results.size() + " مريض:");
                        results.forEach(Patient::displayDetails);
                    }
                    break;

                case 4:
                    System.out.println("\n--- حذف مريض ---");
                    System.out.print("أدخل اسم المريض للحذف: ");
                    String deleteName = s.nextLine();

                    boolean isRemoved = h.getPatients().removeIf(p ->
                            p.getName().equalsIgnoreCase(deleteName));

                    if(isRemoved) {
                        System.out.println("تم حذف المريض بنجاح");
                    } else {
                        System.out.println("لم يتم العثور على المريض");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("!خيار غير صحيح، الرجاء المحاولة مرة أخرى");
            }
        }
    }



    private static void manageDoctors(HospitalManagement h, Scanner s) {
        while(true) {
            System.out.println("\n==== إدارة الأطباء ====");
            System.out.println("1. إضافة طبيب جديد");
            System.out.println("2. عرض جميع الأطباء");
            System.out.println("3. بحث طبيب بالاسم");
            System.out.println("4. حذف طبيب");
            System.out.println("5. الرجوع للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");

            int choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("\n--- إضافة طبيب جديد ---");
                    System.out.print("رقم الطبيب: ");
                    int id = s.nextInt();

                    System.out.print("الراتب: ");
                    double salary = s.nextDouble();
                    s.nextLine();

                    System.out.print("اسم الطبيب: ");
                    String name = s.nextLine();

                    System.out.print("العمر: ");
                    int age = s.nextInt();
                    s.nextLine();

                    System.out.print("رقم الهاتف: ");
                    String phone = s.nextLine();

                    System.out.print("العنوان: ");
                    String addr = s.nextLine();

                    System.out.print("التخصص: ");
                    String spec = s.nextLine();

                    // التحقق من الحقول المطلوبة
                    if(name.isEmpty() || spec.isEmpty()) {
                        System.out.println("!خطأ: الاسم والتخصص حقول إجبارية");
                        continue;
                    }

                    h.addDoctor(new Doctor(id, salary, name, age, phone, addr, spec));
                    System.out.println("\nتمت إضافة الطبيب بنجاح!");
                    break;

                case 2:
                    System.out.println("\n--- قائمة جميع الأطباء ---");
                    if(h.getDoctors().isEmpty()) {
                        System.out.println("لا يوجد أطباء مسجلين حالياً");
                    } else {
                        System.out.println("عدد الأطباء: " + h.getDoctors().size());
                        System.out.println("-----------------------------");
                        h.getDoctors().forEach(doctor -> {
                            doctor.displayDetails();
                            System.out.println("-----------------------------");
                        });
                    }
                    break;

                case 3:
                    System.out.println("\n--- بحث عن طبيب ---");
                    System.out.print("أدخل اسم الطبيب: ");
                    String searchName = s.nextLine();

                    List<Doctor> results = h.getDoctors().stream()
                            .filter(d -> d.getName().equalsIgnoreCase(searchName))
                            .collect(Collectors.toList());

                    if(results.isEmpty()) {
                        System.out.println("لا يوجد طبيب بهذا الاسم");
                    } else {
                        System.out.println("تم العثور على " + results.size() + " طبيب:");
                        results.forEach(Doctor::displayDetails);
                    }
                    break;

                case 4:
                    System.out.println("\n--- حذف طبيب ---");
                    System.out.print("أدخل اسم الطبيب للحذف: ");
                    String deleteName = s.nextLine();

                    boolean isRemoved = h.getDoctors().removeIf(d ->
                            d.getName().equalsIgnoreCase(deleteName));

                    if(isRemoved) {
                        System.out.println("تم حذف الطبيب بنجاح");
                    } else {
                        System.out.println("لم يتم العثور على الطبيب");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("!خيار غير صحيح، الرجاء المحاولة مرة أخرى");
            }
        }
    }


    // دوال إدارة الممرضين
    private static void manageNurses(HospitalManagement h, Scanner s) {
        while(true) {
            System.out.println("\n==== إدارة الممرضين ====");
            System.out.println("1. إضافة ممرض جديد");
            System.out.println("2. عرض جميع الممرضين");
            System.out.println("3. بحث ممرض بالاسم");
            System.out.println("4. حذف ممرض");
            System.out.println("5. الرجوع للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");

            int choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("رقم الممرض: ");
                    int id = s.nextInt();
                    System.out.print("الراتب: ");
                    double salary = s.nextDouble();
                    s.nextLine();
                    System.out.print("الاسم: ");
                    String name = s.nextLine();
                    System.out.print("العمر: ");
                    int age = s.nextInt();
                    s.nextLine();
                    System.out.print("رقم الهاتف: ");
                    String phone = s.nextLine();
                    System.out.print("العنوان: ");
                    String addr = s.nextLine();
                    System.out.print("القسم: ");
                    String dept = s.nextLine();

                    h.addNurse(new Nurse(id, salary, name, age, phone, addr, dept));
                    System.out.println("تمت إضافة الممرض بنجاح!");
                    break;

                case 2:
                    System.out.println("\n==== قائمة الممرضين ====");
                    if(h.getNurses().isEmpty()) {
                        System.out.println("لا يوجد ممرضين مسجلين!");
                    } else {
                        h.getNurses().forEach(Nurse::displayDetails);
                    }
                    break;

                case 3:
                    System.out.print("اسم الممرض للبحث: ");
                    String searchName = s.nextLine();
                    List<Nurse> foundNurses = h.getNurses().stream()
                            .filter(n -> n.getName().equalsIgnoreCase(searchName))
                            .collect(Collectors.toList());

                    if(foundNurses.isEmpty()) {
                        System.out.println("لم يتم العثور على الممرض!");
                    } else {
                        foundNurses.forEach(Nurse::displayDetails);
                    }
                    break;

                case 4:
                    System.out.print("رقم الممرض للحذف: ");
                    int deleteId = s.nextInt();
                    s.nextLine();
                    boolean removed = h.getNurses().removeIf(n -> n.getId() == deleteId);
                    if(removed) {
                        System.out.println("تم حذف الممرض بنجاح!");
                    } else {
                        System.out.println("لم يتم العثور على الممرض!");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("خيار غير صحيح!");
            }
        }
    }

    // دوال إدارة العاملين
    private static void manageWorkers(HospitalManagement h, Scanner s) {
        while(true) {
            System.out.println("\n==== إدارة العاملين ====");
            System.out.println("1. إضافة عامل جديد");
            System.out.println("2. عرض جميع العاملين");
            System.out.println("3. بحث عامل بالاسم");
            System.out.println("4. حذف عامل");
            System.out.println("5. الرجوع للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");

            int choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("رقم العامل: ");
                    int id = s.nextInt();
                    System.out.print("الراتب: ");
                    double salary = s.nextDouble();
                    s.nextLine();
                    System.out.print("الاسم: ");
                    String name = s.nextLine();
                    System.out.print("العمر: ");
                    int age = s.nextInt();
                    s.nextLine();
                    System.out.print("رقم الهاتف: ");
                    String phone = s.nextLine();
                    System.out.print("العنوان: ");
                    String addr = s.nextLine();
                    System.out.print("المهمة: ");
                    String role = s.nextLine();

                    h.addWorker(new Worker(id, salary, name, age, phone, addr, role));
                    System.out.println("تمت إضافة العامل بنجاح!");
                    break;

                case 2:
                    System.out.println("\n==== قائمة العاملين ====");
                    if(h.getWorkers().isEmpty()) {
                        System.out.println("لا يوجد عاملين مسجلين!");
                    } else {
                        h.getWorkers().forEach(Worker::displayDetails);
                    }
                    break;

                case 3:
                    System.out.print("اسم العامل للبحث: ");
                    String searchName = s.nextLine();
                    List<Worker> foundWorkers = h.getWorkers().stream()
                            .filter(w -> w.getName().equalsIgnoreCase(searchName))
                            .collect(Collectors.toList());

                    if(foundWorkers.isEmpty()) {
                        System.out.println("لم يتم العثور على العامل!");
                    } else {
                        foundWorkers.forEach(Worker::displayDetails);
                    }
                    break;

                case 4:
                    System.out.print("رقم العامل للحذف: ");
                    int deleteId = s.nextInt();
                    s.nextLine();
                    boolean removed = h.getWorkers().removeIf(w -> w.getId() == deleteId);
                    if(removed) {
                        System.out.println("تم حذف العامل بنجاح!");
                    } else {
                        System.out.println("لم يتم العثور على العامل!");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("خيار غير صحيح!");
            }
        }
    }

    // دوال إدارة المواعيد
    private static void manageAppointments(HospitalManagement h, Scanner s) {
        while(true) {
            System.out.println("\n==== إدارة المواعيد ====");
            System.out.println("1. حجز موعد جديد");
            System.out.println("2. عرض جميع المواعيد");
            System.out.println("3. بحث مواعيد مريض");
            System.out.println("4. إلغاء موعد");
            System.out.println("5. الرجوع للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");

            int choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("اسم المريض: ");
                    String pName = s.nextLine();
                    System.out.print("اسم الطبيب: ");
                    String dName = s.nextLine();
                    System.out.print("تاريخ الموعد: ");
                    String date = s.nextLine();

                    List<Patient> patients = h.getPatients().stream()
                            .filter(p -> p.getName().equalsIgnoreCase(pName))
                            .collect(Collectors.toList());

                    List<Doctor> doctors = h.getDoctors().stream()
                            .filter(d -> d.getName().equalsIgnoreCase(dName))
                            .collect(Collectors.toList());

                    if(patients.isEmpty() || doctors.isEmpty()) {
                        System.out.println("المريض أو الطبيب غير موجود!");
                    } else {
                        h.addAppointment(new Appointment(patients.get(0), doctors.get(0), date));
                        System.out.println("تم حجز الموعد بنجاح!");
                    }
                    break;

                case 2:
                    System.out.println("\n==== جميع المواعيد ====");
                    if(h.getAppointments().isEmpty()) {
                        System.out.println("لا توجد مواعيد مسجلة!");
                    } else {
                        h.getAppointments().forEach(Appointment::displayDetails);
                    }
                    break;

                case 3:
                    System.out.print("اسم المريض للبحث: ");
                    String searchName = s.nextLine();
                    List<Appointment> patientApps = h.getAppointments().stream()
                            .filter(a -> a.getPatient().getName().equalsIgnoreCase(searchName))
                            .collect(Collectors.toList());

                    if(patientApps.isEmpty()) {
                        System.out.println("لا توجد مواعيد لهذا المريض!");
                    } else {
                        patientApps.forEach(Appointment::displayDetails);
                    }
                    break;

                case 4:
                    System.out.print("اسم المريض: ");
                    String delPName = s.nextLine();
                    System.out.print("اسم الطبيب: ");
                    String delDName = s.nextLine();
                    System.out.print("تاريخ الموعد: ");
                    String delDate = s.nextLine();

                    boolean removed = h.getAppointments().removeIf(a ->
                            a.getPatient().getName().equalsIgnoreCase(delPName) &&
                                    a.getDoctor().getName().equalsIgnoreCase(delDName) &&
                                    a.getDate().equals(delDate));

                    if(removed) {
                        System.out.println("تم إلغاء الموعد بنجاح!");
                    } else {
                        System.out.println("لم يتم العثور على الموعد!");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("خيار غير صحيح!");
            }
        }
    }

    // دوال إدارة الفواتير
    private static void manageInvoices(HospitalManagement h, Scanner s) {
        while(true) {
            System.out.println("\n==== إدارة الفواتير ====");
            System.out.println("1. إضافة فاتورة جديدة");
            System.out.println("2. عرض جميع الفواتير");
            System.out.println("3. بحث فواتير مريض");
            System.out.println("4. حذف فاتورة");
            System.out.println("5. الرجوع للقائمة الرئيسية");
            System.out.print("اختر الخيار: ");

            int choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("اسم المريض: ");
                    String pName = s.nextLine();
                    List<Patient> patients = h.getPatients().stream()
                            .filter(p -> p.getName().equalsIgnoreCase(pName))
                            .collect(Collectors.toList());

                    if(patients.isEmpty()) {
                        System.out.println("المريض غير موجود!");
                        continue;
                    }

                    System.out.print("رسوم الاستشارة: ");
                    double consultation = s.nextDouble();
                    System.out.print("رسوم الأدوية: ");
                    double medication = s.nextDouble();
                    s.nextLine();

                    h.addInvoice(new Invoice(patients.get(0), consultation, medication));
                    System.out.println("تمت إضافة الفاتورة بنجاح!");
                    break;

                case 2:
                    System.out.println("\n==== جميع الفواتير ====");
                    if(h.getInvoices().isEmpty()) {
                        System.out.println("لا توجد فواتير مسجلة!");
                    } else {
                        h.getInvoices().forEach(Invoice::displayDetails);
                    }
                    break;

                case 3:
                    System.out.print("اسم المريض للبحث: ");
                    String searchName = s.nextLine();
                    List<Invoice> patientInvoices = h.getInvoices().stream()
                            .filter(i -> i.getPatient().getName().equalsIgnoreCase(searchName))
                            .collect(Collectors.toList());

                    if(patientInvoices.isEmpty()) {
                        System.out.println("لا توجد فواتير لهذا المريض!");
                    } else {
                        patientInvoices.forEach(Invoice::displayDetails);
                    }
                    break;

                case 4:
                    System.out.print("اسم المريض لحذف الفاتورة: ");
                    String delName = s.nextLine();
                    boolean removed = h.getInvoices().removeIf(i ->
                            i.getPatient().getName().equalsIgnoreCase(delName));

                    if(removed) {
                        System.out.println("تم حذف الفاتورة بنجاح!");
                    } else {
                        System.out.println("لم يتم العثور على الفاتورة!");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("خيار غير صحيح!");

            }
        }
    }
}
