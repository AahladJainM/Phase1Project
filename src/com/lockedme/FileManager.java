package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	/**
	 * This method will return File Names from the folder
	 * 
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath) {
		// Creating File Objects
		File f1 = new File(folderpath);

		// Getting all the files into FileArray
		File[] listOfFiles = f1.listFiles();

		// Declare a list to store file names
		List<String> filenames = new ArrayList<String>();

		for (File f : listOfFiles)
			filenames.add(f.getName());

		// return to list
		return filenames;

	}

	/**
	 * This method will create file and add content to File specified
	 * 
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean writeToFile(String folderpath, String fileName, List<String> content) {
		//Creating file in the folder
		try {
			File f1 = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(f1);
		//Entering content to the file
			for (String s : content) {
				fw.write(s + "\n");
			}
			fw.close();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}

	/**
	 * This method will delete the file name if it exists
	 * 
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderpath, String fileName) {
		// Adding folderpath with file name
		File file = new File(folderpath + "\\" + fileName);
		//Searching for the file to be deleted
		try {
			if (file.delete())
				return true;
			else {
				return false;
			}
		} catch (Exception Ex) {
			return false;
		}
	}

	/**
	 * This method will search for a specific file entered by user
	 * 
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath, String fileName) {
		// Adding folderpath with file name
		File file = new File(folderpath + "\\" + fileName);
		if (file.exists())
			return true;
		else {
			return false;
		}
	}
}
