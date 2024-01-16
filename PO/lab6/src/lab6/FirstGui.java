package lab6.src.lab6;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FirstGui {
	
	private static JTextField textField;
	
    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
         
        JPanel jp = new JPanel(new GridBagLayout());
        
        JTextField textField = new JTextField("0");
        textField.setFont(new Font("Arial", Font.BOLD, 16));  
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jp.add(textField, gbc);
        
        
        //BUTTONS
        String chars_array[] = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};

        int buttonsPerRow = 4;
        int rowIndex = 1;
        int colIndex = 0;
        for (int i = 0; i < chars_array.length; i++) {
        	JButton button = new JButton(chars_array[i]); 
        	button.addActionListener(new MyActionListener());
        	
        	gbc = new GridBagConstraints();
            gbc.gridx = colIndex;
            gbc.gridy = rowIndex;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            jp.add(button, gbc);

            colIndex++;
            if (colIndex >= buttonsPerRow) {
                colIndex = 0;
                rowIndex++;
            }
        }

        jf.getContentPane().add(jp);


        
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
    }
    
    static class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.equals("=")) {
                // Dodaj logikę dla przycisku "="
            } else if (buttonText.equals("C")) {
                textField.setText("0");  // Zresetuj wartość na "0"
            } else {
                if (textField.getText().equals("0")) {
                    textField.setText(buttonText);
                } else {
                    textField.setText(textField.getText() + buttonText);
                }
            }
        }
    }

	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }

}