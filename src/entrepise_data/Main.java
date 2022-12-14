package entrepise_data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
			
		Connection connect = Entreprise_Connect.log();
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Exeercice N°    :");
	        int nexo = sc.nextInt();
			
			switch (nexo) {
			
			case  2:
				
			System.out.println(" ");		
			System.out.println("----------------------------------------");
			Entreprise_Connect.exo2();
			break;	
			
			case 3:
				
			System.out.println("----------------------------------------");
			System.out.println(" ");
			Entreprise_Connect.exo3();
			System.out.println(" ");
		    break;
				
			case 4:		
			System.out.println("----------------------------------------");
			System.out.println(" ");
			Entreprise_Connect.exo4();
			System.out.println(" ");
			break;
			
			case 5:
			System.out.println("----------------------------------------");
			System.out.println(" ");
			Entreprise_Connect.exo5();
			break;
			
			case 6:
			System.out.println(" ");
			System.out.println("----------------------------------------");
			System.out.println(" ");
			Entreprise_Connect.exo6();
			break;
			
			case 7:
			System.out.println(" ");
			System.out.println("----------------------------------------");
			System.out.println(" ");
			Entreprise_Connect.exo7();
			break;
			
			case 8:
				System.out.println(" ");
				System.out.println("----------------------------------------");
				System.out.println(" ");
				Entreprise_Connect.exo8();
				break;
			
			}
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
