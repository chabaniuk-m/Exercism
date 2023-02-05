/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class Bob {
    private static boolean isSpace(String s) {
        for (char c : s.toCharArray())
            if (!Character.isSpaceChar(c))
                return false;
        return true;
    }

    private static boolean isUpper(String s) {
        boolean atLeastOneLetter = false;
        for (char c : s.toCharArray())
            if (Character.isAlphabetic(c)) {
                atLeastOneLetter = true;
                if (!Character.isUpperCase(c))
                    return false;
            }
        return atLeastOneLetter;
    }

    public String hey(String text) {
        text = text.trim();
        if (isSpace(text)) return "Fine. Be that way!";
        if (isUpper(text)) return text.charAt(text.length() - 1) == '?' ? "Calm down, I know what I'm doing!" : "Whoa, chill out!";
        return text.charAt(text.length() - 1) == '?' ? "Sure." : "Whatever.";
    }
}