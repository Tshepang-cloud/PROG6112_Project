/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gradetrackerapp;


import static org.junit.Assert.*;
import org.junit.Test;


public class StudentTest {

    @Test
    public void testAddMarkAndAverage() {
        Student s = new Student("S001", "Alice", 3);
        s.addMark(0, 80);
        s.addMark(1, 70);
        s.addMark(2, 90);

        assertEquals("Average should be 80", 80.0, s.getAverage(), 0.01);
    }

    @Test
    public void testUpdateMark() {
        Student s = new Student("S002", "Bob", 2);
        s.addMark(0, 50);
        s.addMark(1, 60);

        // Update mark at index 1
        s.addMark(1, 100);

        assertEquals("Average should update to 75", 75.0, s.getAverage(), 0.01);
    }

    @Test
    public void testInvalidIndexDoesNotBreak() {
        Student s = new Student("S003", "Charlie", 2);
        s.addMark(0, 40);

        // Try adding mark at invalid index
        s.addMark(5, 90);

        assertEquals("Only one valid mark should count", 20.0, s.getAverage(), 0.01);
    }
}
 
    