import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240629_19951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] h = new int[n + 1];

        for (int x = 1; x <= n; x++) {
            h[x] = Integer.parseInt(st.nextToken());
        }

        int[] dh = new int[n + 2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dh[a] += k;
            dh[b + 1] -= k;
        }

        StringBuilder sb = new StringBuilder();

        for (int x = 1; x <= n; x++) {
            dh[x] += dh[x - 1];
            sb.append(h[x] + dh[x]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}
