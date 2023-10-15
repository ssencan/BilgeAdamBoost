package FifthAssignment;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NKReader {
//	private String filePath;
//
//	public NKReader(String filePath) {
//		this.filePath = filePath;
//	}
//
//	public ArrayList<String> readWords() throws IOException {
//		ArrayList<String> words = new ArrayList<>();
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		String line;
//		while ((line = bufferedReader.readLine()) != null) {
//			StringBuilder currentWord = new StringBuilder();
//			for (int i = 0; i < line.length(); i++) {
//				char currentChar = line.charAt(i);
//				if (currentChar != ' ') {
//					currentWord.append(currentChar);
//				} else {
//					words.add(currentWord.toString());
//					currentWord = new StringBuilder();
//				}
//			}
//			words.add(currentWord.toString()); // Son kelimeyi ekle
//		}
//		bufferedReader.close();
//		return words;
//	}
//
//	public String readLineAt(int lineNumber) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		String line = null;
//		int count = 1;
//		while ((line = bufferedReader.readLine()) != null) {
//			if (count == lineNumber) {
//				bufferedReader.close();
//				return line;
//			}
//			count++;
//		}
//		bufferedReader.close();
//		return null;
//	}
//}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NKReader {
    private String filePath;

    public NKReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String>readWords() throws IOException {
        ArrayList<String> wordsList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = getWordsFromLine(line);
                for (String word : words) {
                    wordsList.add(word);
                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return wordsList;
    }

    public String readLineAt(int lineNumber) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = null;
            int count = 1;
            while ((line = bufferedReader.readLine()) != null) {
                if (count == lineNumber) {
                    return line;
                }
                count++;
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return null;
    }

    private String[] getWordsFromLine(String line) {
        return line.split(" ");
    }
}

