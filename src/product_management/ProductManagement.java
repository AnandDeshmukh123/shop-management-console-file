package product_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement {
	static ArrayList<Product> al = new ArrayList<>();
	
	static {
		try {
			ReadDataFromTextFileIntoArrayList();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void productmanagement() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
		while(CanIKeepRunningTheProgram == true) {
			System.out.println("@@@@@@WELCOME TO DIGI_MART APPLICATION@@@@@@@");
			System.out.println("what would you like to do?");
			System.out.println("1. Add Product");
			System.out.println("2. Edit Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Search Product");
			System.out.println("5. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == p_Option.QUIT) {
				WriteDataTOTextFile();
				System.out.println("!!PROGRAM CLOSED!!");
				CanIKeepRunningTheProgram = false;
			}
			else if(OptionSelectedByUser == p_Option.ADD_PRODUCT) {
				Add_Product();
				System.out.println();
			}
			else if(OptionSelectedByUser == p_Option.EDIT_PRODUCT) {
				System.out.print("Enter the Product_Name which you want to Edit:");
				sc.nextLine();
				String ep = sc.nextLine();
				Edit_Product(ep);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == p_Option.SEARCH_PRODUCT) {
				System.out.print("Enter the Product_Name which you want to Search:");
				sc.nextLine();
				String sp = sc.nextLine();
				Search_Product(sp);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == p_Option.DELETE_PRODUCT) {
				System.out.print("Enter the Product_Name which you want to Delete:");
				sc.nextLine();
				String dp = sc.nextLine();
				Delete_Product(dp);
				System.out.println("\n");
			}	
		}
	}
	public static void WriteDataTOTextFile() throws IOException {
		File file = new File("C:\\Users\\ANAND DESHMUKH\\eclipse-workspace\\ShopManagement\\src\\product_management\\Products.csv");
		
		FileWriter fw = new FileWriter(file,false);
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Product p:al) {
			bw.write(p.ProductName+",");
			bw.write(p.ProductID+",");
			bw.write(p.Price+",");
			bw.write(p.Quantity+",");
			bw.write(p.Category+",");
			bw.newLine();
		}
		bw.close();
		fw.close();
		file = null;
	}
	public static void ReadDataFromTextFileIntoArrayList() throws IOException {
		File file = new File("C:\\Users\\ANAND DESHMUKH\\eclipse-workspace\\ShopManagement\\src\\product_management\\Products.csv");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String data = br.readLine();
		
		while(data != null) {
			String[] ArrayOfData = data.split(",");
			
			Product p = new Product();
			p.ProductName = ArrayOfData[0];
			p.ProductID = ArrayOfData[1];
			p.Price = ArrayOfData[2];
			p.Quantity = ArrayOfData[3];
			p.Category = ArrayOfData[4];
			
			al.add(p);
			data = br.readLine();
			
		}
		br.close();
		fr.close();
	}

	
	public static void Add_Product() {
		Scanner sc = new Scanner(System.in);
		Product p = new Product();
		
		System.out.print("Enter Product_Name :");
		p.ProductName = sc.nextLine();
		
		System.out.print("Enter Product_ID :");
		p.ProductID = sc.nextLine();
		
		System.out.print("Enter Price :");
		p.Price = sc.nextLine();
		
		System.out.print("Enter Quantity :");
		p.Quantity = sc.nextLine();
		
		System.out.print("Enter Category :");
		p.Category = sc.nextLine();
		
		System.out.println("\n");
		System.out.println("Product_Name is :"+p.ProductName);
		System.out.println("Product_ID is :"+p.ProductID);
		System.out.println("Price is : "+p.Price);
		System.out.println("Quantity is :"+p.Quantity);
		System.out.println("Category is :"+p.Category);
		
		al.add(p);
	}
	public static void Edit_Product(String ProductName) {
		for(Product p:al) {
			if(p.ProductName.equalsIgnoreCase(ProductName)) {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter Edit ProductName:"+p.ProductName);
				
				System.out.print("New Product_Name is :");
				p.ProductName = sc.nextLine();
				
				System.out.print("New Product_ID is :");
				p.ProductID = sc.nextLine();
				
				System.out.print("New Price is :");
				p.Price = sc.nextLine();
				
				System.out.print("New Quantity is :");
				p.Quantity = sc.nextLine();
				
				System.out.print("New Category is :");
				p.Category = sc.nextLine();
				
				System.out.println("Product Information Updated");
				return;
			}
		}
		System.out.println("!!!!Product NOT FOUND!!!!!");
		
	}
	public static void Search_Product(String ProductName) {
		for(Product p:al) {
			if(p.ProductName.equalsIgnoreCase(ProductName)) {
				System.out.println("Product_Name is :"+p.ProductName);
				System.out.println("Product_ID is :"+p.ProductID);
				System.out.println("Price is : "+p.Price);
				System.out.println("Quantity is :"+p.Quantity);
				System.out.println("Category is :"+p.Category);
				return;
			}
		}
		System.out.println("!!!! Product NOT FOUND !!!!");
	}
	public static void Delete_Product(String ProductName) {
		Iterator<Product> itr = al.iterator();
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.ProductName.equalsIgnoreCase(ProductName)) {
				itr.remove();
				System.out.println("Product "+p.ProductName+" has been deleted");
				break;
			}
		}
	}
	public static boolean ValidateProductNameAndID(String ProductName,String ProductID ){
		Iterator<Product> itr = al.iterator();
		
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.ProductName.equalsIgnoreCase(ProductName) && p.ProductID.equalsIgnoreCase(ProductID)) {
				return true;
			}
		}
		return false;
	}
}