package games;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Factman_Swing extends Factman_GUI {
    static ArrayList<Integer> gameBoard;
    static int upperBound, factorIndex, p1Score = 0, p2Score = 0;
    static boolean player1 = true;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Factman_GUI factman = new Factman_GUI();
                factman.setVisible(true);
            }
        });

        playGame();
    }

    public static void playGame() {
        // set the flag false to prevent a new game when someone wins
        newGameFlag = false;
        // make sure the label text is black
        // gameAreaLabel.setForeground(Color.black);

        // create a popup window to get the upper bound
        upperBound = Integer.parseInt(JOptionPane.showInputDialog(
            panel, "Enter the upper bound for this game", null));
        System.out.println("Upper bound = " + upperBound);

        // generate the arraylist with the given upper limit
        gameBoard = createList(upperBound);
        System.out.println(gameBoard);

        // as long as there are numbers left in the list, keep looping the game
        while(!gameBoard.isEmpty()) {
            // if the new game option was selected, go back to main
            if (newGameFlag) return;

            // show the list in the GUI
            gameAreaLabel.setVisible(!hideBoard.getState());
            gameAreaLabel.setText(gameBoard.toString());

            // indicate whose turn it is in the GUI
            if(player1) turnIndicator.setText("It's Player 1's Turn");
            else        turnIndicator.setText("It's Player 2's Turn");

            // userSelection becomes non-zero when a
            // number is entered in the text field
            if (userSelection >= 0) {
                // save the input and set it back to zero
                // so the loop doesnt fire again
                int selection = userSelection;
                userSelection = -1;
                System.out.println("User selected " + selection);

                // wrap the selection in an Integer object for comparison with the list
                Integer number = new Integer(selection);
                // the player will loose his/her turn if an invalid number is entered
                if (!gameBoard.contains(number)) {
                    JOptionPane.showMessageDialog(
                        panel,
                        "The number you selected is not in the list.\nYou loose a turn",
                        "OOPS",
                        JOptionPane.ERROR_MESSAGE);
                    player1 = !player1;
                    continue;
                }

                // add the selection to the current player's score
                if (player1) p1Score += selection;
                else         p2Score += selection;

                // search for and remove the selection from the list
                removeInt(gameBoard, selection);

                // as long as there are factors, add them to the other
                // players score and remove them from the list
                do {
                    factorIndex = findFactor(gameBoard, selection);
                    if (factorIndex >= 0) {
                        int value = gameBoard.get(factorIndex).intValue();
                        if (player1) p2Score += value;
                        else         p1Score += value;
                        // remove the factor
                        removeInt(gameBoard, value);
                    }
                } while (factorIndex >= 0);    // loop until no factor is found

                // show the scores in the GUI
                p1ScoreLabel.setText(String.valueOf(p1Score));
                p2ScoreLabel.setText(String.valueOf(p2Score));

                // switch players
                player1 = !player1;
            }
        }

        // Show who won
        gameAreaLabel.setForeground(Color.blue);
        if (p1Score > p2Score)       gameAreaLabel.setText("PLAYER 1 WINS!!!!");
        else if (p1Score < p2Score)  gameAreaLabel.setText("PLAYER 2 WINS!!!!");
        else gameAreaLabel.setText("Somehow, you managed to tie.  Nice going.");
    }

    /**
     * Create a list of Integer objects from 1 to limit, inclusive.
     * @param limit the upper bound of the list
     * @return an ArrayList of Integer type 
     */
    public static ArrayList<Integer> createList(int limit) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 1; i <= limit; i ++) {
            temp.add(new Integer(i));
        }
        return temp;
    }

    /**
     * Search for the specified value in the list and remove the object
     * from the list. The remove method of the ArrayList class removes
     * the object and shifts all of the objects following it to the
     * left one index.
     * @param list  an ArrayList of Integers to search
     * @param value the value to remove from the list
     * @see java.util.ArrayList#remove
     */
    private static void removeInt(ArrayList<Integer> list, int value) {
        // loop through the list until the value of the object matches
        // the specified value, then remove it
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i).intValue() == value) {
                list.remove(i);
            }
        }
    }

    /**
     * Returns the index of the first factor of the specified number in
     * the specified ArrayList.  If no factor is found, -1 is returned.
     * @param list   an ArrayList of Integers to search
     * @param number the value to find factors of
     * @return the index of the first factor, or -1 if no factors exist
     */
    private static int findFactor(ArrayList<Integer> list, int number) {
        // loop through the list until the end or the specified number
        // this prevents index exceptions
        for (int i = 0; i < list.size() && i < number; i ++) {
            // check if the value divides evenly into the number
            if (number % list.get(i).intValue() == 0) {
                return i;
            }
        }
        // we only get here if no index was found
        return -1;
    }
}