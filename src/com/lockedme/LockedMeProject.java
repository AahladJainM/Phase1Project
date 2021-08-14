package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject {
	static final String folderpath = "D:\\AJMSimplilearn\\Phase1Project\\LockedMeFiles";

	public static void main(String[] args) {
		
		int proceed=1;
		do {
		
		// Variable Declaration
		Scanner obj = new Scanner(System.in);
		int ch;

		// Menu
		displayMenu();
		System.out.println("\nPlease enter your choice:");
		ch = Integer.parseInt(obj.nextLine());
		switch (ch) {
		case 1:
			getAllFiles();
			break;
		case 2:
			writeToFile();
			break;
		case 3:
			deleteFile();
			break;
		case 4:
			searchFile();
			break;
		case 5:
			System.exit(0);
		default:
			System.out.println("Invalid option entered");
		}
		}while(proceed>0);
		

	}

	public static void displayMenu() {
		System.out.println("==========================================");
		System.out.println("\t Company Lockers Pvt. Ltd.");
		System.out.println("\t\t Lockedme.com");
		System.out.println("==========================================");
		System.out.println("\n\t\t-:Main Menu:-");
		System.out.println("\n1. Display all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
	}

	// To get all the file names present in the folder
	public static void getAllFiles() {
		// To get all files

		List<String> filenames = FileManager.getAllFiles(folderpath);

		for (String f : filenames)
			System.out.println(f);

	}

	// To add and write a new file
	public static void writeToFile() {
		// Variable Declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();

		// Read file name from user
		System.out.println("Enter File Name");
		fileName = obj.nextLine();

		// Read number of lines from user
		System.out.println("Enter how many lines to add in the file:");
		linesCount = Integer.parseInt(obj.nextLine());

		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			content.add(obj.nextLine());
		}
		// save the entered content into the created file
		boolean isSaved = FileManager.writeToFile(folderpath, fileName, content);

		if (isSaved)
			System.out.println("File and data saved successfully");
		else
			System.out.println("Unable to save file. Please contact admin");
		

	}

	// To delete user specified file
	public static void deleteFile() {
		// Code for deleting file
		String filename = null;
		// Get file name from user
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted:");
		filename = obj.nextLine();

		// Delete operation
		boolean isDeleted = FileManager.deleteFile(folderpath, filename);

		// Output message
		if (isDeleted)
			System.out.println("File deleted Successfully");
		else
			System.out.println("Either file doesn't exist or some access issue");

	}

	// To search for user specified file
	public static void searchFile() {
		// Code for searching file
		String filename;
		// Get file name from user
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to search:");
		filename = obj.nextLine();

		// Search operation
		boolean isFound = FileManager.searchFile(folderpath, filename);

		// Output message
		if (isFound)
			System.out.println("File found in the folder");
		else
			System.out.println("File not found in the folder");

	}

}
