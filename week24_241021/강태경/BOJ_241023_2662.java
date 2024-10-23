package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_241023_2662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        //투자액, 기업
        int[][] benefits = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            stk.nextToken();
            for (int j = 1; j <= m; j++) {
                benefits[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] d = new int[n + 1];
        //기업번호, 총 투자금액 -> 앞 기업에 투자한 금액
        int[][] tracking = new int[m+1][n+1];

        StringBuilder sb = new StringBuilder();
        //현재 기업
        for (int i = 1; i <= m; i++) {
            //투자할 수 있는 금액
            for (int j = n; j >=1 ; j--) {
                //투자 금액
                for (int k = 1; k <=n ; k++) {
                    if(j>=k){
                        int buf = d[j-k]+benefits[k][i];
                        if(d[j]<buf){
                            d[j] = buf;
                            tracking[i][j] = k;
                        }
                        d[j] = Math.max(d[j], buf);
                    }
                }
            }
        }
        sb.append(d[n]).append("\n");

        Deque<Integer> q = new ArrayDeque<>();
        int money = n;
        for (int i = m; i >=1 ; i--) {
            q.add(tracking[i][money]);
            money-=tracking[i][money];
        }
        while (!q.isEmpty()) {
            sb.append(q.removeLast()).append(" ");
        }
        System.out.println(sb);
    }
}
