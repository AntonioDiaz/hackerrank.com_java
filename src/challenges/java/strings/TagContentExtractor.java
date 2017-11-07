package challenges.java.strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Antonio Diaz */

public class TagContentExtractor {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = TagContentExtractor.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "tag_content_extractor.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < testCases; i++) {
			String line = in.nextLine();
			List<String> enclosingContents = findEnclosingContents(line);
			if (enclosingContents==null || enclosingContents.size()==0){
				System.out.println("None");
			} else {
				for (String content : enclosingContents) {
					System.out.println(content);
				}
			}
		}
		in.close();
	}

	private static final String REGEX_TAG_OPEN = "<([^/>]+)>";
	private static final String REGEX_TAG_CLOSE = "</([^/>]+)>";
	private static final Pattern PATTERN_OPEN = Pattern.compile(REGEX_TAG_OPEN);
	private static final Pattern PATTERN_CLOSE = Pattern.compile(REGEX_TAG_CLOSE);
	
	private static List<String> findEnclosingContents(String line) {
		//System.out.println(line);
		List<String> contents = new ArrayList<String>();
		Matcher matcher = PATTERN_OPEN.matcher(line);
//		System.out.println(line);
		while (matcher.find()) {
			/* find the first close tag */
//			System.out.println("group -->" + matcher.group());
//			System.out.println("group 1 -->" + matcher.group(1));
			String tagOpenName = matcher.group(1);
			String lineAux = line.substring(matcher.end());
			Matcher matcherEnd = PATTERN_CLOSE.matcher(lineAux);
			if (matcherEnd.find()) {
				String tagEndName = matcherEnd.group(1);
				if (tagOpenName.equals(tagEndName)) {
					String candidate = lineAux.substring(0, matcherEnd.start());
					if (matcherEnd.start()!=0 && !PATTERN_OPEN.matcher(candidate).find()) {
						contents.add(candidate);
					}
				}
			}
		}
		return contents;
	}

}
