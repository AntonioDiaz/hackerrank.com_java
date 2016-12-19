package algorithms.implementation.easy;

import java.util.Scanner;

public class AcmIcpcTeam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int peopleNum = in.nextInt();
		int topicsNum = in.nextInt();
		boolean topic[][] = new boolean[peopleNum][topicsNum];
		for (int i = 0; i < peopleNum; i++) {
			String line = in.next();
			for (int j = 0; j < line.length(); j++) {
				topic[i][j] = line.charAt(j) == '1' ? true : false;
			}
		}
		int maxTopic = -1;
		int teamsNum = 0;
		for (int i = 0; i < peopleNum; i++) {
			for (int j = i+1; j < peopleNum; j++) {
				int topicsCommons = 0;
				for (int n = 0; n < topicsNum; n++) {
					if (topic[i][n] || topic[j][n]) {
						++topicsCommons;
					}
				}
				if (topicsCommons>=maxTopic) {
					if (topicsCommons==maxTopic) {
						teamsNum++;
					} else {
						maxTopic = topicsCommons;
						teamsNum = 1;
					}
				}
			}
		}
		System.out.println(maxTopic);
		System.out.println(teamsNum);
		in.close();
    }   
}
