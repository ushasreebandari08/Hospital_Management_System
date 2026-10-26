
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("-------------------------");
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("-------------------------");
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. View All Doctors");
            System.out.println("6. Book Appointment");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    addDoctor();
                    break;

                case 5:
                    viewDoctors();
                    break;

                case 6:
                    bookAppointment();
                    break;

                case 7:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }

    static void addPatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findPatient(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("\n--- Patient Records ---");

        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {

        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient p = findPatient(id);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Patient not found.");
        }
    }

    static Patient findPatient(int id) {

        for (Patient p : patients) {
            if (p.id == id) {
                return p;
            }
        }

        return null;
    }

    static void addDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Doctor d : doctors) {
            if (d.id == id) {
                System.out.println("Doctor ID already exists.");
                return;
            }
        }

        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(id, name, specialization));

        System.out.println("Doctor added successfully!");
    }

    static void viewDoctors() {

        if (doctors.isEmpty()) {
            System.out.println("No doctor records found.");
            return;
        }

        System.out.println("\n--- Doctor Records ---");

        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void bookAppointment() {

        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println(
                "Please add at least one patient and one doctor first."
            );
            return;
        }

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        Patient patient = findPatient(patientId);
        Doctor doctor = null;

        for (Doctor d : doctors) {
            if (d.id == doctorId) {
                doctor = d;
                break;
            }
        }

        if (patient == null || doctor == null) {
            System.out.println("Invalid Patient ID or Doctor ID.");
            return;
        }

        System.out.print("Enter Appointment Date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        System.out.println("\nAppointment Booked Successfully!");
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name);
        System.out.println("Date: " + date);
    }
}

