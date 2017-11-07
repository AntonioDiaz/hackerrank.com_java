package algorithms.strings.easy;

import java.util.Scanner;

public class MarsExploration {
	
	public MarsExploration(String signal) {
		super();
		this.signal = signal;
	}

	private String signal; 
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		MarsExploration marsExploration = new MarsExploration(in.next());
		System.out.println(marsExploration.changedLetters());		
		in.close();		
	}
	
	public int changedLetters(){
		byte[] bytes = this.signal.getBytes();
		int changedLettersCount = 0;
		for (int i = 0; i < bytes.length; i++) {
			int positionInSos = i % 3;
			if ((positionInSos==0 || positionInSos==2) && bytes[i]!=83) {
				changedLettersCount ++;
			}
			if ((positionInSos==1) && bytes[i]!=79) {
				changedLettersCount ++;				
			}
		}
		return changedLettersCount;
	}	
}
