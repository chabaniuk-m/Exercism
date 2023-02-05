import java.util.List;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/
public class BinarySearch {
    private final List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int element) throws ValueNotFoundException {
        int begin = 0;
        int end = list.size() - 1;
        if (end == -1)
            throw new ValueNotFoundException("Value not in array");
        while (begin < end - 1) {
            int mid = (begin + end) / 2;
            int val = list.get(mid);
            if (val == element) return  mid;
            else if (val < element) begin = mid;
            else end = mid;
        }
        if (list.get(end) == element) return end;
        if (list.get(begin) == element) return begin;
        throw new ValueNotFoundException("Value not in array");
    }
}