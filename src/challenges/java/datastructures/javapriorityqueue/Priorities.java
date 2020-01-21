package challenges.java.datastructures.javapriorityqueue;

import java.util.ArrayList;
import java.util.List;

public class Priorities {

    List<Student> getStudents(List<String> events) {
        List<Student> studentList = new ArrayList<>();
        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] s = event.split(" ");
                Student studentToAdd = new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]));
                boolean exit = false;
                for (int i = 0; i < studentList.size() && !exit; i++) {
                    Student student = studentList.get(i);
                    if (studentToAdd.compareTo(student)>0) {
                        studentList.add(i, studentToAdd);
                        exit = true;
                    }
                }
                if (!exit) {
                    studentList.add(studentToAdd);
                }
            } else {
                if (!studentList.isEmpty()) {
                    studentList.remove(0);
                }
            }
        }
        return studentList;
    }
}
