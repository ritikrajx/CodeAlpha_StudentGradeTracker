import java.util.ArrayList;

public class GradeTracker {
    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo student records found.");
            return;
        }

        System.out.println("\n================ ALL STUDENTS ================");
        System.out.printf("%-10s %-20s %-12s %-10s%n",
                "Roll No.", "Name", "Average", "Grade");
        System.out.println("----------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-10d %-20s %-12.2f %-10s%n",
                    student.getRollNumber(),
                    student.getName(),
                    student.getAverage(),
                    student.getGrade());
        }

        System.out.println("==============================================");
    }

    public void displayStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("\n------------- STUDENT REPORT -------------");
                System.out.println("Name       : " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Marks      : " + student.getMarks());
                System.out.printf("Average    : %.2f%n", student.getAverage());
                System.out.printf("Highest    : %.2f%n", student.getHighest());
                System.out.printf("Lowest     : %.2f%n", student.getLowest());
                System.out.println("Grade      : " + student.getGrade());
                System.out.println("------------------------------------------");
                return;
            }
        }

        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}
