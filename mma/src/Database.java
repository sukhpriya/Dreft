import java.sql.*;

public class Database {
	private String username;
	private String password;
	private String database;
	private String adres;
	private Connection con;
	
	public Database(){
		username = "root";
		password = "usbw";
		database = "java";
		adres = "localhost:3307";
	}
	
	public Database(String username, String password, String database, String adres){
		this.username = username;
		this.password = password;
		this.database = database;
		this.adres = adres;
	}
	
	private void get_con() throws SQLException{
		con = DriverManager.getConnection("jdbc:mysql://"+ adres +"/"+ database, username, password);
	}
	
	private void close_con() throws SQLException{
		con.close();
	}
	
	public ResultSet query(String query){
		ResultSet data = null;
		
		try {
			get_con();
			PreparedStatement statement = con.prepareStatement(query);
			data = statement.executeQuery();
		} catch (SQLException e) {
			Error error = new Error("Fout in query of connectie");
		}
		
		return data;
	}
	
}