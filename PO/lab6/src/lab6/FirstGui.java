package lab6;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstGui {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        
        JPanel jp = new JPanel(new GridLayout(4, 4, 10, 10));         
        
        
        String chars_array[] = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};
        //BUTTONS
        for (int i = 0; i < chars_array.length; i++) {
        	JButton button = new JButton(chars_array[i]); 
        	jp.add(button);
        }

        jf.getContentPane().add(jp);

        //TEXT FIELD
        JLabel label1 = new JLabel("Test");

        
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
    }

	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }

}