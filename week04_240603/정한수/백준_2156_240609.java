import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N];
        int[][] dp = new int[N + 1][2];

        for (int i = 0; i < N; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = wines[0];
        for (int i = 2; i <= N; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 2][0] + wines[i - 2], dp[i - 2][1]) + wines[i - 1];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

}
