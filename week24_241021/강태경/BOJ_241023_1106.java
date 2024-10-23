package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241023_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int[] cost = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            stk = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(stk.nextToken());
            value[i] = Integer.parseInt(stk.nextToken());
        }

        int[] d = new int[100001];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=100000; j++) {
                if(j>=cost[i]){
                    d[j] = Math.max(d[j], d[j - cost[i]] + value[i]);
                }
            }
        }
        for (int i = 1; i <=100000 ; i++) {
            if(d[i]>=c){
                System.out.println(i);
                break;
            }
        }
    }
}
