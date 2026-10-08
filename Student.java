import java.util.ArrayList;

public class Student {
    private String name;
    private int rollNumber;
    private ArrayList<Double> marks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = new ArrayList<>();
    }

    public void addMark(double mark) {
        marks.add(mark);
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public ArrayList<Double> getMarks() {
        return marks;
    }

    public double getAverage() {
        if (marks.isEmpty()) return 0;

        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.size();
    }

    public double getHighest() {
        if (marks.isEmpty()) return 0;

        double highest = marks.get(0);
        for (double mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }

    public double getLowest() {
        if (marks.isEmpty()) return 0;

        double lowest = marks.get(0);
        for (double mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

    public String getGrade() {
        double average = getAverage();

        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B";
        if (average >= 60) return "C";
        if (average >= 50) return "D";
        return "F";
    }
}
