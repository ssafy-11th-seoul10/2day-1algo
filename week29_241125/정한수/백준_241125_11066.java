import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int getMinCost(int[] pages, int K){
        // pages의 누적합
        int[] sum = new int[K + 1];
        for (int i = 1; i <= K; i++){
            sum[i] = sum[i - 1] + pages[i - 1];
        }

        // dp[i][j]: i장 ~ j장을 합치는 데 필요한 최소 비용
        int[][] dp = new int[K + 1][K + 1];
        for (int to = 1; to <= K; to++){
            for (int from = to - 1; from > 0; from--){
                dp[from][to] = INF;
                for (int via = from; via < to; via++){
                    dp[from][to] = Math.min(dp[from][to], dp[from][via] + dp[via + 1][to] + sum[to] - sum[from - 1]);
                }
            }
        }
        return dp[1][K];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] pages = new int[K];
            for (int i = 0; i < K; i++){
                pages[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getMinCost(pages, K)).append("\n");
        }
        System.out.print(sb);
    }
    
}
