package entrepise_data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class exo9 {
	
	//Créer un menu (Console Java) permettant de :
	final static String URL ="jdbc:postgresql://localhost:5432/postgres";
	final static String LOGIN = "postgres";
	final static String PASSWORD = "Amir";
	
	public static Connection exo9() {
		
		Connection connect = null;

		try {

			connect = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			// creat statement 
			
			Statement statement = connect.createStatement(); 
			
			Scanner sc = new Scanner(System.in);
			System.out.println("< 1- List  >    < 2-  details >   <3-  Add > <4-  Modify >  <5 Delete >");
			System.out.print("saisire votre choix   :");
			int choix = sc.nextInt();
			
			//execute statement 
            
			
			if (choix == 1) {
				
				ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");
				while(resultSet.next()) {
					int noemp = resultSet.getInt("noemp");
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String emploi = resultSet.getString("emploi");
					int sup = resultSet.getInt("sup");
					Date embauche = resultSet.getDate("embauche");
					int sal = resultSet.getInt("sal");
					
					System.out.println(noemp +" ,"+nom+",  "+prenom+" , "+emploi+" , "+sal+"  "+emploi+" , ");
				}
			
			}
			else if (choix == 2) 
			{
				System.out.println("saisire le nom employe  :");
				String xnom = sc.next().toUpperCase();
				ResultSet resultSet = statement.executeQuery("select * from emp where nom ='"+xnom+"'");	
			
				while(resultSet.next()) {
					int noemp = resultSet.getInt("noemp");
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					String emploi = resultSet.getString("emploi");
					int sup = resultSet.getInt("sup");
					Date embauche = resultSet.getDate("embauche");
					int sal = resultSet.getInt("sal");
					
					System.out.println(+noemp +" ,"+nom+",  "+prenom+" , "+emploi+" , "+sal+"  "+emploi+" , ");
				}
			}
			else if (choix == 3) {
				System.out.println("numero employe   :");
				int xnoemp=sc.nextInt();
				System.out.println("Nom employe  :");
				String newnom = sc.next();
				System.out.println("Prenom  ");
				String xprenom = sc.next();
				System.out.println("emploi :  ");
				String xemploi = sc.next();
				System.out.println("supplement  ");
				int xsup=sc.nextInt();
				System.out.println("Date embauche  ");
				int xembauche=sc.nextInt();
				System.out.println("Salaire  ");
				int xsal = sc.nextInt();
				System.out.println("commision  ");
				int xcomm = sc.nextInt();
				System.out.println("numero de service   :");
				int xnoserv=sc.nextInt();
				
				
				Statement stmt =connect.createStatement();

				//ResultSet resultSet = statement.executeQuery("select * from emp ");			
				
				String insertion = "insert into emp (noemp,nom,prenom,emploi,sup,embauche,sal,comm,noserv) VALUES ("+xnoemp+",'" + newnom +"','"+xprenom+"','"+xemploi+"',"+xsup+","+xembauche+","+xsal+","+xcomm+","+xnoserv+")";			
					stmt.executeUpdate(insertion);
				

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
