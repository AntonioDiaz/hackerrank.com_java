package algorithms.easy;
import java.io.IOException;
import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) throws IOException {
		//InputStream input = CavityMap.class.getClassLoader().getResourceAsStream("config.properties");
		//Properties properties = new Properties();
		//properties.load(input);
		//File file = new File(properties.getProperty("input.path") + "cavity_map.txt");
		Scanner in = new Scanner(System.in);
		int numLines = in.nextInt();
		String grid[] = new String[numLines];
		for (int i = 0; i < numLines; i++) {
			grid[i] = in.next();
		}
		int numColumns = grid[0].length();
		char charactersGrid[][] = new char[numLines][numColumns];
		char charactersGridNew[][] = new char[numLines][numColumns];
		for (int i = 0; i < numLines; i++) {
			charactersGrid[i] = grid[i].toCharArray();
		}
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				Character myChar = charactersGrid[i][j];
				if (i != 0 && i != numLines - 1 && j != 0 && j != numColumns - 1) {
					int currentVal = Character.getNumericValue(charactersGrid[i][j]);
					int prevVal = Character.getNumericValue(charactersGrid[i][j - 1]);
					int nextVal = Character.getNumericValue(charactersGrid[i][j + 1]);
					int upVal = Character.getNumericValue(charactersGrid[i-1][j]);
					int downVal = Character.getNumericValue(charactersGrid[i+1][j]);
					if (currentVal > prevVal && currentVal > nextVal && currentVal > upVal && currentVal > downVal) {
						myChar = 'X';
					}
				}
				charactersGridNew[i][j] = myChar;
			}
		}
		for (int i = 0; i < numLines; i++) {
			System.out.println(String.valueOf(charactersGridNew[i]));
		}
		in.close();
	}
}
