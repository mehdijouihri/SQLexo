package entrepise_data;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Exercice 2----------------------------------------");
		System.out.println(" ");
		
		Connection connect = Entreprise_Connect.log();
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" ");		
		System.out.println("Exercice 3:----------------------------------------");
		System.out.println(" ");
		Entreprise_Connect.exo3();
		System.out.println(" ");
		System.out.println("Exercice 4:----------------------------------------");
		System.out.println(" ");
		Entreprise_Connect.exo4();
		System.out.println(" ");
		System.out.println("Exercice 5:----------------------------------------");
		System.out.println(" ");
		Entreprise_Connect.exo5();
		System.out.println(" ");
		System.out.println("Exercice 6:----------------------------------------");
		System.out.println(" ");
		Entreprise_Connect.exo6();
		System.out.println(" ");
		System.out.println("Exercice 7:----------------------------------------");
		System.out.println(" ");
		Entreprise_Connect.exo7();
		
	}
}

