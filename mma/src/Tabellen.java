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


public class Tabellen extends JFrame{

    public static void main(String[] args) throws SQLException{
        
    	JFrame frame = new Tabellen();
        frame.setSize(325, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tabbelen overzicht");
        
        JPanel panel = new Knopjes();
        frame.setContentPane(panel);
        frame.setVisible(true);    
        
    }
}

class Knopjes extends JPanel{
    private JButton knop1, knop2, knop3;
    public Knopjes() throws SQLException{
    	
    	Database db = new Database();
    	
    	ResultSet result = db.query("SHOW TABLES;");
    	
    	int limit = 100;
    	
    	JButton[] array = new JButton[limit];
    	JPanel buttons = new JPanel(new GridLayout(0,1,4,4));
    	
    	int q = 0;
    	while(result.next()){
    		q++;
    		
    		if(q > limit){
    			Error error = new Error("Er kunnen niet meer dan " +limit+ " Tabbelen worden geladen!");
    			break;
    		}
			String naam = result.getString(1);
			
			array[q] = new JButton(naam);
			array[q].addActionListener(new Handler(naam));
			buttons.add(array[q]);
		}

        buttons.setBorder( new TitledBorder("Tabellen") );
        add( buttons );
        
    }
    
    class Handler implements ActionListener{
        private String naam;
        
        public Handler(String naam){
        	this.naam = naam;
        }
    	
    	public void actionPerformed(ActionEvent e){
        	Error error = new Error("test knopje: " + naam);
        }
    }
}