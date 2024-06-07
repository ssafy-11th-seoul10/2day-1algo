import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++)
            dp[i] = i;

        // sqrt
        for(int i = 1; i*i < n+1; i++)
            dp[i*i] = 1;

        // dp[n] = dp[n-1] + 1 or dp[n - x*x] + 1
        for(int num = 2; num < n + 1; num++) {

            int temp = dp[num -1] + 1;
            for(int tmp = 1; tmp * tmp <= num; tmp++)
                temp = Math.min(temp, dp[num - tmp * tmp] + 1);

            dp[num] = temp;
        }

        System.out.println(dp[n]);
    }
}
