import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_240728_23057 {

    static int n, m;
    static int[] cards;
    static HashSet<Integer> set = new HashSet<Integer>();

    static void recur(int depth, int curSum) {
        if (depth == n) {
            set.add(curSum);
            return;
        }

        recur(depth + 1, curSum + cards[depth]);
        recur(depth + 1, curSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            m += cards[i];
        }

        recur(0, 0);

        System.out.println(m - set.size() + 1);
        br.close();
    }

}
