package interview.search;

//https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/


import utils.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class HashTablesIceCreamParlor {

    void whatFlavors(int[] cost, int money) {
        Pair<Integer, Integer> pair = whatFlavorsList(cost, money);
        System.out.println(pair.getKey() + " " + pair.getValue());
    }


    Pair<Integer, Integer> whatFlavorsList(int[] cost, int money) {
        List<Integer> costList = Arrays.stream(cost).boxed().collect(Collectors.toList());
        Set<Integer> costSet = new HashSet<>(costList);
        for (int i = 0; i < cost.length; i++) {
            Integer firstIceCreamPrice = cost[i];
            Integer secondIceCreamPrice = money - firstIceCreamPrice;
            //costList.remove(i);
            if (costSet.contains(secondIceCreamPrice)) {
                for (int j = 0; j < cost.length; j++) {
                    if (i!=j && cost[j]== secondIceCreamPrice) {
                        return new Pair<>(i+1, j+1);
                    }
                }
            }
            //costList.add(i, firstIceCreamPrice);
        }
        return null;
    }

}
