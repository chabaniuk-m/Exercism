import java.util.Arrays;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String num = "" + numberToCheck;
        int n = num.length();
        int sum = 0;
        for (char c : num.toCharArray())
            sum += Math.pow(c - '0', n);
        return sum == numberToCheck;
    }

}
