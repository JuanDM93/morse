package morse;

import java.io.*;
import java.util.Scanner;

public class Morse{
	
	private static String readPlain(File file) {
		
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
	
	private static String readMorse(File file) {
		
		String texto = "";
		try {
			FileReader read = new FileReader(file);
			Scanner scan = new Scanner(read);
			scan.useDelimiter("  ");
				
			while (scan.hasNext() == true) {
				texto += scan.next();
				texto += "*";
			}
			scan.close();						
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}	
		return texto;
	}

	private static void writeFile(String text) {
		try {
			File file = new File("test0.txt");				//// TESTING
			FileWriter fr = new FileWriter(file);
            fr.write(text);
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
				
		Parser morse = new Parser();
		
		// Texto a Morse
		
		File filePlain = new File("testPlain.txt");
				
		String result = readPlain(filePlain);
				
		String translated = morse.getMorse(result);
		
		System.out.println(translated);

		//writeFile(translated);
		
		
		// Morse a texto
		
		File fileMorse = new File("testMorse.txt");

		result = readMorse(fileMorse);
		
		translated = morse.getNoMorse(result);
		
		System.out.println(translated);
		
		//writeFile(translated);
	}

}
