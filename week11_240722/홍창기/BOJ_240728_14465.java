import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240728_14465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n + 1];

        for (int i = 0; i < b; i++) {
            int x = Integer.parseInt(br.readLine());
            cnt[x]++;
        }

        for (int u = 1; u <= n; u++) {
            cnt[u] += cnt[u - 1];
        }

        int minFix = 1000000;

        for (int u = k; u <= n; u++) {
            int curFix = cnt[u] - cnt[u - k];
            minFix = curFix < minFix ? curFix : minFix;
        }

        System.out.println(minFix);
        br.close();
    }

}
