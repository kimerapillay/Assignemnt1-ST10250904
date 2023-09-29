/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q2_prog6112_st10250904;

import java.util.Random;

/**
 *
 * @author Kimera Pillay
 */
public class ClassicSlotMachine extends SlotMachine {

    // Constructor to initialize ClassicSlotMachine with the variables initial balance and bet amount
    public ClassicSlotMachine(double initialBalance, double betAmount) {
        super(initialBalance, betAmount);
    }

    // Method to initialize the slot machine reels with random symbols
    //Random class used to generate random values in range 1 to 4 then convert it to the appropriate string and save it in the 2D Array
    @Override
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

    @Override
    protected double calculateWin() {
        if (reels.length > 0) {
            for (int row = 0; row < reels.length; row++) {
                boolean sameSymbols = true; // Flag to check if all symbols in the row are the same
                for (int col = 1; col < 4; col++) {
                    if (!reels[row][col].equals(reels[row][0])) {
                        sameSymbols = false;
                        break; // Not all symbols in this row are the same
                    }
                }//end for 2
                if (sameSymbols) {
                    double discountedAmount = betAmount * 0.95; // 5% discount (95% payout)
                    return Math.round(discountedAmount); // Round to the nearest whole number
                }
            }//end for 1
        }
        return 0; // No win
    }

}
