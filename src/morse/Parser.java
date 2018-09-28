package morse;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
	
	// Mapa principal morse
	private static HashMap<Character, String> map = new HashMap<Character, String>();

	public Parser() {
		/*
		 Construye un parser con el mapa actualizado
		 */
		char[] nums = "1234567890".toCharArray();
		
		String[] morse = build();
		
		for (int i = 0; i <= nums.length - 1; i++) {
			map.put(nums[i], morse[i]);
		}	
	}
	
	private String[] build() {
		// Fancy math numerals morse
		String[] result = new String[36];
		
		for (int i = 0; i < 5; i++) {
			char[] code = {'-', '-', '-', '-', '-'};
			char[] ncode = {'.', '.', '.', '.', '.'};
			
			for (int j = i; j >= 0; j--) {
				code[j] = '.';
				ncode[j] = '-';
			}
			
			String temp = "";
			for (char c : code) {
				temp += c;
			}
			result[i] = temp;
			
			temp = "";
			for (char c : ncode) {
				temp += c;
			}
			result[i + 5] = temp;
		}
		
		// Trampa mortal 4
		map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");
        
        return result;
	}

	public String getMorse(String text) {
		/*
		 Metodo para traducir de texto a morse
		 */
		ArrayList<String> result = new ArrayList<String>();
		
		for (char letter : text.toCharArray()) {
			if (letter == ' ') {
				result.add(" ");
			}else {
				result.add(map.get(
						Character.toLowerCase(letter)
						));
			}
		}
		return clean(result);
	}

	public String getNoMorse(String text) {
		/*
		 Metodo para traducir de morse a texto
		 */
		ArrayList<Character> result = new ArrayList<Character>();
		String code = "";
		
		for (Character signal : text.toCharArray()) {
						
			if (signal.equals('*')) {
				result.add(
						findLetter(code)
						);
				result.add('*');
				code = "";
			}
			if (signal.equals(' ')) {
				result.add(
						findLetter(code)
						);
				code = "";
			}
			else {
				code += signal;
			}
		}	
		return cleanChar(result);
	}

	
	private char findLetter(String code) {
		// Trampa mortal
		String test = "";
		for (char c : map.keySet()) {
			test = map.get(c);
			if (test.equals(code)) {
				return c;
			}
		}
		return ' ';
	}

	private static String cleanChar(ArrayList<Character> temp) {
		/*
		 Adaptacion de salida morse
		 */
		String result = temp.toString();
		
		result = result.replace(",", "");
		result = result.replace("[", "");
		result = result.replace("]", "");
		result = result.replace("*", "");
		result = result.replace("  ", " ");
		
		return result;
	}
	
	private static String clean(ArrayList<String> temp) {
		/*
		 Adaptacion de salida normal
		 */
		return temp.toString().replace("[", "").replace("]", "").replace(",", "");
	}

}
