import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<BracketType> stack = new Stack<>();
        char[] array = s.toCharArray();
        BracketType lastBracket = null;
        for (char ch : array) {
            switch (ch) {
                case '(':
                    stack.push(BracketType.NORMAL);
                    break;
                case '[':
                    stack.push(BracketType.SQUARE);
                    break;
                case '{':
                    stack.push(BracketType.CURLY);
                    break;
                case ')':
                    if (stack.empty()) {
                        return "NO";
                    }
                    lastBracket = stack.pop();
                    if (lastBracket != BracketType.NORMAL) {
                        return "NO";
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return "NO";
                    }
                    lastBracket = stack.pop();
                    if (lastBracket != BracketType.SQUARE) {
                        return "NO";
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return "NO";
                    }
                    lastBracket = stack.pop();
                    if (lastBracket != BracketType.CURLY) {
                        return "NO";
                    }
                    break;
                default:
                    break;
            }
        }
        if (stack.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }
    }

    private enum BracketType {
        NORMAL, SQUARE, CURLY
    }
}
