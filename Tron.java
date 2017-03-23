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
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

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
                        new BufferedImage(4, 4, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                //b.setBackground(Color.RE);
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
            try{
            Thread.sleep(1000);
            }catch(Exception de){}

            for(int i = 0; i < 64; i++){
              for(int c = 0; c < 64; c++){
              squares[i][c].setBackground(Color.WHITE);
              }
            }
            
            
            }
            if(e.getActionCommand().equals("Start")){
            gameStatus = 1;
            Player1 P1 = new Player1();
            Player2 P2 = new Player2();
            //if(gameStatus == 1){
               
               P1.start();
               P2.start();
                              
       
               
               //Player2.start();
               //if(Player1= true){squares[4][32].setBackground(Color.RED);}
              // squares[4][32].setBackground(Color.RED);
              // squares[59][32].setBackground(Color.BLUE);
            //}
            if(gameStatus == 1){
            return;
            }
                        
            
            }
     
                
        }
    public class Player1 extends Thread {
    public void run(){
    System.out.println("hello");
    //squares[4][32].setBackground(Color.RED);
    int a = 4;
    int b = 32;
    while(true){
      if(gameStatus == 1){
      try{
      Thread.sleep(250);
      }catch(Exception e){
      }
      //for(int a=4;a>-1;a++){
      //      a = a+ 0;
      //      squares[a][b].setBackground(Color.RED);
      //  }
      squares[a][b].setBackground(Color.RED);      
      a = a+1;
      //squares[a][b].setBackground(Color.RED);

       if(a < 0 || b < 0 || a >=64 || b >=64){
       gameStatus = 0;
        JOptionPane.showMessageDialog(null, "Red wins!", "Winner!",
                                    JOptionPane.ERROR_MESSAGE);
       }
      } 
    } 
    }
     
    }
    public class Player2 extends Thread {
    public void run(){
    System.out.println("hello 2");
    //squares[59][32].setBackground(Color.BLUE);
    int c = 59;
    int d = 32;
      while(gameStatus == 1){
       try{
       Thread.sleep(250);
       }catch(Exception e){}

       squares[c][d].setBackground(Color.BLUE);
       c--;

       if(c < 0 || d < 0 || c >=64 || d >=64){
       gameStatus = 0;
       JOptionPane.showMessageDialog(null, "Red wins!", "Winner!",
                                    JOptionPane.ERROR_MESSAGE);
       
       }
      }
    
    }
    
    }

}