
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks = new int[3];

    Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    int getTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 40) return "C";
        else return "F";
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + getTotal());
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
    }
}

public class StudentPerformanceTracker {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Performance Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Name: ");
        scanner.nextLine();  // consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        students.add(new Student(name, rollNo, marks));
        System.out.println("Student added successfully!");
    }

    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        for (Student student : students) {
            student.display();
            System.out.println("---------------------------");
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int rollNo = scanner.nextInt();
        for (Student student : students) {
            if (student.rollNo == rollNo) {
                student.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
