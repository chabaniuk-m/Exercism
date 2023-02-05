import java.util.*;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class Anagram {
    private final String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(Collection<String> words) {
        final var counts = charCount(word.toLowerCase());
        return new ArrayList<>() {{
            for (var w : words)
                if (!Objects.equals(w.toLowerCase(), word.toLowerCase()) &&
                    charCount(w.toLowerCase()).equals(counts)) add(w);
        }};
    }

    private Map<Character, Integer> charCount(final String word) {
        return new HashMap<>(){{
            for (char c : word.toCharArray())
                put(c, containsKey(c) ? get(c) + 1 : 1);
        }};
    }
}