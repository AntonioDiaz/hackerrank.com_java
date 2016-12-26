package security.dificult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import security.easy.KeywordTranspositionCipher;

public class BasicCryptanalysis {

	public static void main(String[] args) throws IOException {
		InputStream input = KeywordTranspositionCipher.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(input);
		
		File wordsFile = new File(properties.getProperty("input.path") + "words.txt");
		Map<Integer, List<String>> wordsMap = new HashMap<Integer, List<String>>();
		Scanner inWords = new Scanner(wordsFile);
		while (inWords.hasNextLine()) {
			String nextLine = inWords.nextLine();
//			System.out.println(nextLine);
			List<String> list;
			if (wordsMap.containsKey(nextLine.length())) {
				list = wordsMap.get(nextLine.length());
			} else {
				list =new ArrayList<String>();
			}
			list.add(nextLine);
			wordsMap.put(nextLine.length(), list);
//			System.out.println(wordsMap);
		}
		
		
		System.out.println(wordsMap);
		/*
	
		File file = new File(properties.getProperty("input.path") + "basic_cryptoanalysis_01.txt");
		
		
		
		Scanner in = new Scanner(file);
		
		String s = in.nextLine();
		System.out.println(s);
		String[] split = s.split(" "); 
		List<LetterFrequency> calculateFrecuency = calculateFrecuency(split);
		System.out.println(calculateFrecuency);
		
		
		in.close();
		*/
	}
	
	private static List<LetterFrequency> calculateFrecuency(String[] wordsList) {
		Map<Character, Integer> mapFrequency = new HashMap<Character, Integer>();
		for (String word : wordsList) {
			char[] charArray = word.toCharArray();
			for (char c : charArray) {
				if (mapFrequency.containsKey(c)) {
					mapFrequency.put(c, mapFrequency.get(c) + 1);
				} else {
					mapFrequency.put(c, 1);
				}
			}
		}
		// System.out.println(mapFrequency);
		Set<Character> keySet = mapFrequency.keySet();
		List<LetterFrequency> list = new ArrayList<LetterFrequency>();
		for (Character character : keySet) {
			LetterFrequency letterFrequency = new LetterFrequency();
			letterFrequency.setLetter(character);
			letterFrequency.setRepetitions(mapFrequency.get(character));
			list.add(letterFrequency);
		}
		Collections.sort(list, new LetterFrequencyComparator());
		// System.out.println("sort list--->" + list);
		return list;
	}	

	static class LetterFrequencyComparator implements Comparator<LetterFrequency> {
		public int compare(LetterFrequency o1, LetterFrequency o2) {
			return o2.getRepetitions().compareTo(o1.repetitions);
		}
	}	
	
	static class LetterFrequency {
		private Character letter;
		private Integer repetitions;

		public Character getLetter() {
			return letter;
		}

		public void setLetter(Character letter) {
			this.letter = letter;
		}

		public Integer getRepetitions() {
			return repetitions;
		}

		public void setRepetitions(Integer repetitions) {
			this.repetitions = repetitions;
		}

		@Override
		public int hashCode() {
			return letter.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			if (other == null)
				return false;
			if (other == this)
				return true;
			if (!(other instanceof LetterFrequency))
				return false;
			return ((LetterFrequency) other).getLetter().equals(this.getLetter());
		}

		@Override
		public String toString() {
			return "LetterFrequency [letter=" + letter + ", repetitions=" + repetitions + "]";
		}
	}	
	
	
	
}
