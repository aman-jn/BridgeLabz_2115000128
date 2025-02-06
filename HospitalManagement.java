import java.util.*;
class Patient {
    String name;
    List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void consultDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.addPatient(this);
        System.out.println(name + " is consulting Dr. " + doctor.name);
    }

    public void displayDoctors() {
        System.out.println("Patient: " + name + " - Consulting Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.name);
        }
    }
}

class Doctor {
    String name;
    List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting " + patient.name);
    }

    public void displayPatients() {
        System.out.println("Dr. " + name + " - Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.name);
        }
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.name);
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.name);
        }
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner adi = new Scanner(System.in);

        System.out.print("Enter hospital name: ");
        String hospitalName = adi.nextLine();
        Hospital hospital = new Hospital(hospitalName);

        System.out.print("Enter number of doctors: ");
        int numDoctors = adi.nextInt();
        adi.nextLine();
        List<Doctor> doctorList = new ArrayList<>();
        for (int i = 0; i < numDoctors; i++) {
            System.out.print("Enter doctor name: ");
            String doctorName = adi.nextLine();
            Doctor doctor = new Doctor(doctorName);
            hospital.addDoctor(doctor);
            doctorList.add(doctor);
        }

        System.out.print("Enter number of patients: ");
        int numPatients = adi.nextInt();
        adi.nextLine();
        List<Patient> patientList = new ArrayList<>();
        for (int i = 0; i < numPatients; i++) {
            System.out.print("Enter patient name: ");
            String patientName = adi.nextLine();
            Patient patient = new Patient(patientName);
            hospital.addPatient(patient);
            patientList.add(patient);
        }

        for (Patient patient : patientList) {
            System.out.println("Assigning doctors for " + patient.name);
            for (Doctor doctor : doctorList) {
                System.out.print("Should " + patient.name + " consult Dr. " + doctor.name + "? (yes/no): ");
                String response = adi.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    patient.consultDoctor(doctor);
                }
            }
        }

        System.out.println();
        hospital.displayHospitalDetails();
        for (Doctor doctor : doctorList) {
            doctor.displayPatients();
        }
        for (Patient patient : patientList) {
            patient.displayDoctors();
        }
        adi.close();
    }
}