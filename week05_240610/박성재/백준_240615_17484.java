import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_240615_17484 {
    static int n;
    static int m;
    static int[][] arr;
    static int answer;
    static int[] rx = { -1, 0, 1 };
    static int[] ry = { 1, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            dfs(0, i, -1, 0);
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(int ny, int nx, int d, int sum) {
        if (ny == n) {
            answer = Math.min(answer, sum);
        } else {
            for (int i = 0; i < 3; i++) {
                if (isArea(nx + rx[i]) && i != d) {
                    dfs(ny + 1, nx + rx[i], i, sum + arr[ny][nx]);
                }
            }
        }
    }

    static boolean isArea(int x) {
        if (x < 0 || x >= m)
            return false;
        return true;
    }
}
