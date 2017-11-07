package security.easy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class KeywordTranspositionCipher {
	
	public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) throws IOException {
		InputStream input = KeywordTranspositionCipher.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		File file = new File(properties.getProperty("input.path") + "keyword_transposition_cipher.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String keyword = in.nextLine();
			String ciphertext = in.nextLine();
			String alphabetModified = bytesListToString(stringToBytesList(keyword + ENGLISH_ALPHABET, true));
			List<Byte> stringToBytesList = stringToBytesList(keyword, true);
			String keywordNoRepeated = bytesListToString(stringToBytesList);
			Collections.sort(stringToBytesList);
			String alphabetToCipher = new String();
			for (byte byte1 : stringToBytesList) {
				int position = alphabetModified.indexOf(byte1);
				int blocks = alphabetModified.length()/keywordNoRepeated.length() + 1;
				for (int j = 0; j < blocks; j++) {
					int myIndex = j*keywordNoRepeated.length() + position;
					if (myIndex<alphabetModified.length()) {
						alphabetToCipher +=  alphabetModified.charAt(myIndex);
					}
				}
			}
			for (int j = 0; j < ciphertext.length(); j++) {
					char charAt = ciphertext.charAt(j);
					int indexOf = alphabetToCipher.indexOf((int)charAt);
					if (indexOf>=0) {
						char charAt2 = ENGLISH_ALPHABET.charAt(indexOf);
						System.out.print(charAt2);
					} else {
						System.out.print(" ");
					}
			}
			System.out.println();
		}
		
		in.close();
	}
	
	public static final List<Byte> stringToBytesList (String string, boolean removeRepeated){
		List<Byte> list = new ArrayList<Byte>();
		for (Byte b : string.getBytes()) {
			if (!removeRepeated || !list.contains(b)) {
				list.add(b);
			}
		}
		return list;
	}
	public static final String bytesListToString (List<Byte> list){
		byte[] a = new byte[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
 		return new String(a);
	}
	
}
