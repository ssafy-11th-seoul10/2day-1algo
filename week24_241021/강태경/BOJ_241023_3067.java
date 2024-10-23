package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241023_3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n+1];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i++) {
                coins[i] = Integer.parseInt(stk.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] d = new int[m + 1];
            d[0] = 1;
            for (int i = 1; i <= n; i++) {
                int value = coins[i];
                for (int j = value; j <=m ; j++) {
                    d[j] = d[j] + d[j - value];
                }
            }
            sb.append(d[m]).append("\n");
        }
        System.out.println(sb);
    }
}
