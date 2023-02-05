/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class Atbash {
    private static final char a = 'a';

    public String encode(String text) {
        StringBuilder encoded = new StringBuilder(text.length() * 3 / 2);
        int k = 0;
        for (char c : text.toLowerCase().toCharArray())
            if (Character.isAlphabetic(c)) {
                k += 1;
                encoded.append((char) (25 - (c - a) + 'a'));
                if (k % 5 == 0)
                    encoded.append(' ');
            } else if (Character.isDigit(c)) {
                k += 1;
                encoded.append(c);
                if (k % 5 == 0)
                    encoded.append(' ');
            }
        return encoded.charAt(encoded.length() - 1) == ' ' ? encoded.substring(0, encoded.length() - 1) : encoded.toString();
    }

    public String decode(String text) {
        return encode(text).replaceAll("\\s", "");
    }
}