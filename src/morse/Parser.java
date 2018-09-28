package morse;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

	static HashMap<Character, String> map = new HashMap<Character, String>();

	public Parser() {
		
		char[] abcd = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		String[] morse = build(abcd);
		
		for (int i = 0; i <= abcd.length - 1; i++) {
			map.put(abcd[i], morse[i]);
		}	
	}
	
	private String[] build(char[] abcd) {
		
		String[] result = new String[36];
		
		for (int i = 0; i < 5; i++) {
			char[] code = {'_', '_', '_', '_', '_'};
			char[] ncode = {'.', '.', '.', '.', '.'};
			
			for (int j = i; j >= 0; j--) {
				code[j] = '.';
				ncode[j] = '_';
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
		
		for (char c : abcd) {
			;
		}
		
		return result;
	}

	public String getMorse(String text) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (char letter : text.toCharArray()) {
			if (letter == ' ') {
				result.add("  ");
			}else {
				result.add(map.get(letter));
			}
		}
		return clean(result);
	}

	public String getNoMorse(String text) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (char signal : text.toCharArray()) {
			switch (signal) {
				case '.':
					;
				case '_':
					;
				case ' ':
					;
			}
		}
		return clean(result);
	}
	
	private static String clean(ArrayList<String> temp) {
		
		String result = temp.toString();
		
		result = result.replace("[", "");
		result = result.replace("]", "");
		result = result.replace(",", "");
		
		return result;
	}

}
