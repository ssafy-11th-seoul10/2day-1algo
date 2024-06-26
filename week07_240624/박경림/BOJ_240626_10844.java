import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_000;
        int[][] dp = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 1 && j != 0) {
                    dp[i][j] = 1;
                } else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j + 1] % MOD;
                    } else if (j == 9) {
                        dp[i][j] = dp[i - 1][j - 1] % MOD;
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result += dp[n][i]) % MOD;
        }
        System.out.println(result);
    }
}
