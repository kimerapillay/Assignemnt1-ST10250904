/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_q2_prog6112_st10250904;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Kimera Pillay
 */
public class SlotMachineTest {

    private SlotMachine slotMachine;

    @Before
    public void setUp() {
        // Initialize the slot machine with initialBalance and betAmount
        slotMachine = new SlotMachine(100.0, 10.0);
    }

    @Test
    public void testConstructor() {
        // Verify that the constructor initializes balance and betAmount correctly
        assertEquals(100.0, slotMachine.getBalance(), 0.001);
        assertEquals(10.0, slotMachine.getBetAmount(), 0.001);
        assertNotNull(slotMachine.getReels());
    }

    @Test
    public void testInitializeReels() {
        // Test that initializeReels sets valid symbols in the reels array
        slotMachine.initializeReels();
        String[][] reels = slotMachine.getReels();
        for (int i = 0; i < reels.length; i++) {
            for (int j = 0; j < 4; j++) {
                assertTrue(isValidSymbol(reels[i][j]));
            }
        }
    }

    @Test
    public void testCalculateWinNoWin() {
        // Initialize the reels with a non-winning combination
        String[][] nonWinningReels = {
            {"CLOVER", "GOLD$$", "LEPRECHAUN", "QUESTIONMARK?"}
        };
        slotMachine.setReels(nonWinningReels);

        // Calculate the win
        double winAmount = slotMachine.calculateWin();

        // Verify that the win amount is 0 for a non-winning combination
        assertEquals(0.0, winAmount, 0.001);
    }

    // Helper method to check if a symbol is valid
    private boolean isValidSymbol(String symbol) {
        return symbol.equals("CLOVER") || symbol.equals("GOLD$$")
                || symbol.equals("LEPRECHAUN") || symbol.equals("QUESTIONMARK?");
    }

}
