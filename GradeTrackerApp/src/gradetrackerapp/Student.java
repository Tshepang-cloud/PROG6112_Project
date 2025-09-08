/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradetrackerapp;

/**
 *
 * @author RC_Student_lab
 */

public class Student extends Person {
    private int[] marks; // advanced arrays
    private int subjectCount;

    public Student(String id, String name, int subjectCount) {
        super(id, name);
        this.subjectCount = subjectCount;
        this.marks = new int[subjectCount];
    }

    public void addMark(int subjectIndex, int mark) {
        if (subjectIndex >= 0 && subjectIndex < subjectCount) {
            marks[subjectIndex] = mark;
        }
    }

    public double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / subjectCount;
    }

    public int[] getMarks() { return marks; }
}