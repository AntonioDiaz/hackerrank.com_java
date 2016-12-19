package algorithms.implementation.easy;

import java.util.Scanner;

public class LisasWorkbook {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer chapters = in.nextInt();
		Integer exercisesPerPage = in.nextInt();
		Integer specialProblems = 0;
		Integer pages = 1;
		for (int i = 0; i < chapters; i++) {
			Integer exercises = in.nextInt();
			Integer cont = 1;
			while (cont <= exercises) {
				int limit;
				if (cont + exercisesPerPage < exercises) {
					limit = cont + exercisesPerPage;
				} else {
					limit = exercises + 1;
				}
				// System.out.println("--------------------------");
				// System.out.println("pages:" + pages);
				// System.out.println("cont:" + cont);
				// System.out.println("limit:" + limit);
				if (pages >= cont && pages < limit) {
					//System.out.println(pages);
					specialProblems++;
				}
				pages++;
				cont += exercisesPerPage;
			}
		}
		System.out.println(specialProblems);
		in.close();
	}
}