import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (a + b <= N + 1) {

            Deque<Integer> deque = new LinkedList<>();
            for (int i = b; i >= 1; i--) {
                if (i == b) {
                    deque.addLast(Math.max(a, b));
                } else {
                    deque.addLast(i);
                }
            }
            for (int i = a - 1; i >= 1; i--) {
                deque.addFirst(i);
            }
//        for (Integer i : deque) {
//            System.out.print(i + " ");
//        }
            etc(deque);

            for (Integer i : deque) {
//                System.out.print(i + " ");
                sb.append(i).append(" ");
            }


        } else {
//            System.out.println(-1);
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static void etc(Deque<Integer> deque) {
        int left = -1;
        if (a == 1) {
            left = deque.pollFirst();
        }
        for (int i = 0; i < N - b - (a - 1); i++) {
            deque.addFirst(1);
        }
        if (a == 1) {
            deque.addFirst(left);
        }
    }
}
