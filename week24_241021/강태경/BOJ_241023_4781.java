package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241023_4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = (int)(Double.parseDouble(stk.nextToken())*100+0.5);

            if(n==0 && m==0) break;

            int[] calorie = new int[n+1];
            int[] cost = new int[n+1];

            for (int i = 1; i <= n; i++) {
                stk = new StringTokenizer(br.readLine());
                calorie[i] = Integer.parseInt(stk.nextToken());
                cost[i]= (int)(Double.parseDouble(stk.nextToken())*100+0.5);
            }

            int[] d = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=m ; j++) {
                    if(j>=cost[i]){
                        d[j] = Math.max(d[j], d[j - cost[i]] + calorie[i]);
                    }
                }
            }
            sb.append(d[m]).append("\n");
        }
        System.out.println(sb);
    }
}
