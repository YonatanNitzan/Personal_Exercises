package games;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
class Factman_GUI extends JFrame {
    static JPanel panel;
    static JMenuBar menubar;
    static JCheckBoxMenuItem hideBoard;
    static JLabel p1ScoreLabel, p2ScoreLabel, turnIndicator, gameAreaLabel;
    static String userInput;
    static int userSelection = -1;
    static boolean newGameFlag = false;

    public Factman_GUI() {
        initGUI();
    }

    private void initGUI() {
        panel = new JPanel(new GridBagLayout());
        add(panel);

        // Generate the menu at the top of the window
        createMenu();

        //////////////////////////////////////////////////
        // First row, score labels
        // Score values will split all extra space evenly
        //
        GridBagConstraints c = new GridBagConstraints();
        JLabel p1Label = new JLabel("Player 1 Score:  ");
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(p1Label, c);

        c = new GridBagConstraints();
        p1ScoreLabel = new JLabel("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        panel.add(p1ScoreLabel, c);

        c = new GridBagConstraints();
        JLabel p2Label = new JLabel("Player 2 Score:  ");
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 2;
        c.gridy = 0;
        panel.add(p2Label, c);

        c = new GridBagConstraints();
        p2ScoreLabel = new JLabel("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 0.5;
        panel.add(p2ScoreLabel, c);

        //////////////////////////////////////////////////
        // Second row, main content area.
        // This spans all 4 columns and 2 rows
        //
        c = new GridBagConstraints();
        JPanel gameArea = new JPanel();
        gameArea.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.gridheight = 2;
        c.weighty = 1;
        panel.add(gameArea, c);

            c = new GridBagConstraints();
            gameAreaLabel = new JLabel("");
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            gameArea.add(gameAreaLabel, c);

        //////////////////////////////////////////////////
        // Third row, input area
        // This row contains another panel with its own layout
        // The first row indicates whose turn it is,
        // the second row takes user input. The text
        // field will take up all extra space
        //
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 4;
        c.weightx = 1;
        panel.add(inputPanel, c);

            c = new GridBagConstraints();
            turnIndicator = new JLabel("It is Player 1's Turn");
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 4;
            inputPanel.add(turnIndicator, c);

            c = new GridBagConstraints();
            JLabel inputLabel = new JLabel("Enter your selection: ");
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 1;
            inputPanel.add(inputLabel, c);

            c = new GridBagConstraints();
            JTextField inputField = new JTextField();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 3;
            c.weightx = 1;
            inputField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    userInput = inputField.getText();
                    try {
                        userSelection = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.out.println("No number entered...");
                    }
                    System.out.println(userInput);
                    inputField.setText("");
                }
            });
            inputPanel.add(inputField, c);


        // Set basic window properties
        setTitle("Factman Game");
        setSize(600,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenu() {
        menubar = new JMenuBar();

        // Create the file menu
        JMenu filem = new JMenu("File");
        filem.setMnemonic(KeyEvent.VK_F);

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
            ActionEvent.CTRL_MASK));
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int response = JOptionPane.showConfirmDialog(
                    panel,
                    "You are about to start a new game.\n"+
                    "Your current game will be lost.",
                    "Confirm New Game",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                if (response == 0) newGameFlag = true;
            }
        });

        JMenuItem quit = new JMenuItem("Exit");
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
            ActionEvent.CTRL_MASK));
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        filem.add(newGame);
        filem.addSeparator();
        filem.add(quit);

        // create the view menu
        JMenu viewm = new JMenu("View");
        viewm.setMnemonic(KeyEvent.VK_V);

        hideBoard = new JCheckBoxMenuItem("Hide Game Board");
        hideBoard.setState(false);        
        viewm.add(hideBoard);

        // Create the help menu
        JMenu helpm = new JMenu("Help");
        helpm.setMnemonic(KeyEvent.VK_H);

        JMenuItem gameInstructions = new JMenuItem("How to Play");
        gameInstructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(
                    panel,
                    "<html>" +
                        "<p>Factman is a pretty simple game once you know the rules.<br>" +
                           "To play, each player will take turns selecting a number<br>" +
                           "from the list. The player will earn the number of points<br>" +
                           "equal to the number they selected. But be careful, if you<br>" +
                           "choose a number not in the list, you loose a turn!</p>" +
                        "<p></p>" +
                        "<p>When a player chooses a number, the other player will gain<br>" +
                           "the number of points for each of the factors in the list.<br>" +
                           "Any number that is used (selected or a factor) is removed<br>" +
                           "from the list.</p>" +
                        "<p></p>" +
                        "<p>The player with the highest score when the list is empty wins.</p>" +
                        "<p></p>" +
                        "<p>Good Luck!</p>" +
                    "</html>",
                    "How to Play",
                    JOptionPane.INFORMATION_MESSAGE);

            }
        });

        helpm.add(gameInstructions);        

        // Populate the menu bar
        menubar.add(filem);
        menubar.add(viewm);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(helpm);

        // Set the menu bar in the panel
        setJMenuBar(menubar);
    }
}