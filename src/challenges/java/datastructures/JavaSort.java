package challenges.java.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JavaSort {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = JavaSort.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_sort.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		Collections.sort(studentList, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				int result;
				if (o1.getCgpa() == o2.getCgpa()) {
					result = o1.getFname().compareTo(o2.getFname());
				} else {
					result = o1.getCgpa() > o2.getCgpa() ? -1 : 1;
				}
				return result;
			};
		});
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
		in.close();
	}
}