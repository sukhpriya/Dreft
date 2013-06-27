import java.awt.FlowLayout;
import javax.swing.*;


public class Error extends JFrame {
	
	public Error(String message){
		super("ERROR");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JOptionPane.showMessageDialog(null, "Error:["+message+"]");
		
	}
	
}