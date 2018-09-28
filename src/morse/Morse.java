package morse;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Morse{
	
	private static String readPlain(File file) {
		/*
		 Lee archivo normal
		 */
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
		/*
		 Lee archivo morse y adapta la salida
		 */
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
		/*
		 Crear nuevo archivo con nombre 'test.txt'
		 */
		try {
			File file = new File("test.txt");
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
		
		
		// Morse a texto
		
		File fileMorse = new File("testMorse.txt");

		result = readMorse(fileMorse);
		
		translated = morse.getNoMorse(result);
		
		System.out.println(translated);
		
		
		// Crea nuevo archivo
		// writeFile(translated);
	}

}
