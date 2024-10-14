import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int answer = 0;

    private static int[][] weights;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        inputSetting();


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    dp[i][j] = (int) Math.min(dp[i][j], ((long) dp[i][k] + dp[k][j]));
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((dp[i][j] == Integer.MAX_VALUE) ? 0 + " " : dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static void inputSetting() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        weights = new int[N][N];
        dp = new int[N][N];
        dpSetting();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a - 1][b - 1] = Math.min(dp[a - 1][b - 1], c);
        }
    }


    private static void dpSetting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }

}
