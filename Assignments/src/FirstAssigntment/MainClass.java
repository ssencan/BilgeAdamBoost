//ŞÜKRÜ ŞENCAN
package FirstAssigntment;

import java.util.Iterator;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		// Alttaki son soru için çağırma.
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scn.nextLine();
		String newName = replaceLetter(name);
		System.out.println(newName);
	// 2.soru için çağırma.
		reverseMatrix();

		// Üstteki ilk soru için çağırma
		Scanner scn1 = new Scanner(System.in);
		System.out.println("Enter word");
		String word = scn1.nextLine();
		System.out.println("Enter number");
		int number = scn1.nextInt();
		String newWord = deleteLetter(word, number);
		System.out.println(newWord);
		scn.close();
		scn1.close();

	}

	// Alttaki son soru
	public static String replaceLetter(String input) {
		char[] vowels = { 'A', 'a', 'E', 'e', 'I', 'ı', 'İ', 'i', 'O', 'o', 'Ö', 'ö', 'U', 'u', 'Ü', 'ü' };
		char[] numbers = { '1', '1', '2', '2', '3', '3', '4', '4', '5', '5', '6', '6', '7', '7', '8', '8' };

		for (int i = 0; i < vowels.length; i++) {
			input = input.replace(vowels[i], numbers[i]);
		}

		return input;
	}

	// 2.soru
	
	
	public static void reverseMatrix() {
		String[][] matrix = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				System.out.print(matrix[i][j] + " ");				
			}
			System.out.println();
		}
	}
	
	/*
	public static void reverseMatrix() {
		String[][] matrix = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}
*/

	// Üstteki ilk soru
	public static String deleteLetter(String word, int number) {
		char[] newWord = new char[word.length()];
		int arrayIndex = 0;
		for (int i = 0; i < word.length(); i++) {
			int count = 0;
			char currentLetter = word.charAt(i);
			for (int j = 0; j < word.length(); j++) {
				if (currentLetter == word.charAt(j)) {
					count++;
				}
			}
			if (count < number) {
				newWord[arrayIndex] = currentLetter;
				arrayIndex++;
			}
		}
		return new String(newWord, 0, arrayIndex);// char dizisini stringe dönüştürme
	}

}
