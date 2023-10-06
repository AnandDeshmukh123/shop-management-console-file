package shop_management;

import java.io.IOException;
import java.util.Scanner;
import product_management.ProductManagement;
import user_management.UserManagement;



public class ApplicationMain {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
		System.out.println("##### WELCOME TO SHOP MANAGEMENT #####");
		System.out.println("\n");
		System.out.println("Enter LoginName :");
		String ProductName = sc.nextLine();
		System.out.println("Enter Password :");
		String ProductID = sc.nextLine();
		
		if(!ProductManagement.ValidateProductNameAndID(ProductName, ProductID)) {
			System.out.println("!!!! LOGIN FAILED. CLOSE THE APPLICATION !!!!!!");
			return;
		}else {
			System.out.println("@@@@Login Successful@@@@");
		}
		while(CanIKeepRunningTheProgram == true) {
			System.out.println("@@@@@ WELCOME TO SHOP MANAGEMENT @@@@");
			System.out.println("\n");
			
			System.out.println("WHAT WOULD YOU LIKE TO DO");
			System.out.println("1. User Management");
			System.out.println("2. Product Management");
			System.out.println("5. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == 1) {
				UserManagement.UserManagement();
			}
			else if(OptionSelectedByUser == 2) {
				ProductManagement.productmanagement();
			}
			else if(OptionSelectedByUser == 5) {
				break;
			}	
		}	
	}

}