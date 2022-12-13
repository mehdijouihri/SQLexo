package entrepise_data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;


public class Entreprise_Connect {

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

	
// Afficher à l’écran la liste des employés du service 5
	
public static Connection exo3() {
	Connection connect = null;
	try {
		connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
		// creat statement 
		
		Statement statement = connect.createStatement();
		
		//execute statement 
		ResultSet resultSet = statement.executeQuery("select * from emp where noserv=5");
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
	
// Afficher à l’écran la liste des employés du service INFORMATIQUE

public static Connection exo4() {
Connection connect = null;
try {
	connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
	// creat statement 
	
	Statement statement = connect.createStatement(); 
	
	//execute statement 
	ResultSet resultSet = statement.executeQuery("select * from emp INNER JOIN serv ON emp.noserv =serv.noserv WHERE service='INFORMATIQUE'");
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
			String  service = resultSet.getString("service");

			System.out.println(noemp +" ,"+nom+",  "+prenom+" , "+emploi+" , "+
			sup+" , "+embauche+" , "+sal+"  "+" , "+service);
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


//Afficher à l’écran la liste des employés dont le nom est saisi par l’utilisateur

public static Connection exo5() {
	
Connection connect = null;

try {


	connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
	// creat statement 
	
	Statement statement = connect.createStatement(); 
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Nom employé    :");
	String xnom = sc.next().toUpperCase();
	
	//execute statement 
	
	ResultSet resultSet = statement.executeQuery("select * from emp where nom ='"+xnom+"'");	
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

//Afficher à l’écran la liste des employés dont la date d’embauche est comprise dans l’année 
//saisie par l’utilisateur
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

//Afficher à l’écran la liste des employés dont le nom contient une chaîne de caractères saisie par l’utilisateur

public static Connection exo7() {
	
Connection connect = null;

try {

	connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
	// creat statement 
	
	Statement statement = connect.createStatement(); 
	
	Scanner sc = new Scanner(System.in);
	System.out.print("saisire un mot   :");
	String snom = sc.next().toUpperCase();
	
	//execute statement 
	
	ResultSet resultSet = statement.executeQuery("SELECT * FROM emp WHERE nom LIKE '%"+snom.toUpperCase()+"%'");	
	{ 
		while(resultSet.next()) {
			int noemp = resultSet.getInt("noemp");
			String nom = resultSet.getString("nom");
			String prenom = resultSet.getString("prenom");
			String emploi = resultSet.getString("emploi");
			int sup = resultSet.getInt("sup");
			String embauche = resultSet.getString("embauche");
			int sal = resultSet.getInt("sal");
			
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