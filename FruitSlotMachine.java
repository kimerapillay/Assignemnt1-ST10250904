/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q2_prog6112_st10250904;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author Kimera Pillay
 */
public class FruitSlotMachine extends SlotMachine {

    // Constructor to initialize FruitSlotMachine with initial balance and bet amount
    public FruitSlotMachine(double initialBalance, double betAmount) {
        super(initialBalance, betAmount);
    }

    // Method to initialize the slot machine reels with random fruit symbols
    @Override
    protected void initializeReels() {
        Random random = new Random();
        for (int row = 0; row < reels.length; row++) {
            for (int col = 0; col < 4; col++) {
                int randomValue = random.nextInt(4) + 1;
                switch (randomValue) {
                    case 1:
                        reels[row][col] = "CHERRY";
                        break;
                    case 2:
                        reels[row][col] = "LEMON";
                        break;
                    case 3:
                        reels[row][col] = "ORANGE";
                        break;
                    case 4:
                        reels[row][col] = "GRAPE";
                        break;
                }
            }
        }
    }

    // Method to calculate the player's win based on fruit symbols and the day and time
    @Override
    protected double calculateWin() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Check if it's Saturday and the time is after 9:30 pm
        if (currentDateTime.getDayOfWeek() == DayOfWeek.SATURDAY && currentDateTime.toLocalTime().isAfter(LocalTime.of(21, 30))) {
            // Check if all rows have the same symbol
            if (reels.length > 0) {
                String symbol = reels[0][0];
                for (int row = 0; row < reels.length; row++) {
                    for (int col = 0; col < 4; col++) {
                        if (!reels[row][col].equals(symbol)) {
                            return 0; // No win if any row doesn't match
                        }
                    }
                }
                return 1000; // Win 1000 on Saturday after 9:30 pm with matching symbols in all rows
            }
        }

        return 0; // No win
    }

}
