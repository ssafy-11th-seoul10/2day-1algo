import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for (int i = 1; i <= 3; i++) dp[i] = 1l;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] > 0) sb.append(dp[n]).append("\n");
            else {
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 3] + dp[i - 2];
                }
                sb.append(dp[n]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
