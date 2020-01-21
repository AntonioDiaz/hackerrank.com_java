package challenges.java.datastructures.javapriorityqueue;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PrioritiesTest {

    List<String> inputList01 = new ArrayList<>();

    @Before
    public void init() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("java_priority_queue_01.txt").getFile());
        System.out.println(file.getAbsolutePath());
        Scanner in = new Scanner(file);
        in.nextLine();
        while (in.hasNextLine()) {
            inputList01.add(in.nextLine());
        }
    }


    @Test
    public void testingList() {
        List<String> list = new ArrayList();
        list.add("first");
        list.add("third");
        assertEquals(2, list.size());
        list.add(1, "second");
        assertEquals(3, list.size());
        assertEquals("second", list.get(1));
        list.remove(0);
        assertEquals("second", list.get(0));
    }

    @Test
    public void testStudentComparator(){
        Student pepe = new Student(11, "Pepe", 2.5);
        Student pepa = new Student(12, "Pepe", 3.5);
        Student juan = new Student(13, "Juan", 2.5);
        Student pepeTheSecond = new Student(15, "Pepe", 2.5);

        assertTrue(pepe.compareTo(pepa)<0);
        assertTrue(juan.compareTo(pepe)>0);
        assertTrue(pepe.compareTo(pepeTheSecond)>0);

    }

    @Test
    public void getStudents() {
        List<Student> students = new Priorities().getStudents(inputList01);
        assertTrue(students!=null);
        assertFalse(students.isEmpty());
        assertEquals(4, students.size());
        assertTrue(students.get(0).getName().equals("Dan"));

    }
}