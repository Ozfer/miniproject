/*Group Project Java 2
Feb 2017
Main class that builds the windows and will validate moves
at least two more threads need to be made one for each player
button functions need to be added
move validation needs to be added
this would be VERY easy to make larger say 100x100 if need be
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class Tron implements ActionListener{
   
    public int gameStatus = 0; // 0 = not running 1 = game running
    

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] squares = new JButton[64][64]; //jbutton array for tiles
    private JPanel gameSquares; //jpanel that holds tiles

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
        JButton jbStart = new JButton("Start");
        JButton jbClear = new JButton("Clear");
        JButton jbExit = new JButton("Exit");
        tools.add(jbStart); //  add functionality
        jbStart.addActionListener(this);
        tools.add(jbClear); //  add functionality
        jbClear.addActionListener(this);
        tools.add(jbExit); //  add functionality
        jbExit.addActionListener(this);
        tools.addSeparator();


         //adds squares to the panel and sets the outline of the board to black       
        gameSquares = new JPanel(new GridLayout(0, 64));
        gameSquares.setBorder(new LineBorder(Color.BLACK));
        gui.add(gameSquares);

        // create the squares horizontally and makes them white 32x32 pixels
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < squares.length; ii++) {
            for (int jj = 0; jj < squares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(6, 6, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setBackground(Color.WHITE);
                b.setEnabled(false);
        
                squares[jj][ii] = b;
            }
        }


        // fill in vertical rows
        for (int ii = 0; ii < 64; ii++) {
            for (int jj = 0; jj < 64; jj++) {
                
                        gameSquares.add(squares[jj][ii]);
                
            }
        }
    }



    public final JComponent getGui() {
        return gui;
    }
    public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Exit")){
            System.exit(0);
            }
            if(e.getActionCommand().equals("Clear")){
            gameStatus = 0;
            
            }
            if(e.getActionCommand().equals("Start")){
            
            if(gameStatus == 1){
            return;
            }
            
            gameStatus = 1;
            
            
            
            }
     
                
        }
    public class Player1 implements Runnable {
    public void run(){
    System.out.println("hello");
    }
    
    }
    public class Player2 implements Runnable {
    public void run(){
    System.out.println("hello 2");
    }
    
    }



}