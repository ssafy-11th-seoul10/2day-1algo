package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241022_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n + 1];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                coins[i] = Integer.parseInt(stk.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[][] d = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                int value = coins[i];
                //동전 하나만을 추가할 경우 예외처리
                if(value<=m) d[i][value] = 1;
                for (int j = 1; j <= m; j++) {
                    d[i][j] += d[i - 1][j];
                    //동전을 추가할 수 있으면 추가한다. (2개 이상)
                    if (j > value) {
                        d[i][j] += d[i][j - value];
                    }
                }
            }
            sb.append(d[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}
