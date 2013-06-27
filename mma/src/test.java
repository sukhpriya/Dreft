import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import java.sql.*;


public class test extends JFrame{

    public static void main(String[] args) throws SQLException{
        
    	JFrame frame = new test();
        frame.setSize(325, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tabbelen overzicht");
        frame.setVisible(true);    
        
        String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
		    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
		    p.add(l);
		    JTextField textField = new JTextField(10);
		    l.setLabelFor(textField);
		    p.add(textField);
		}
		/*
		SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		*/
		frame.setContentPane(p);
        
    }
}