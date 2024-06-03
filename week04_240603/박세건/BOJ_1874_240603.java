import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int curVal = 1;
        boolean findResult = true;
        for (int i = 0; i < N; i++) {
            int inputValue = Integer.parseInt(bufferedReader.readLine());
            if (!stack.empty() && inputValue < curVal && inputValue < stack.peek()) {
                findResult = false;
            }
            while (curVal <= inputValue) {
                stack.add(curVal);
                stringBuilder.append("+\n");
                curVal++;
            }
            while (!stack.isEmpty() && stack.peek() >= inputValue) {
                stringBuilder.append("-\n");
                stack.pop();
            }
        }
        if (findResult) {
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("NO");
        }
    }
}
