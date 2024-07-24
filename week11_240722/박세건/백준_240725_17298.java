import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[] inputArr;
    private static int[] answerArr;
    private static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        inputArr = new int[N];
        answerArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        answerArr[N - 1] = -1;
        stack.push(inputArr[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            int cur = inputArr[i];
            while (!stack.isEmpty()) {
                int top = stack.pop();
                if (top > cur) {
                    stack.push(top);
                    answerArr[i] = top;
                    break;
                }
            }
            if (stack.isEmpty()) {
                answerArr[i] = -1;
            }
            stack.push(cur);
        }
        for (int i = 0; i < answerArr.length; i++) {
            sb.append(answerArr[i]).append(" ");
        }
        System.out.println(sb);
    }


}
