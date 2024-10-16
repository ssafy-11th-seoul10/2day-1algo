import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;


    public static void main(String[] args) throws Exception {
        int answer = 0;
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() >= y) {
//                System.out.println(stack.peek());
                int pop = stack.pop();
                if (pop != y) {
                    answer++;
                }
            }
            stack.push(y);


//            System.out.println(stack);
        }
//        System.out.println(stack);
        while (!stack.isEmpty() && stack.peek() != 0) {
            stack.pop();
            answer++;
        }
        System.out.println(answer);
    }
}
