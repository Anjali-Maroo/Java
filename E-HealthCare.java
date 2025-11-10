import java.util.*;

public class Main {
    static class Doctor {
        String username;
        String password;
        List<String> appointments = new ArrayList<>();

        Doctor(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    static List<Doctor> doctors = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   // consume newline

            if (choice == 1) {
                doctorMenu();
            } else if (choice == 2) {
                patientMenu();
            } else if (choice == 3) {
                System.out.println("Thank you for using E-HealthCare Management. Goodbye.");
                break;
            } else {
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    private static void doctorMenu() {
        System.out.println("1. Register as a new doctor");
        System.out.println("2. Login as an existing doctor");
        System.out.print("Please choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter your desired username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            doctors.add(new Doctor(username, password));
            System.out.println("You have successfully registered as a doctor.");
        } else if (choice == 2) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            Doctor doctor = null;
            for (Doctor d : doctors) {
                if (d.username.equals(username) && d.password.equals(password)) {
                    doctor = d;
                    break;
                }
            }

            if (doctor != null) {
                System.out.println("Login successful. Here are your patient appointments:");
                if (doctor.appointments.isEmpty()) {
                    System.out.println("You have no appointments at this time.");
                } else {
                    for (String appointment : doctor.appointments) {
                        System.out.println(appointment);
                    }
                }
            } else {
                System.out.println("Invalid username or password. Login failed.");
            }
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static void patientMenu() {
        System.out.print("Enter the username of the doctor you wish to book with: ");
        String doctorUsername = scanner.nextLine();

        Doctor targetDoctor = null;
        for (Doctor d : doctors) {
            if (d.username.equals(doctorUsername)) {
                targetDoctor = d;
                break;
            }
        }

        if (targetDoctor == null) {
            System.out.println("No doctor found with the username '" + doctorUsername + "'. Please check and try again.");
            return;
        }

        System.out.print("Describe your health issue (e.g., cold, fever): ");
        String issue = scanner.nextLine();
        targetDoctor.appointments.add("Patient reported: " + issue);
        System.out.println("Your appointment has been successfully booked with Dr. " + doctorUsername + ".");
    }
}
