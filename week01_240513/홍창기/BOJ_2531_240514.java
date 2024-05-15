import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531_240514 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n];
        int[] selected = new int[d + 1];
        int curCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (++selected[sushi[i]] == 1) {
                curCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            int curCount2 = curCount + (selected[c] == 0 ? 1 : 0);
            maxCount = curCount2 > maxCount ? curCount2 : maxCount;

            if (--selected[sushi[i]] == 0) {
                curCount--;
            }

            if (++selected[sushi[(i + k) % n]] == 1) {
                curCount++;
            }
        }

        System.out.println(maxCount);
        br.close();
    }

}
