import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] triangle = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            triangle[i][1] = 1;
            for (int j = 2; j <= n; j++) {
                if (j == n)
                    triangle[i][j] = 1;
                else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        System.out.println(triangle[n][k]);
    }
}
