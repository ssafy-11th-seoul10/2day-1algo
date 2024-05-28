import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][]cost=new int[N+1][N+1];
        int[][]dp=new int[N+1][N+1];
        int[]paint=new int[N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    dp[1][j] = cost[1][j];
                else
                    dp[1][j] = 100_000_000;
            }


            for (int k = 2; k < N + 1; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + cost[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + cost[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + cost[k][2];
                if(k==N){
                    if(i==0){
                        paint[i]=Math.min(dp[N][1],dp[N][2]);
                    }
                    if(i==1){
                        paint[i]=Math.min(dp[N][0],dp[N][2]);
                    }
                    if(i==2){
                        paint[i]=Math.min(dp[N][0],dp[N][1]);
                    }

                }
            }

        }
        System.out.print(Math.min(paint[0],Math.min(paint[1],paint[2])));
    }
}