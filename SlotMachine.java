/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q2_prog6112_st10250904;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kimera Pillay
 */
public class SlotMachine {

    protected String[][] reels; // 2D array declared to store symbols
    //Variables declared
    protected double balance;
    protected double betAmount;

    public String[][] getReels() {
        return reels;
    }

    public void setReels(String[][] reels) {
        this.reels = reels;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }

    // Constructor to initialize the slot machine
    public SlotMachine(double initialBalance, double betAmount) {
        this.balance = initialBalance;
        this.betAmount = betAmount;
        int numRows = (int) (initialBalance / betAmount); // Calculate the number of rows
        this.reels = new String[numRows][4]; // 4 columns for symbols
        initializeReels();
    }

    protected void initializeReels() {
        Random random = new Random();
        for (int row = 0; row < reels.length; row++) {
            for (int col = 0; col < 4; col++) {
                int randomValue = random.nextInt(4) + 1;
                switch (randomValue) {
                    case 1:
                        reels[row][col] = "CLOVER";
                        break;
                    case 2:
                        reels[row][col] = "GOLD$$";
                        break;
                    case 3:
                        reels[row][col] = "LEPRECHAUN";
                        break;
                    case 4:
                        reels[row][col] = "QUESTIONMARK?";
                        break;
                }
            }
        }
    }

    protected void displayReels() {
        for (int row = 0; row < reels.length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int col = 0; col < 4; col++) {
                System.out.print(reels[row][col]);
                if (col < 3) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    protected double calculateWin() {

        if (reels.length > 0) { //condition checks to see if there is atleast one row of symbols in the array
            for (int row = 0; row < reels.length; row++) {// loop iterates through each row
                /*
                 In each row, the method selects the symbol in the first column (column 0) and 
                assigns it to the symbol variable. This symbol is used as
                a reference to check if all symbols in the row are the same.
                 */
                String symbol = reels[row][0];
                for (int col = 1; col < 4; col++) { //inner loop iterates through the coloumns of current row
                    if (!reels[row][col].equals(symbol)) {
                        break; // No win in this row
                    }
                    if (col == 3) {
                        return betAmount * 10; // Win: Same symbol in this row
                    }
                }
            }
        }
        return 0; // No win
    }

    public void play() {
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n----------------------------------------------\n"
                + "<<<< WELCOME TO THE SLOT MACHINE >>>>\n----------------------------------------------"
                + "\n");

        while (balance >= betAmount) {
            System.out.println("Your Balance: R" + balance);
            System.out.println("Bet Amount: R" + betAmount + "\n");
            System.out.print("Press ENTER to spin the reels or 'C' to cashout:\n\n---------------------------------------------------------");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("c")) {
                break;
            }

            balance -= betAmount;

            initializeReels(); // Initialize the reels with new values
            counter++;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> ROUND " + counter + ": >>>>>>>>>>>>>>>>>>>>>>\n---------------------------------------------------------\n" + reels[0][0] + "  " + reels[0][1] + "  " + reels[0][2] + "  " + reels[0][3] + "\n");

            double winAmount = calculateWin();

            if (winAmount > 0) {
                System.out.println("\nCONGRATULATIONS >>> You WON: R" + winAmount);
            } else {
                System.out.println("NO win this time :(");
            }

            balance += winAmount;

        }//end while

        System.out.println("Cash Out complete...GAME OVER! Your final balance >>>: R" + balance);
        scanner.close();
    }

}
