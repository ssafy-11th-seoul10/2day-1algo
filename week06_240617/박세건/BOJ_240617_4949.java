import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) throws IOException {
        while (true) {
            boolean answer = true;
            Stack<Character> stack = new Stack<>();
            String tmpString = bufferedReader.readLine();
            if (tmpString.equals(".")) {
                break;
            }
            for (int i = 0; i < tmpString.length(); i++) {
                char tmpChar = tmpString.charAt(i);
                if (tmpChar == '[' || tmpChar == '(') {
                    stack.push(tmpChar);
                } else if (tmpChar == ']' || tmpChar == ')') {
                    if (stack.isEmpty()) {
                        answer = false;
                        break;
                    }
                    if (Math.abs(tmpChar - stack.peek()) > 2) {
                        answer = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                answer = false;
            }
            if (answer) {
                System.out.println("yes");

            } else {
                System.out.println("no");
            }
        }

    }
}s
