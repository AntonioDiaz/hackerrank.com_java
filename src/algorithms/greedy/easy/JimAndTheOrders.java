package algorithms.greedy.easy;


//https://www.hackerrank.com/challenges/jim-and-the-orders/problem?isFullScreen=false

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class JimAndTheOrders {

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        // Write your code here
        List<AbstractMap.SimpleEntry<Integer, Integer>> sum = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            sum.add(new AbstractMap.SimpleEntry<>(i + 1, orders.get(i).get(0) + orders.get(i).get(1)));
        }
        return sum.stream()
                .sorted((a, b) -> (a.getValue().equals(b.getValue()) ? (a.getKey() - b.getKey()) : (a.getValue() - b.getValue())))
                .map(AbstractMap.SimpleEntry::getKey)
                .collect(toList());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> orders = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                orders.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = JimAndTheOrders.jimOrders(orders);

/*        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

