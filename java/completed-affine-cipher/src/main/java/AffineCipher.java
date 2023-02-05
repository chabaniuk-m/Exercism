/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class AffineCipher {
    private static final int a = 'a';
    private static final int m = 26;

    public String encode(String text, int a, int b) {
        if (gcd(a, m) != 1)
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        text = text.toLowerCase();
        StringBuilder encoded = new StringBuilder("");
        for (int i = 0, k = 1; i < text.length(); i++) {
            char x = text.charAt(i);
            if (Character.isAlphabetic(x)) {
                encoded.append((char) ((a * ((int) x - AffineCipher.a) + b) % m + AffineCipher.a));
                if (k % 5 == 0) encoded.append(' ');
                k += 1;
            } else if (Character.isDigit(x)) {
                encoded.append(x);
                if (k % 5 == 0) encoded.append(' ');
                k += 1;
            }
        }
        return encoded.toString().trim();
    }

    public String decode(String text, int a, int b) {
        if (gcd(a, 26) != 1)
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        text = text.toLowerCase();
        StringBuilder decoded = new StringBuilder("");
        for (int i = 0; i < text.length(); i++) {
            char y = text.charAt(i);
            if (Character.isAlphabetic(y)) {
                decoded.append((char) (absm(mmi(a, m) * (y - AffineCipher.a - b), m) + AffineCipher.a));
            } else if (Character.isDigit(y)) {
                decoded.append(y);
            }
        }
        return decoded.toString().trim();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int mmi(int a, int b) {
        for (int i = 1; i < b; i++)
            if ((a * i) % b == 1)
                return i;
        return 1;
    }

    public static int absm(int n, int m) {
        while (n < 0) n += m;
        while (n >= m) n -= m;
        return n;
    }
}
