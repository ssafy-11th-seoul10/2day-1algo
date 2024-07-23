import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17404_240723 {
    public static void main(String[] args) throws IOException {

        //1번 집과 N번 집이 겹치지 않아야 함
        //->1번집을 정하고 시작

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        int[][] d = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], (int) 1e9);
        }
        //1번집이 빨강, N번집은 노랑 or 초록
        d[0][0] = cost[0][0];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + cost[i][2];
        }
        answer = Math.min(d[n - 1][1], d[n - 1][2]);

        //1번집이 노랑, N번집은 빨강 or 초록
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], (int) 1e9);
        }
        d[0][1] = cost[0][1];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + cost[i][2];
        }
        answer = Math.min(answer, d[n - 1][0]);
        answer = Math.min(answer, d[n - 1][2]);

        //1번집이 초록, N번집은 빨강 or 노랑
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], (int) 1e9);
        }
        d[0][2] = cost[0][2];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + cost[i][2];
        }
        answer = Math.min(answer, d[n - 1][0]);
        answer = Math.min(answer, d[n - 1][1]);

        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }
}
