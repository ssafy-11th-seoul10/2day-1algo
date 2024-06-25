import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 상담을 하지 않을 경우
            dp[i] = Math.max(dp[i], dp[i - 1]);
            // 하는 경우
            int idx = i + t[i] - 1;
            if (idx <= n) {
                dp[idx] = Math.max(dp[idx], p[i] + dp[i - 1]);
            }
        }
        System.out.println(Math.max(dp[n], dp[n - 1]));
    }
}
