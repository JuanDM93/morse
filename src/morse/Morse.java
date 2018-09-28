package morse;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Morse{
	
	private static String read(File file) {
		/*
		 Lee archivo y adapta segun el tipo
		 */
		String texto = "";
		try {
			FileReader read = new FileReader(file);
			Scanner scan = new Scanner(read);
			
			if (!scan.hasNext("-")) {

				scan.reset();
				scan.useDelimiter("  ");
				while (scan.hasNext() == true) {
					texto += scan.next();
					texto += " ";
				}
			}
			else {				
				scan.reset();
				while (scan.hasNext() == true) {
					texto += scan.next();
					texto += "*";
				}
			}
			scan.close();						
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}		
		return texto;
	}
	
	private static void writeFile(String text, String name) {
		/*
		 Crea nuevo archivo con nombre 'test.txt'
		 */
		try {
			File file = new File(name);
			FileWriter fr = new FileWriter(file);
            fr.write(text);
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
				
		Parser morse = new Parser();
		
		String name = "test.txt";
		
		try {
			File file = new File(args[0]);
			
			String result = read(file);
			
			String translated = "";
			
			if (result.contains("-")) {
				translated = morse.getNoMorse(result);
			}
			else {
				translated = morse.getMorse(result);
			}
			
			writeFile(translated, name);
		}
		catch (Exception ex) {
			System.out.println("No input given. Goodbye!");;
		}
		
		/* Texto a Morse
		
		File filePlain = new File("src/testPlain.txt");
				
		String result = read(filePlain);
				
		String translated = morse.getMorse(result);

		System.out.println(translated);
		
		// Crea nuevo archivo
		//writeFile(translated, name);
		*/
		
		/* Morse a texto
		
		File fileMorse = new File("src/testMorse.txt");

		result = read(fileMorse);
		
		translated = morse.getNoMorse(result);
		
		System.out.println(translated);
		
		// Crea nuevo archivo
		//writeFile(translated, name);		 
		 */
	}

}
