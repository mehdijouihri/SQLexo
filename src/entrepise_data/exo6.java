package entrepise_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class exo6 {
	
	// Afficher à l’écran la liste des employés dont la date d’embauche est comprise dans l’année saisie par
	// l’utilisateur	
	
	final static String URL ="jdbc:postgresql://localhost:5432/postgres";
	final static String LOGIN = "postgres";
	final static String PASSWORD = "Amir";
	public static Connection exo6() {
		
		Connection connect = null;

		try {

			connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			// creat statement 
			
			Statement statement = connect.createStatement(); 
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Date embauche     :");
			int xdate = sc.nextInt();
			
			//execute statement 
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM emp where EXTRACT (YEAR from embauche) = '" +xdate+ "'");	
			{ 
				while(resultSet.next()) {
					int noemp = resultSet.getInt("noemp");
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String emploi = resultSet.getString("emploi");
					int sup = resultSet.getInt("sup");
					String embauche = resultSet.getString("embauche");
					int sal = resultSet.getInt("sal");
					int noserv = resultSet.getInt("noserv");

					System.out.println(noemp +" ,"+nom+",  "+prenom+" , "+emploi+" , "+
					sup+" , "+embauche+" , "+sal+"  "+" , ");
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
