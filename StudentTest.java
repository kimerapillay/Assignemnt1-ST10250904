/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q1_prog6112_st10250904;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kimera Pillay
 */
public class StudentTest {

    public static Student student = new Student();

    public StudentTest() {
    }

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    public void testSaveStudent() {

        String id = "10111";
        String name = "J.Bloggs";
        int age = 19;
        String email = "jbloggs@ymail.com";
        String course = "disd";

        student.SaveStudent(id, name, age, email, course); // Call the SaveStudent method to save the student

        // Verify that the student details are correctly saved in memory
        assertEquals(id, student.studentID[0]);
        assertEquals(name, student.studentName[0]);
        assertEquals(age, student.studentAge[0]);
        assertEquals(email, student.studentEmail[0]);
        assertEquals(course, student.studentCourse[0]);

    }

    /**
     * Test of SearchStudent method, of class Student.
     */
    @Test
    public void testSearchStudent() {
        String id = "10111";
        String name = "J.Bloggs";
        int age = 19;
        String email = "jbloggs@ymail.com";
        String course = "disd";

        student.SaveStudent(id, name, age, email, course); // Call the SaveStudent method to save the student

        // Call the SearchStudent method with the student's ID
        boolean found = student.SearchStudent(id);

        // Verify that the student was found
        assertTrue(found);

        // Verify that the returned student details match the expected values
        assertEquals(id, student.studentID[0]);
        assertEquals(name, student.studentName[0]);
        assertEquals(age, student.studentAge[0]);
        assertEquals(email, student.studentEmail[0]);
        assertEquals(course, student.studentCourse[0]);
    }

    @Test
    public void testSearchStudent_StudentNotFound() {

        // Call the SearchStudent method with an incorrect student's ID
        boolean found = student.SearchStudent("55555");

        // Verify that no student was found
        assertFalse(found);

    }

    @Test
    public void testStudentAge_StuedentAgeInvalid() {

        // invalid student age supplied (less than 16)
        int invalidAge = 15;

        // Set the student's age
        student.setAge(invalidAge);

        // Verify that the student's age is less than 16
        assertTrue(student.getAge() < 16);

    }

    /**
     * Test of DeleteStudent method, of class Student.
     */
    @Test
    public void testDeleteStudent() {

        String id = "10111";
        String name = "J.Bloggs";
        int age = 19;
        String email = "jbloggs@ymail.com";
        String course = "disd";

        // Call the SaveStudent method to save the student
        student.SaveStudent(id, name, age, email, course);

        // Call the DeleteStudent method to delete the student
        student.DeleteStudent(id);

    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        String incorrectid = "55555";  //ID does not exist in the test data

        String id = "10111";
        String name = "J.Bloggs";
        int age = 19;
        String email = "jbloggs@ymail.com";
        String course = "disd";

        // Call the SaveStudent method to save the student
        student.SaveStudent(id, name, age, email, course);

        // Call the DeleteStudent method
        student.DeleteStudent(incorrectid);

        // Check that the student count remains the same
        assertEquals(1, student.numStudents);

        // Verify that the student with the incorrect ID was not deleted
        assertFalse(student.SearchStudent(incorrectid));

    }

    @Test
    public void testStudentAge_StudentAgeValid() {

        int validAge = 18;

        // Set the student's age
        student.setAge(validAge);

        // Verify that the student's age is valid
        assertEquals(validAge, student.getAge());

    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Supply an invalid character as the student age
        String invalidAge = "c";

        // Attempt to set the student's age with an invalid character
        try {
            int age = Integer.parseInt(invalidAge);
            student.setAge(age);
        } catch (NumberFormatException e) {
            // Expected exception, as the age is not a valid number
            return;
        }

        //test fail if no exception was thrown (age is not a valid number)
        fail("Expected NumberFormatException");
    }

}
