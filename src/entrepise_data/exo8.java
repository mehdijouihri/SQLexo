package entrepise_data;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class exo8 {
	//Afficher à l’écran les noms, emploi, salaire, numéro de service de tous les employés du service saisi par
	//l’utilisateur et qui gagnent plus d’un salaire saisi par l’utilisateur
	
	final static String URL ="jdbc:postgresql://localhost:5432/postgres";
	final static String LOGIN = "postgres";
	final static String PASSWORD = "Amir";
	
	public static Connection exo8() {
		
		Connection connect = null;

		try {

			connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			// creat statement 
			
			Statement statement = (Statement) connect.createStatement(); 
			
			Scanner sc = new Scanner(System.in);
			System.out.print("saisire le service   :");
			String service = sc.next().toUpperCase();
			System.out.print("saisire le salaire   :");
			int salaire = sc.nextInt();
			
			//execute statement 
			
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery("SELECT * FROM emp INNER JOIN serv on emp.noserv = serv.noserv where service = '" + service + "' AND  sal >= " + salaire );

			{ 
				while(resultSet.next()) {
					int noemp = resultSet.getInt("noemp");
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String emploi = resultSet.getString("emploi");
					int sup = resultSet.getInt("sup");
					String embauche = resultSet.getString("embauche");
					int sal = resultSet.getInt("sal");
					
					System.out.println(noemp +" ,"+nom+",  "+prenom+" , "+emploi+" , "+sal+"  "+emploi+" , ");
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
