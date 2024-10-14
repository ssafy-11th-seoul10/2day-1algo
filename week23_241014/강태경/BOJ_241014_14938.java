package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_241014_14938 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());

        int[] item = new int[n+1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(stk.nextToken());
        }
        
        int[][] distance = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], 1500);
            distance[i][i] = 0;
        }
        for (int i = 0; i < r; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            distance[x][y] = cost;
            distance[y][x] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            int value = 0;
            for (int j = 1; j <= n; j++) {
                if(distance[i][j]<=m){
                    value+=item[j];
                }
            }
            maxValue = Math.max(maxValue, value);
        }

        System.out.println(maxValue);
    }
}
