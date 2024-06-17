import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
        }
        sb.append(dp[n]).append("\n");

        List<Integer> path = new ArrayList<>();
        for (int i = n; i >= 1; i = prev[i]) {
            path.add(i);
        }
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
