package challenges.integerpalindrome;

public class IntegerPalindrome {
    IntegerPalindrome() {}

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int counter = (int) Math.log10(x);

        int modulo;
        int tenth = x;

        double result = 0;

        while (tenth != 0) {
            modulo = tenth % 10; // 1
            tenth = tenth / 10;  // 0

            result += modulo * Math.pow(10, counter);
            counter--;
        }

        return result == (double)x;
    }
}

