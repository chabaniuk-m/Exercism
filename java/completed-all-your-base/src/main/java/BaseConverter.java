import java.util.ArrayList;
import java.util.List;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class BaseConverter {
    private final int base;
    private final int[] digits;

    public BaseConverter(int base, int[] digits) {
        if (base < 2)
            throw new IllegalArgumentException("Bases must be at least 2.");
        for (int digit : digits)
            if (digit < 0)
                throw new IllegalArgumentException("Digits may not be negative.");
            else if (digit >= base)
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
        this.base = base;
        this.digits = digits;
    }

    public int[] convertToBase(int base) {
        if (base < 2)
            throw new IllegalArgumentException("Bases must be at least 2.");
        final long[] decimal = {0};
        for (int i = 0; i < digits.length; i++) {
            decimal[0] += (long) Math.pow(this.base, digits.length - 1 - i) * digits[i];
        }
        List<Integer> digits = new ArrayList<>() {{
            do {
                add(0, (int) (decimal[0] % base));
                decimal[0] /= base;
            } while (decimal[0] > 0);
        }};
        return digits.stream().mapToInt(el -> el).toArray();
    }
}