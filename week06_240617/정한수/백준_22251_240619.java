import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] changeList = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    private static int N, K, X, P, cnt;

    private static int[] toArray(int n){
        int[] arr = new int[K];

        for (int i = K - 1; i >= 0; i--){
            arr[i] = n % 10;
            n /= 10;
        }
        return arr;
    }

    private static int toInt(int[] num){
        int n = 0;

        for (int digit : num){
            n = n * 10 + digit;
        }
        return n;
    }

    private static void dfs(int[] num, int idx, int total){
        if (total > P){
            return;
        }

        if (idx == K){
            int n = toInt(num);
            if (total > 0 && n > 0 && n <= N) {
                cnt++;
            }
            return;
        }

        int tmp = num[idx];
        for (int n = 0; n < 10; n++){
            num[idx] = n;
            dfs(num, idx + 1, total + changeList[tmp][n]);
        }
        num[idx] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dfs(toArray(X), 0, 0);
        System.out.println(cnt);
    }

}
