import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answerSb = new StringBuilder();

    private static int N, K, P, X;
    private static int answerCnt = 0;
    /*
     *   numberPosition[10][7]
     * */
    private static boolean[][] numberPosition = {
            {true, true, true, false, true, true, true},
            {false, false, true, false, false, false, true},
            {false, true, true, true, true, true, false},
            {false, true, true, true, false, true, true},
            {true, false, true, true, false, false, true},
            {true, true, false, true, false, true, true},
            {true, true, false, true, true, true, true},
            {false, true, true, false, false, false, true},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true},
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        findNumberOfCases(K, P, 0);
        System.out.println(answerCnt);
    }

    private static void findNumberOfCases(int position, int p, int cur) {
        if (position == 0) {
            if (cur >= 1 && cur <= N && cur != X) {
                answerCnt++;
            }
            return;
        }

        int val = X / (int) (Math.pow(10, position - 1));
        val %= 10;
//        System.out.println(position + " " + val);
        for (int i = 0; i < 10; i++) {
            int diffCnt = 0;
            for (int j = 0; j < 7; j++) {
                if (numberPosition[i][j] != numberPosition[val][j]) {
                    diffCnt++;
                }
            }
            if (diffCnt <= p) {
                findNumberOfCases(position - 1, p - diffCnt, cur + (int) (Math.pow(10, position - 1) * i));
            }
        }
    }
}
