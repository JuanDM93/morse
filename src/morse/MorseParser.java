package morse;

import java.io.*;
import java.util.Scanner;

public class MorseParser {
	
	private static String readFile(File file) {
		
		String texto = "";
		try {
			FileReader read = new FileReader(file);
			Scanner scan = new Scanner(read);
				
			while (scan.hasNext() == true) {
				texto += scan.next();
				texto += " ";
			}
			scan.close();						
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}		
		return texto;
	}

	public static void main(String[] args) {
				
		File file = new File("testPlain.txt");
		
		String result = readFile(file);
		
		Parser morse = new Parser();
				
		String translated = (result.contains(".")) ? morse.getNoMorse(result) : morse.getMorse(result);
		
		System.out.println(translated);
	}

}
