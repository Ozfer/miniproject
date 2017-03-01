/*Group Project Java 2
Ryan Brenek
Feb 2017
Main class that builds the windows and will validate moves
at least two more threads need to be made one for each player
button functions need to be added
move validation needs to be added
this would be VERY easy to make larger say 100x100 if need be
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class Tron {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] squares = new JButton[16][16];
    private JPanel gameSquares;

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Tron cb = new Tron();

                JFrame f = new JFrame("Tron");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size possible
                f.pack();
                // ensures the minimum size is enforced
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
    
    Tron() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        
        //adds in blank space around the board
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        //adds in toolbar
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("Start")); //  add functionality
        tools.add(new JButton("Clear")); //  add functionality
        tools.add(new JButton("Exit")); //  add functionality
        tools.addSeparator();


         //adds squares to the panel and sets the outline of the board to black       
        gameSquares = new JPanel(new GridLayout(0, 16));
        gameSquares.setBorder(new LineBorder(Color.BLACK));
        gui.add(gameSquares);

        // create the squares horizontally and makes them white 32x32 pixels
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < squares.length; ii++) {
            for (int jj = 0; jj < squares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setBackground(Color.WHITE);
        
                squares[jj][ii] = b;
            }
        }


        // fill in vertical rows
        for (int ii = 0; ii < 16; ii++) {
            for (int jj = 0; jj < 16; jj++) {
                
                        gameSquares.add(squares[jj][ii]);
                
            }
        }
    }



    public final JComponent getGui() {
        return gui;
    }


}