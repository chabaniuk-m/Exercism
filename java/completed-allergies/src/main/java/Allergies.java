import java.util.ArrayList;
import java.util.List;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class Allergies {
    private final int allergies;

    public Allergies(int allergies) {
        this.allergies = allergies;
    }

    public boolean isAllergicTo(Allergen allergen) {
        return (allergen.getScore() & allergies) > 0;
    }

    public List<Allergen> getList() {
        return new ArrayList<>() {{
            for (Allergen allergen : Allergen.values())
                if ((allergen.getScore() & allergies) > 0)
                    add(allergen);
        }};
    }
}