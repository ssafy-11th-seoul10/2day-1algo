import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9708_240606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int ti = 1; ti <= t; ti++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int[][] table = new int[n + 1][51];

            for (int x = 0; x <= n; x++) {
                table[n][x] = Integer.parseInt(st.nextToken());
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int x = 0; x <= i; x++) {
                    table[i][x] = table[i + 1][x + 1] - table[i + 1][x];
                }
            }

            for (int x = 1; x <= 50; x++) {
                table[0][x] = table[0][x - 1];
            }

            for (int i = 1; i <= n; i++) {
                for (int x = 2; x <= 50; x++) {
                    table[i][x] = table[i][x - 1] + table[i - 1][x - 1];
                }
            }

            sb.append("Case #").append(ti).append(": ").append(table[n][50]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
