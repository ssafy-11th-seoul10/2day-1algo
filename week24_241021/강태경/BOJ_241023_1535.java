package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241023_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lose = new int[n+1];
        int[] gain = new int[n+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            lose[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            gain[i] = Integer.parseInt(stk.nextToken());
        }
        int[] d = new int[101];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=100 ; j++) {
                if(j>=lose[i]){
                    d[j-lose[i]] = Math.max(d[j-lose[i]], d[j] + gain[i]);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <=100 ; i++) {
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }
}
