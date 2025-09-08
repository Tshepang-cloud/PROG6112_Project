package gradetrackerapp;

import java.util.*;

public class GradeTrackerApp {
    private static Student[] students = new Student[5]; // fixed array for demo
    private static int studentCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. Record Marks");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> recordMarks();
                case 3 -> report();
                case 4 -> { System.out.println("Goodbye 👋"); return; }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Max students reached!");
            return;
        }
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt(); sc.nextLine();

        students[studentCount++] = new Student(id, name, subjects);
        System.out.println("✅ Student added successfully!");
    }

    private static void recordMarks() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s != null && s.getId().equalsIgnoreCase(id)) {
                int[] marks = s.getMarks();
                for (int i = 0; i < marks.length; i++) {
                    System.out.print("Enter mark for subject " + (i+1) + ": ");
                    s.addMark(i, sc.nextInt());
                }
                sc.nextLine();
                System.out.println("✅ Marks recorded!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    private static void report() {
        System.out.println("\n📊 Student Report:");
        for (Student s : students) {
            if (s != null) {
                System.out.println(s.getId() + " | " + s.getName() + " | Avg: " + s.getAverage());
            }
        }
    }
}
