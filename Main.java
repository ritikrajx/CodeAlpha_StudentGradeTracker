import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GradeTracker tracker = new GradeTracker();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("       STUDENT GRADE TRACKER");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.println("======================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    tracker.displayAllStudents();
                    break;
                case 3:
                    int rollNumber = readInt("Enter roll number: ");
                    tracker.displayStudent(rollNumber);
                    break;
                case 4:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        String name;
        while (true) {
            System.out.print("Enter student name: ");
            name = scanner.nextLine().trim();

            if (!name.isEmpty()) break;
            System.out.println("Name cannot be empty.");
        }

        int rollNumber = readInt("Enter roll number: ");

        Student student = new Student(name, rollNumber);

        int subjectCount;
        do {
            subjectCount = readInt("Enter number of subjects: ");
            if (subjectCount <= 0) {
                System.out.println("Number of subjects must be greater than 0.");
            }
        } while (subjectCount <= 0);

        for (int i = 1; i <= subjectCount; i++) {
            student.addMark(readMark(
                    "Enter marks for Subject " + i + " (0-100): "));
        }

        tracker.addStudent(student);

        System.out.println("\nStudent added successfully!");
        tracker.displayStudent(rollNumber);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readMark(String message) {
        while (true) {
            System.out.print(message);
            try {
                double mark = Double.parseDouble(scanner.nextLine().trim());

                if (mark >= 0 && mark <= 100) return mark;

                System.out.println("Marks must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
