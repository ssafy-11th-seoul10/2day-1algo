import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17951_240609 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 10_000_000;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int intervalCnt = 0;
            int curScoreSum = 0;

            for (int i = 0; i < n; i++) {
                curScoreSum += scores[i];

                if (curScoreSum >= mid) {
                    curScoreSum = 0;
                    intervalCnt++;
                }
            }

            if (intervalCnt >= k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
        br.close();
    }

}
