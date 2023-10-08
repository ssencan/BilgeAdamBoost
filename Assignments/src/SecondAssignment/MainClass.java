package SecondAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter input");
		String word = scn.nextLine();
		// zip(word);
		// zip1(word);
		// zip2(word);
		letterCount(word);

	}

	// 2.soru Zipleme sorusu ArrayList ile
	public static void zip(String input) {
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			char currentLetter = input.charAt(i);
			if (list.contains(currentLetter) != true) {
				list.add(currentLetter);
			}
		}
		for (Character character : list) {
			System.out.print(character);
		}
	}

	// 2.soru Zipleme sorusu HashSet ile
	public static void zip1(String input) {
		LinkedHashSet<Character> list = new LinkedHashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		for (Character character : list) {
			System.out.print(character);
		}
	}

	// 2.soru Zipleme sorusu HashMap ile
	public static void zip2(String input) {
		LinkedHashMap<Integer, Character> list = new LinkedHashMap<Integer, Character>();
		for (int i = 0; i < input.length(); i++) {
			char currentLetter = input.charAt(i);
			if (list.containsValue(currentLetter) != true) {
				list.put(i, currentLetter);
			}
		}
		for (Entry<Integer, Character> entry : list.entrySet()) {
			System.out.print(entry.getValue());

		}
	}

	// 1.soru
	public static void letterCount(String input) {
		LinkedHashMap<Character, Integer> list = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			int count = 0;
			char currentLetter = input.charAt(i);
			for (int j = 0; j < input.length(); j++) {
				if (currentLetter == input.charAt(j)) {
					count++;
				}
			}
			// Hashmapte keyi character yaparak burda fazladan bir if şartı yazmaktan
			// kurtulduk.Tekrar eden harfi yazmıyor.
			list.put(currentLetter, count);
		}
		for (Entry<Character, Integer> entry : list.entrySet()) {
			System.out.print(entry.getKey() + "" + entry.getValue() + "");

		}
	}

	// 1.soru alternatif
//	public static void letterCount(String input) {
//	    LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
//
//	    for (int i = 0; i < input.length(); i++) {
//	        char currentLetter = input.charAt(i);
//
//	        // LinkedHashMap'te keyi karakter yaparak aynı işlemi yapabiliriz
//	        charCount.put(currentLetter, charCount.getOrDefault(currentLetter, 0) + 1);
//	    }
//
//	    for (Entry<Character, Integer> entry : charCount.entrySet()) {
//	        System.out.print(entry.getKey() + "" + entry.getValue() + "");
//	    }
//	}

}
