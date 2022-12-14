package entrepise_data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class exo2 {

	final static String URL ="jdbc:postgresql://localhost:5432/postgres";
	final static String LOGIN = "postgres";
	final static String PASSWORD = "Amir";
	
	public static Connection log() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			// creat statement 
			
			Statement statement = connect.createStatement();
			
			//execute statement 
			ResultSet resultSet = statement.executeQuery("select * from emp");
			{ 
				while(resultSet.next()) {
					int noemp = resultSet.getInt("noemp");
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String emploi = resultSet.getString("emploi");
					int sup = resultSet.getInt("sup");
					Date embauche = resultSet.getDate("embauche");
					int sal = resultSet.getInt("sal");
					int noserv = resultSet.getInt("noserv");

					System.out.println(noemp +" ,"+nom+",  "+prenom+" , "+emploi+" , "+
					sup+" , "+embauche+" , "+sal+"  "+" , "+noserv);
				}
			}
			
			connect.close();
		    }
		
		catch (SQLException e) {
			System.out.println("Connection Failed try again.....");
			e.printStackTrace();
		} 
		return connect;
	}


}
