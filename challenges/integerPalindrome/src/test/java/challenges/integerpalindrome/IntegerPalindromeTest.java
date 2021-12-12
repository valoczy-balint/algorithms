package challenges.integerpalindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegerPalindromeTest {

    private final IntegerPalindrome integerPalindrome = new IntegerPalindrome();

    @org.junit.jupiter.api.Test
    public void test() {
        assertFalse(integerPalindrome.isPalindrome(2147483647));
        assertTrue(integerPalindrome.isPalindrome(121));
    }
}
