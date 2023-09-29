/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q1_prog6112_st10250904;

import java.util.Scanner;

/**
 *
 * @author Kimera Pillay
 */
public class Assignment1_Q1_PROG6112_ST10250904 {

    public static Scanner kb = new Scanner(System.in);//Gloabel scanner object created
    public static String userInput, selection, id;// Global variables declared
    public static Student st = new Student();//Object of class student created

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("STUDENT MANAGEMENT APPLICATION\n***************************************");
        Menu();// menu method called
    }// end main

/////////////////////////////////////// MENU ///////////////////////////////////
    public static void Menu() {

        System.out.println("Enter (1) to launch menu or any other key to exit");

        userInput = kb.nextLine();

        if ("1".equals(userInput)) { // If 1 is entered shows the menu...
            System.out.println("Please select one of the following menu items:"
                    + "\n(1) Capture a new student."
                    + "\n(2) Search for a student."
                    + "\n(3) Delete a student."
                    + "\n(4) Print student report."
                    + "\n(5) Exit Application.");

            selection = kb.nextLine();

            // checks if selection is NOT a numeric digit or checks if selection is not one of the menu items 
            while (selection.matches("\\d+") == false || Integer.parseInt(selection) < 1 || Integer.parseInt(selection) > 5) {

                System.out.println("You have entered an in-valid selection");

                System.out.println("Please select one of the following menu items:"
                        + "\n(1) Capture a new student."
                        + "\n(2) Search for a student."
                        + "\n(3) Delete a student."
                        + "\n(4) Print student report."
                        + "\n(5) Exit Application.");

                selection = kb.nextLine();
            }// end while  

            switch (Integer.parseInt(selection)) {
                case 1:
                    CaptureStudent();// method called to save a new student...
                    break;
                case 2:
                    SearchStudent();// method called to search for an existing student...
                    break;
                case 3:
                    DeleteStudent();//method called to delete an existing student from the system...
                    break;
                case 4:
                    System.out.println(st.StudentReport());// method called to display the student report...
                    Menu();
                    break;
                case 5:
                    st.ExitApplication();//method called to Exit program
                    break;

            }//end switch case
        } else {
            st.ExitApplication();// method called to Exit program
        }//end if else

    }//end menu

///////////////////////////////CAPTURE STUDENT//////////////////////////////////    
    public static void CaptureStudent() {

        String name, email, course, age;//Variables declared
        // declared age as a string because in assignment shows that age can be any value but ONLY must be numbers when checking

        System.out.println("CAPTURE A NEW STUDENT"
                + "\n*********************");
        System.out.println("Enter the student id:");
        id = kb.nextLine();

        while (st.SearchStudent(id) == true) { //checks if the student already exists in the system and if so requests for another id to be entered until a correct id is entered...
            System.out.println("This student id already exists in the system...Please enter another student id...\n");
            System.out.println("Enter the student id:");
            id = kb.nextLine();
        }// end while loop

        System.out.println("Enter the student name:");
        name = kb.nextLine();
        System.out.println("Enter the student age:");
        age = kb.nextLine();

        while (age.matches("\\d+") == false || Integer.parseInt(age) < 16) { // checks if age is NOT a numeric digit...           
            System.out.println("You have entered an in-correct student age!!!\nPlease re-enter the student age >>");
            System.out.println("Enter the student age:");//if age was not entered as a numeric digit it requests for a valid age to be entered...
            age = kb.nextLine();//stores the new user input in the variable age
        }// end while

        System.out.println("Enter the student email:");
        email = kb.nextLine();

        while (email.contains("@") != true) { //checks if email address contains the "@" symbol, this is to validate a valid email is entered...
            System.out.println("You have entered an in-valid email adress...Please re-enter a valid email address");
            System.out.println("Enter the student email:"); //if valid e-mail address not entered,it will request the user to enter an email address until a valid one is entered
            email = kb.nextLine();
        }//while

        System.out.println("Enter the student course:");
        course = kb.nextLine();

        st.SaveStudent(id, name, Integer.parseInt(age), email, course); //save student method called to take student details and save it in the respected arrays
        System.out.println("\n--------------------------------------------------\nStudent details have been saved successfully...\n--------------------------------------------------\n");
        Menu();// method called

    }// end capture student method   

////////////////////////////////// SEARCH STUDENT //////////////////////////////
    public static void SearchStudent() {

        System.out.println("Enter the student id to search:");
        id = kb.nextLine();

        if (st.SearchStudent(id) == true) {
            System.out.println(st.DisplaySearchedStudent()); // method called to display the searched student details if their student id was found
        } else {
            System.out.println("-----------------------------------------------------"
                    + "\nStudent with student id: " + id + " was not found!" //displays an error message if student was not found...
                    + "\n-----------------------------------------------------1");

        }//end if else

        Menu();// menu method called

    }//end search student method

/////////////////////////////////// DELETE STUDENT /////////////////////////////
    public static void DeleteStudent() {

        String choice;// variables declared

        System.out.println("Enter the student id to be deleted:");
        id = kb.nextLine();

        if (st.SearchStudent(id) == true) {//search student method called to check if the student id exists in the system...

            System.out.println("Are you sure you want to delete student " + id + " from the system? Enter Yes (y) to delete.");
            choice = kb.nextLine();

            if ("y".equals(choice) || "Y".equals(choice)) {// if user entered y then student is deleted
                st.DeleteStudent(id);// delete student method called

                System.out.println("----------------------------------------------------"
                        + "\nStudent with student id " + id + " WAS deleted!" //output message
                        + "\n----------------------------------------------------");

            } else {
                System.out.println("You have selected another key...Student with student id " + id + " will not be deleted from the system");
            }//end else if 2

        } else {
            System.out.println("Student was not found!");

        }//end else if 2
        Menu();
    }//end delete student method    

}// end program
