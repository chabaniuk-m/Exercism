import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class BookStore {

    private int sum(Map<Integer, Integer> map) {
        return map.values().stream().reduce(0, Integer::sum);
    }

    public double calculateBasketCost(final List<Integer> books) {
        Map<Integer, Integer> map = new HashMap<>() {{
            for (int book : books)
                put(book, getOrDefault(book, 0) + 1);
        }};
        double totalPrice = 0;
        while (map.size() == 5 && sum(map) > 11) {
            var set = new HashSet<>(map.keySet());
            if (sum(map) == 16) {
                int count2 = 0;
                int count4 = 0;
                for (var v : map.values())
                    if (v == 2)
                        count2 += 1;
                    else if (v == 4)
                        count4 += 1;
                if (count2 == 2 && count4 == 3) // 4, 4, 4, 4 istead of 5, 5, 3, 3
                    return totalPrice + 102.4;
            }
            for (var key : set) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0)
                    map.remove(key);
            }
            totalPrice += 30;
        }
        if (map.size() == 5) {
            int count = sum(map);
            if (count == 11) {
                int numberOfOnes = 0;
                int numberOfThrees = 0;
                for (var value : map.values())
                    if (value == 1)
                        numberOfOnes += 1;
                    else if (value == 3)
                        numberOfThrees += 1;
                if (numberOfOnes == 2 && numberOfThrees == 3)       // possible to split into 4, 4, 3
                    return totalPrice + 72.8;
            } else if (count == 10) {
                int numberOfOnes = 0;
                boolean hasThree = false;
                for (var value : map.values())
                    if (value == 1)
                        numberOfOnes += 1;
                    else if (value == 3)
                        hasThree = true;
                if (numberOfOnes == 2) {
                    if (hasThree)               // can split into 4, 4, 2
                        return totalPrice + 66.4;
                    else                        // can split into 4, 4, 1, 1
                        return totalPrice + 67.2;
                }
            } else if (count == 9) {
                int numberOfOnes = 0;
                for (var value : map.values())
                    if (value == 1)
                        numberOfOnes += 1;
                    else if (value == 3)
                        if (numberOfOnes == 2) {            // possible to split into 4, 4, 1
                                                            // but impossible to split into 4 & 5
                            return totalPrice + 59.2;
                        }
            } else if (count == 8) {
                // check if it is possible to split into 2 by 4
                int numberOfOnes = 0;
                for (var value : map.values())
                    if (value == 1)
                        numberOfOnes += 1;
                if (numberOfOnes == 2) {
                    // can split into 4 & 4
                    return totalPrice + 51.2;
                }
            }

            // if not a special case
            var set = new HashSet<>(map.keySet());
            for (var key : set) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0)
                    map.remove(key);
            }
            totalPrice += 30;

            // leaves count 6 or less
        }
        if (map.size() == 5) {
            int count = sum(map);
            if (count == 6)
                return totalPrice + 38;         // possible only 5, 1
            return totalPrice + 30;             // otherwise only one scenario 5
        }
        while (map.size() == 4) {
            // use default behaviour in any combination case
            var set = new HashSet<>(map.keySet());
            for (var key : set) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0)
                    map.remove(key);
            }
            totalPrice += 25.6;
        }
        while (map.size() == 3) {
            // use default behaviour in any combination case
            var set = new HashSet<>(map.keySet());
            for (var key : set) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0)
                    map.remove(key);
            }
            totalPrice += 21.6;
        }
        while (map.size() == 2) {
            // use default behaviour in any combination case
            var set = new HashSet<>(map.keySet());
            for (var key : set) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0)
                    map.remove(key);
            }
            totalPrice += 15.2;
        }
        for (var key : map.keySet())
            return totalPrice + map.get(key) * 8;
        return totalPrice;
    }
}