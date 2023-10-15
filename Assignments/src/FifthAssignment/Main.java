package FifthAssignment;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		Bir reader extension 'ı yazılması gerekiyor (NKReader mesela)
//		dosyadaki bütün kelimeleri okuma yapabilmesi ve arraylist 'e atayabilmesi gerekiyor
//		dosyadan istediğim satır numarasını okuyabilmesi gerekiyor
//
//		String 'lerin Split fonksiyonu kullanılmayacak
//		Files.readAllLines kullanılmayacak
//		aşağıdaki gibi bir kod yazabilmeliyim
//
//		NKReader myReader = new NKReader("C:/dosya.txt");
//		ArrayList<String> kelimeler = myReader.readWords();
//		String satir = myReader.readLineAt(4);

		try {
			NKReader myReader = new NKReader("C:\\Users\\ssenc\\Desktop\\Shortcuts.txt");
			ArrayList<String> kelimeler = myReader.readWords();
			String satir = myReader.readLineAt(4);
			System.out.println(kelimeler);
			System.out.println(satir);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
