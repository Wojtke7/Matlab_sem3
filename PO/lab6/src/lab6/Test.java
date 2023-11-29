package lab6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        
        JPanel jp = new JPanel(); 
        jf.getContentPane().add(jp);

        JButton jb = new JButton("Hello!");
        jp.add(jb);
        
        JButton jb2 = new JButton("How are you?");
        jp.add(jb2);
        
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
