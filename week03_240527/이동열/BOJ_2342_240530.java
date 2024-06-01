import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2342 {

    private static int cal(int x, int y){
        if(x==0 || y==0){
            return 2;
        }
        if(Math.abs(x-y) == 1   || Math.abs(x-y) == 3){
            return 3;
        }
        if(Math.abs(x-y) == 2){
            return 4;
        }
        if(Math.abs(x-y) == 0){
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> lst = new ArrayList<>();
        while (true) {
            int curr = Integer.parseInt(st.nextToken());
            if(curr == 0){
                break;
            }
            lst.add(curr);
        }
        int N = lst.size();
        int[][][] dp = new int[N][5][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 1_000_000;
                }
            }
        }

        dp[0][lst.get(0)][0] = 2;
        dp[0][0][lst.get(0)] = 2;

        for (int i = 1; i < N; i++) {
            int curr = lst.get(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][curr][k] = Math.min(dp[i][curr][k], dp[i-1][j][k] + cal(j,curr));
                    dp[i][j][curr] = Math.min(dp[i][j][curr], dp[i-1][j][k] + cal(k,curr));
                }
            }
        }
        int answer = 1_000_000;
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                answer = Math.min(answer, dp[N-1][i][j]);
            }
        }
        System.out.println(answer);
    }

}
