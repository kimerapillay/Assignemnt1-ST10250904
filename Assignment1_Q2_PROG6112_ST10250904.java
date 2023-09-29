/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q2_prog6112_st10250904;

import java.util.Scanner;

/**
 *
 * @author Kimera Pillay
 */
public class Assignment1_Q2_PROG6112_ST10250904 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Variables declared        
        double betAmount, initialBalance;
        int choice;

        Scanner kb = new Scanner(System.in);// Scanner object declared

        System.out.println("-------------------------------------------------" //Output
                + "\n$$$$$$$$ WELCOME TO THE LEPRECHAUN MAN GAME $$$$$$$$\n"
                + "READY TO WIN $ YOUR SHARE OF PRIZES IN CASH ???"
                + "\n-------------------------------------------------\n");

        System.out.println("Hit ENTER to begin!");
        kb.nextLine();

        System.out.print("Enter your Starting Amount: R");
        initialBalance = kb.nextDouble();
        System.out.print("Enter your Bet Amount: R");
        betAmount = kb.nextDouble();

        // Instances of slot machines created
        SlotMachine fruitSlotMachine = new FruitSlotMachine(initialBalance, betAmount);
        SlotMachine classicSlotMachine = new ClassicSlotMachine(initialBalance, betAmount);

        System.out.print("\nSelect a Slot Machine:\n"
                + "Enter (1) to play the FRUIT SLOT machine\n"
                + "Enter (2) to play the CLASSIC SLOT Machine");
        choice = kb.nextInt();

        //validate user input
        while (choice < 1 || choice > 2) {
            System.out.println("You have entered an in-valid choice :(");
            System.out.print("Select a Slot Machine:\n"
                    + "Enter (1) to play the FRUIT SLOT machine\n"
                    + "Enter (2) to play the CLASSIC SLOT Machine");
            choice = kb.nextInt();

        }//end while

        if (choice == 1) {
            fruitSlotMachine.play();
        } else {
            classicSlotMachine.play();
        }

        kb.close();
    }

}
