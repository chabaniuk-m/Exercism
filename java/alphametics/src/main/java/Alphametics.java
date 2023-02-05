import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class Alphametics {

    public static void main(String[] args) {
        var a = new Alphametics("SEND + MORE == MONEY");

    }
    private final String puzzle;

    public Alphametics(String puzzle) {
        this.puzzle = puzzle;
    }

    public Map<Character, Integer> solve() throws UnsolvablePuzzleException {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(puzzle);
        List<String> words = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String word = puzzle.substring(start, end);
            words.add(0, word);
            for (char c : word.toCharArray())
                map.put(c, 0);
        }
        int knz = words.size();
        for (int i = 0; i < words.size(); i++) {
            var w = words.get(i);
            for (int j = w.length() - 1; j >= 0; --j) {
                var c = w.charAt(j);
                map.put(c, map.get(c) + (int) Math.pow(10, w.length() - 1 - j) * (i > 0 ? 1 : -1));
            }
        }
        var factors = new ArrayList<Integer>() {{
            addAll(map.values());
        }};
        for (var p : digitPermutation(map.size())) {
            if (p.subList(0, knz).contains(0))
                continue;
            int sum = 0;
            for (int i = 0; i < factors.size(); i++) {
                sum += factors.get(i) * p.get(i);
            }
            if (sum == 0) {
                Map<Character, Integer> result = new HashMap<>();
                var keys = new ArrayList<Character>() {{
                    addAll(map.keySet());
                }};
                for (int i = 0; i < keys.size(); i++) {
                    result.put(keys.get(i), p.get(i));
                }
                return result;
            }
        }
        throw new UnsolvablePuzzleException();
    }

    private List<List<Integer>> digitPermutation(int n) {
        List<List<Integer>> permutations = new ArrayList<>((int) Math.pow(10, n));
        addPermutation(permutations, new ArrayList<>(), n);
        return permutations;
    }

    private void addPermutation(List<List<Integer>> permutations, List<Integer> permutation, int left) {
        if (left == 0) {
            permutations.add(permutation);
        } else {
            for (int i = 0; i < 10; i++) {
                final int digit = i;
                addPermutation(permutations, new ArrayList<>(){{
                    addAll(permutation);
                    add(digit);
                }}, left - 1);
            }
        }
    }
}