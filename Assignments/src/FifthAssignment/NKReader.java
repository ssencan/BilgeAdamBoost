package FifthAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NKReader {
	private String filePath;

	public NKReader(String filePath) {
		this.filePath = filePath;
	}

	public ArrayList<String> readWords() throws IOException {
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
