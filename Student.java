/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q1_prog6112_st10250904;

/**
 *
 * @author Kimera Pillay
 */
public class Student {

    //Variables declared
    public static String id, name, email, course;
    public static int age, numStudents, index;// index variable created globally

    //Arrays declared
    public static String[] studentID = new String[1100];
    public static String[] studentName = new String[1100];
    public static int[] studentAge = new int[1100];
    public static String[] studentEmail = new String[1100];
    public static String[] studentCourse = new String[1100];

    public Student() {
        this.numStudents = 0;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Student.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Student.email = email;
    }

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        Student.course = course;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Student.age = age;
    }

//////////////////////////////////////SAVE STUDENT//////////////////////////////   
    public static void SaveStudent(String id, String name, int age, String email, String course) {

        //Adding student to the respected arrays...
        if (numStudents < 1100) { // checks if the number of Studnts is less than 1100 so that another student can be captured
            studentID[numStudents] = id;
            studentName[numStudents] = name;
            studentAge[numStudents] = age;
            studentEmail[numStudents] = email;
            studentCourse[numStudents] = course;

            numStudents++; //each time a student is added increments the counter...
        }//end if
    }

//////////////////////////////////////SEARCH STUDENT////////////////////////////
    public static Boolean SearchStudent(String id) {

        Boolean found = false; // variable initialized

//For loop is executed and checks each element of the array for the student id entered by the user        
        for (int i = 0; i < studentID.length; i++) {

            if (id.equals(studentID[i])) { //checks if student id supplied by user matches  a student id in the studentID array...
                found = true;// if it is found set the boolean variable to true
                index = i; //stores the element position of the student id in the studentID array in the index variable...
            }// end if 

            if (found == true) {
                break;
            }
        }// end for loop

        return found;//returns either true or false
    }

    /////////////////////////////////DISPLAY SEARCHED STUDENT//////////////////
    public static String DisplaySearchedStudent() {

        //The global index variable can be accessed by the DisplaySearchedStudent method to display that specific student's details...
        return "------------------------------------------------------"
                + "\nSTUDENT ID: " + studentID[index]
                + "\nSTUDENT NAME:" + studentName[index]
                + "\nSTUDENT AGE: " + studentAge[index]
                + "\nSTUDENT EMAIL: " + studentEmail[index]
                + "\nSTUDENT COURSE: " + studentCourse[index];

    }

//////////////////////////////////////DELETE STUDENT////////////////////////////
    public static void DeleteStudent(String id) {

        Boolean found = false;

        // Search for the student with the specified ID
        for (int i = 0; i < studentID.length; i++) {

            if (studentID[i] != null && studentID[i].equals(id)) {

                found = true;

                for (int j = i; j < numStudents - 1; j++) { // Shift elements to remove the student
                    studentID[j] = studentID[j + 1];
                    studentName[j] = studentName[j + 1];
                    studentAge[j] = studentAge[j + 1];
                    studentEmail[j] = studentEmail[j + 1];
                    studentCourse[j] = studentCourse[j + 1];
                }//end for loop 2

                // Clear the last element
                studentID[numStudents - 1] = null;
                studentName[numStudents - 1] = null;
                studentAge[numStudents - 1] = 0;
                studentEmail[numStudents - 1] = null;
                studentCourse[numStudents - 1] = null;

                // Decrement the student counter
                numStudents--;

                break;
            }//end if

        }//end for loop 1

    }

//////////////////////////////////////STUDENT REPORT////////////////////////////
    public static String StudentReport() {

        String studentReport = "";// variables initialized

        //Displays all students details
        for (int i = 0; i < numStudents; i++) {

            studentReport = studentReport + "\nSTUDENT " + (i + 1) + "\n"
                    + "--------------------------------------"
                    + "\nSTUDENT ID:" + studentID[i]
                    + "\nSTUDENT NAME:" + studentName[i]
                    + "\nSTUDENT AGE:" + studentAge[i]
                    + "\nSTUDENT EMAIL:" + studentEmail[i]
                    + "\nSTUDENT COURSE:" + studentCourse[i]
                    + "\n--------------------------------------\n";

        }//end for
        return studentReport;
    }
//////////////////////////////////////EXIT APPLICATION//////////////////////////

    public static void ExitApplication() {

        System.exit(0);

    }

}// end main

