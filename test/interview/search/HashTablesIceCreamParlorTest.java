package interview.search;

import javafx.util.Pair;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HashTablesIceCreamParlorTest {

    @Test
    public void whatFlavorsTest_01() {
        int [] prices = new int[]{1, 4, 5, 3, 2};
        int money = 4;
        Pair<Integer, Integer> pair = new HashTablesIceCreamParlor().whatFlavorsList(prices, money);
        assertEquals(1, pair.getKey().intValue());
        assertEquals(4, pair.getValue().intValue());
    }

    @Test
    public void whatFlavorsTest_02() {
        int [] prices = new int[]{2, 2, 4, 3};
        int money = 4;
        Pair<Integer, Integer> pair = new HashTablesIceCreamParlor().whatFlavorsList(prices, money);
        assertEquals(1, pair.getKey().intValue());
        assertEquals(2, pair.getValue().intValue());
    }

    @Test
    public void whatFlavorsTest_03() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        List<Pair<Integer, Integer>> solutionsPairs = getSolutions();
        File file = new File(classLoader.getResource("hash_tables_ice_cream_parlor_input.txt").getFile());
        Scanner in = new Scanner(file);
        int testNum = in.nextInt();
        assertEquals(34, testNum);
        for (int i = 0; i < testNum; i++) {
            int money = in.nextInt();
            in.nextLine();
            in.nextLine();
            List<Integer> collect = Arrays.stream(in.nextLine().split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            int[] prices = collect.stream().mapToInt(n -> n).toArray();
            Pair<Integer, Integer> pair = new HashTablesIceCreamParlor().whatFlavorsList(prices, money);
            assertEquals(pair, solutionsPairs.get(i));
        }
    }

    private List<Pair<Integer, Integer>> getSolutions() throws FileNotFoundException {
        List<Pair<Integer, Integer>> solutions = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File fileSolutions = new File(classLoader.getResource("hash_tables_ice_cream_parlor_solution.txt").getFile());
        Scanner in = new Scanner(fileSolutions);
        while (in.hasNextLine()) {
            String myLine = in.nextLine();
            int key = Integer.parseInt(myLine.split(" ")[0]);
            int value = Integer.parseInt(myLine.split(" ")[1]);
            solutions.add(new Pair<>(key, value));
        }
        return solutions;
    }

}