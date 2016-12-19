package algorithms.strings.medium;

import java.util.Scanner;

public class RichieRich {

	private static final int NINE_ASCII_VALUE = 57;
	private String input;
	private Integer changes;

	public RichieRich(String input, Integer changes) {
		this.input = input;
		this.changes = changes;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        RichieRich richieRich = new RichieRich(number, k);
        System.out.println(richieRich.calculateLargestPalindrome());        
        in.close();
		
	}
	
	public String calculateLargestPalindrome() {
		int remainingChanges = changes;
		byte[] bytes = input.getBytes();
		boolean[] changed = new boolean[bytes.length];		
		/** become word in a palindrome. */
		for (int i = 0; i < bytes.length / 2; i++) {
			int mirrorIndex = bytes.length - i - 1;
			if (bytes[i] != bytes[mirrorIndex]) {
				remainingChanges--;
				if (bytes[i] > bytes[mirrorIndex]) {
					bytes[mirrorIndex] = bytes[i];
					changed[mirrorIndex] = true;
				} else {
					bytes[i] = bytes[mirrorIndex];
					changed[i] = true;
				}
			}
		}
		if (remainingChanges>0) {
			for (int i = 0; i < bytes.length / 2 && remainingChanges>0; i++) {
				if (bytes[i]<57){
						if (changed[i]) {
							remainingChanges++;
						}
						if (changed[bytes.length - i - 1]) {
							remainingChanges++;
						}
						if (remainingChanges>=2) {
							bytes[i] = NINE_ASCII_VALUE;
							bytes[bytes.length - i - 1] = NINE_ASCII_VALUE;
							remainingChanges -= 2;
						}
				}
			}
		}
		if (bytes.length%2==1 && remainingChanges>0) {
			bytes[bytes.length/2] = NINE_ASCII_VALUE;
		}
		return (remainingChanges<0)?"-1":new String(bytes);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Integer getChanges() {
		return changes;
	}

	public void setChanges(Integer changes) {
		this.changes = changes;
	}
}
