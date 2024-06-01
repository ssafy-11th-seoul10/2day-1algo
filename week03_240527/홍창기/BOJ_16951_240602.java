import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16951_240602 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] heights = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int minCnt = n;

        for (int i = 1; i <= n; i++) {
            int curCnt = 0;

            for (int j = 1; j <= n; j++) {
                int hj = heights[i] - k * (i - j);

                if (hj < 1) {
                    curCnt = -1;
                    break;
                }

                if (heights[j] != hj) {
                    curCnt++;
                }
            }

            if (curCnt != -1) {
                minCnt = curCnt < minCnt ? curCnt : minCnt;
            }
        }

        System.out.println(minCnt);
        br.close();
    }

}
