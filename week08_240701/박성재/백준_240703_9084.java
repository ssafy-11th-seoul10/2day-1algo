import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240703_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                dp[i][0] = 1;
                int won = arr[i - 1];
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= won) {
                        dp[i][j] += dp[i][j - won];
                    }
                }
            }

            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }
}
